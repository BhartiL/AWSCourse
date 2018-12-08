package lambda;

import org.apache.http.client.CredentialsProvider;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.csye6225.fall2018.courseservice3.datamodel.Board;
import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice3.service.BoardService;
import com.csye6225.fall2018.courseservice3.service.CourseService;

public class AnnouncementHandler implements RequestHandler<DynamodbEvent, Integer> {
	
	
    @Override
    public Integer handleRequest(DynamodbEvent event, Context context) {
        try {
    	context.getLogger().log("Received event: " + event);
        
        
        for (DynamodbStreamRecord record : event.getRecords()) {
            context.getLogger().log(record.getEventID());
            context.getLogger().log(record.getEventName());
            context.getLogger().log(record.getDynamodb().toString());
            String text = record.getDynamodb().getNewImage().get("announcementText").getS();
            String boardId = record.getDynamodb().getNewImage().get("boardId").getS();
            BoardService bs = new BoardService();
            
            CourseService cs = new CourseService();
            Course course = cs.getCourse(bs.getBoard(boardId).getCourseId());
            String topic = course.getNotificationTopic();
            
            AmazonSNS snsClient =  AmazonSNSClient.builder().withRegion(Regions.US_EAST_2).build();
    		//snsClient.setRegion(Region.getRegion(Regions.US_EAST_2));
    		PublishRequest publishRequest = new PublishRequest(topic, text);
    		PublishResult publishResult = snsClient.publish(publishRequest);
    		//print MessageId of message published to SNS topic
    		System.out.println("MessageId - " + publishResult.getMessageId());
        }}catch(Exception e) {
        	System.out.println("Error executing lambda " );
        	e.printStackTrace();
        	return 400;
        }
        
        return event.getRecords().size();
    }
    
    
}