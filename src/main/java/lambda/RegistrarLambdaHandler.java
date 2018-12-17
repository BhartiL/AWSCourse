package lambda;

import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RegistrarLambdaHandler implements RequestHandler<Map<String, Object>, Object> {

	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {

		try {
			String offeringId = (String) input.get("courseId");
			String department = (String) input.get("department");

			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(
					"http://ladhanib-assignment4.us-east-2.elasticbeanstalk.com/webapi/registrar/registerOffering");
			String st = "{ \n" + "\"offeringId\": \"%s\",\n" + "\"offeringType\": \"%s\",\n"
					+ " \"department\": \"%s\",\n" + "\"perUnitPrice\":\"%s\"" + " }";
			String json = String.format(st, offeringId, "Course", department, "200");
			System.out.println("Body " + json);
			StringEntity entity = new StringEntity(json);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			CloseableHttpResponse response = client.execute(httpPost);
			System.out.println(response);
			return response;

		} catch (Exception ex) {
			ex.printStackTrace();

			return null;
		}

	}
}
