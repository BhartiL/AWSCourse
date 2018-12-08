package com.csye6225.fall2018.courseservice3.datamodel;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDBConnector {

	static AmazonDynamoDB dynamoDB;

	public static void init() {
		try {
			if (dynamoDB == null) {
				ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
				credentialsProvider.getCredentials();

				dynamoDB = AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider)
						.withRegion("us-east-2").build();
			//dynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
				 System.out.println("I created the client");

			}

		} catch (Exception e) {
			//e.printStackTrace();
			if (dynamoDB == null) {
				InstanceProfileCredentialsProvider credentialsProvider = new InstanceProfileCredentialsProvider(false);
				credentialsProvider.getCredentials();

				dynamoDB = AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider)
						.withRegion("us-east-2").build();
				System.out.println("I created the client");
			}
		}

	}

	public AmazonDynamoDB getClient() {
		return dynamoDB;
	}

}
