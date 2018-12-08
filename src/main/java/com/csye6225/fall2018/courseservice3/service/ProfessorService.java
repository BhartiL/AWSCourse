package com.csye6225.fall2018.courseservice3.service;

import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.csye6225.fall2018.courseservice3.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice3.datamodel.Professor;

public class ProfessorService {

	DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;

	public ProfessorService() {
		dynamoDB = new DynamoDBConnector();
		DynamoDBConnector.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}

	// adding professor
	public Professor addProfessor(Professor prof) {
		mapper.save(prof);
		return prof;
	}

	// Getting One Professor
	public Professor getProfessor(String profId) {
		try {
			Professor partitionKey = new Professor();
			partitionKey.setProfessorId(profId);
			DynamoDBQueryExpression<Professor> queryExpression = new DynamoDBQueryExpression<>();
			queryExpression.setHashKeyValues(partitionKey);
			queryExpression.setIndexName("professorId-index");
			queryExpression.setConsistentRead(false);
			List<Professor> prof = mapper.query(Professor.class, queryExpression);
			if (prof == null || prof.isEmpty())
				throw new Exception("No professor found with professor id " + profId);
			return prof.get(0);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	// Deleting a professor
	public Professor deleteProfessor(String profId) {
		Professor prof = getProfessor(profId);
		String id = prof.getId();
		Professor objTodelete = mapper.load(Professor.class, id);
		objTodelete.setId(id);
		mapper.delete(objTodelete);
		System.out.println("This professor is deleted");
		return prof;
	}

	// Updating Professor Info
	public Professor updateProfessorInformation(String profId, Professor prof) {
		Professor profdetails = this.getProfessor(profId);
		prof.setId(profdetails.getId());
		prof.setProfessorId(profId);
		mapper.save(prof);
		return prof;
	}
}
