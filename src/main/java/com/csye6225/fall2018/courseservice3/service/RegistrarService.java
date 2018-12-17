package com.csye6225.fall2018.courseservice3.service;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.fall2018.courseservice3.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice3.datamodel.Registrar;

public class RegistrarService {
	DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;

	public RegistrarService() {
		dynamoDB = new DynamoDBConnector();
		DynamoDBConnector.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}

	public Registrar addRegistrar(Registrar reg) {
		mapper.save(reg);
		return reg;
	}

	public List<Registrar> getRegistrar() {
		try {
			DynamoDBScanExpression queryExpression = new DynamoDBScanExpression();
			List<Registrar> registrars = mapper.scan(Registrar.class, queryExpression);

			return registrars;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}

	}

}
