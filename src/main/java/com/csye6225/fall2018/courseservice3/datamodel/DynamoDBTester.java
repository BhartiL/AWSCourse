package com.csye6225.fall2018.courseservice3.datamodel;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class DynamoDBTester {

	static AmazonDynamoDB dynamoDB;
	
	public static void init()throws Exception{
		ProfileCredentialsProvider credentialsProvider=new ProfileCredentialsProvider();
		credentialsProvider.getCredentials();
		
		dynamoDB=AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(credentialsProvider)
				.withRegion("us-east-2")
				.build();
		
	}
	public static void main(String[]args)throws Exception{
		init();
		String tableName="student";
		GetItemRequest getItemRequest=new GetItemRequest();
		Map<String,AttributeValue>itemToFetch=new HashMap<>();
		itemToFetch.put("StudentID", new AttributeValue().withS("127"));
		getItemRequest.setKey(itemToFetch);
		getItemRequest.setTableName(tableName);
		GetItemResult res= dynamoDB.getItem(getItemRequest);
		System.out.println("Result"+res);
		
		//dynamoDB.getItem(getItemRequest)
	}

}
