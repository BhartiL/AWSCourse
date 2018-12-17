package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;

import com.amazonaws.services.stepfunctions.*;
import com.amazonaws.services.stepfunctions.model.StartExecutionRequest;

public class CourseHandler implements RequestHandler<DynamodbEvent, Integer> {

//    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
//
//    public CourseHandler() {}
//
//    // Test purpose only.
//    CourseHandler(AmazonS3 s3) {
//        this.s3 = s3;
//    }

	@Override
	public Integer handleRequest(DynamodbEvent event, Context context) {
		try {
			context.getLogger().log("Received event: " + event);

			for (DynamodbStreamRecord record : event.getRecords()) {
				context.getLogger().log(record.getEventID());
				context.getLogger().log(record.getEventName());
				context.getLogger().log(record.getDynamodb().toString());

				String id = record.getDynamodb().getNewImage().get("id").getS();
				String courseId = record.getDynamodb().getNewImage().get("courseId").getS();
				String professorId = record.getDynamodb().getNewImage().get("professorId").getS();
				String taId = record.getDynamodb().getNewImage().get("taId").getS();
				String department = record.getDynamodb().getNewImage().get("department").getS();
				boolean hasBoardId = record.getDynamodb().getNewImage().containsKey("boardId");
				boolean listExists = record.getDynamodb().getNewImage().containsKey("listOfRegisteredStudents");
				boolean isListOfStudentsNotEmpty = false;
				if (listExists)
					isListOfStudentsNotEmpty = !record.getDynamodb().getNewImage().get("listOfRegisteredStudents")
							.getL().isEmpty();
				boolean hasNotificationTopic = record.getDynamodb().getNewImage().containsKey("notificationTopic");
				/*
				 * String text =
				 * record.getDynamodb().getNewImage().get("announcementText").getS(); String
				 * boardId = record.getDynamodb().getNewImage().get("boardId").getS();
				 */
				String input = "{\"id\" : \"" + id + "\", " + "\"courseId\" : \"" + courseId + "\" , "
						+ "\"department\" : \"" + department + "\"," + "\"professorId\" : \"" + professorId + "\","
						+ "\"taId\" : \"" + taId + "\"}";
				if (!(hasBoardId || isListOfStudentsNotEmpty || hasNotificationTopic)) {
					final AWSStepFunctions client = AWSStepFunctionsClientBuilder.defaultClient();
					StartExecutionRequest st = new StartExecutionRequest().withInput(input).withName("lambdaTest-" + id)
							.withStateMachineArn(
									"arn:aws:states:us-east-2:273316780785:stateMachine:Assignment4WithBonus");
					client.startExecution(st);

				} else {
					System.out.println("Either of 3 fields isn't empty. Exiting..");
					return -1;
				}

			}
		} catch (Exception e) {
			System.out.println("Error executing lambda ");
			e.printStackTrace();
			return 400;
		}

		return event.getRecords().size();
	}

}