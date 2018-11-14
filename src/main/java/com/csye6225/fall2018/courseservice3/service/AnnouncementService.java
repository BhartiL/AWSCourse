package com.csye6225.fall2018.courseservice3.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.csye6225.fall2018.courseservice3.datamodel.Announcement;
import com.csye6225.fall2018.courseservice3.datamodel.DynamoDBConnector;

public class AnnouncementService {
	DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;

	public AnnouncementService() {
		dynamoDB = new DynamoDBConnector();
		DynamoDBConnector.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}

	// adding announcement
	public Announcement addAnnouncement(Announcement an) {
		mapper.save(an);
		return an;
	}

	// getting specific announcement
	public Announcement getAnnouncement(String announcementId, String boardId) {
		try {
			Announcement announcementObj = new Announcement();
			announcementObj.setAnnouncementId(announcementId);
			announcementObj.setBoardId(boardId);
			DynamoDBQueryExpression<Announcement> queryExpression = new DynamoDBQueryExpression<>();
			queryExpression.setHashKeyValues(announcementObj);
			Condition rangeKeyCondition = new Condition().withComparisonOperator(ComparisonOperator.EQ.toString())
					.withAttributeValueList(new AttributeValue().withS(announcementId));
			queryExpression.withRangeKeyCondition("announcementId", rangeKeyCondition);
			queryExpression.setIndexName("boardId-announcementId-index");
			queryExpression.setConsistentRead(false);
			List<Announcement> ann = mapper.query(Announcement.class, queryExpression);
			if (ann == null || ann.isEmpty())
				throw new Exception("No Announcement found with announcement id " + announcementId);
			return ann.get(0);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	// Delete announcement
	public Announcement deleteAnnouncement(String boardId_announcementId) {
		String[] paramArr = boardId_announcementId.split("_");
		String boardId = paramArr[0];
		String announcementId = paramArr[1];
		Announcement ann = getAnnouncement(announcementId, boardId);
		mapper.delete(ann);
		System.out.println("This announcement is deleted");
		return ann;
	}

	// updating announcement
	public Announcement updateAnnouncement(String boardId_announcementId, Announcement ann) {
		String[] paramArr = boardId_announcementId.split("_");
		String boardId = paramArr[0];
		String announcementId = paramArr[1];
		Announcement annDetails = this.getAnnouncement(announcementId, boardId);
		if (ann.getAnnouncementId() != null) {
			annDetails.setAnnouncementId(ann.getAnnouncementId());
		}
		if (ann.getBoardId() != null) {
			annDetails.setBoardId(ann.getBoardId());
		}
		annDetails.setAnnouncementText(ann.getAnnouncementText());
		mapper.batchSave(annDetails);
		return annDetails;

	}

	// list all announcement in a board
	public List<Announcement> getAnnouncementForBoard(String boardId_announcementId) {
		String[] paramArr = boardId_announcementId.split("_");
		String boardId = paramArr[0];
		Announcement announcementObj = new Announcement();
		announcementObj.setBoardId(boardId);
		DynamoDBQueryExpression<Announcement> queryExpression = new DynamoDBQueryExpression<>();
		queryExpression.setIndexName("boardId-announcementId-index");
		queryExpression.setConsistentRead(false);
		if (paramArr.length > 1) {
			String announcementId = paramArr[1];
			Condition rangeKeyCondition = new Condition().withComparisonOperator(ComparisonOperator.EQ.toString())
					.withAttributeValueList(new AttributeValue().withS(announcementId));
			queryExpression.withRangeKeyCondition("announcementId", rangeKeyCondition);
		}
		queryExpression.setHashKeyValues(announcementObj);
		List<Announcement> ann = mapper.query(Announcement.class, queryExpression);
		return ann;
	}

	public List<Announcement> getAllAnnouncementForBoard(String boardId) {
		Announcement annDetails = new Announcement();
		annDetails.setBoardId(boardId);
		DynamoDBQueryExpression<Announcement> queryExpression = new DynamoDBQueryExpression<>();
		queryExpression.setHashKeyValues(annDetails);
		queryExpression.setIndexName("boardId-announcementId-index");
		queryExpression.setConsistentRead(false);
		List<Announcement> ann = mapper.query(Announcement.class, queryExpression);
		return ann;
	}
}
