package com.csye6225.fall2018.courseservice3.service;

import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import com.csye6225.fall2018.courseservice3.datamodel.Board;
import com.csye6225.fall2018.courseservice3.datamodel.DynamoDBConnector;

public class BoardService {
	DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;

	public BoardService() {
		dynamoDB = new DynamoDBConnector();
		DynamoDBConnector.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}

	// adding board
	public Board addBoard(Board bo) {
		mapper.save(bo);
		return bo;
	}

	// getting specific board based on board id
	public Board getBoard(String boardId) {
		try {
			Board boardobj = new Board();
			boardobj.setBoardId(boardId);
			DynamoDBQueryExpression<Board> queryExpression = new DynamoDBQueryExpression<>();
			queryExpression.setHashKeyValues(boardobj);
			queryExpression.setIndexName("boardId-index");
			queryExpression.setConsistentRead(false);
			List<Board> board = mapper.query(Board.class, queryExpression);
			if (board == null || board.isEmpty())
				throw new Exception("No Board found with board id " + boardId);
			return board.get(0);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}

	}

	// Deleting a board id
	public Board deleteBoard(String boardId) {
		Board boardDetails = getBoard(boardId);
		String id = boardDetails.getId();
		Board board = mapper.load(Board.class, id);
		board.setId(id);
		mapper.delete(board);
		return board;
	}

	// updating course based on course id
	public Board updateBoard(String boardId, Board bo) {
		Board board = this.getBoard(boardId);
		bo.setId(board.getId());
		bo.setBoardId(boardId);
		System.out.println("My ID " + bo.getId());
		mapper.save(bo);
		return bo;
	}

	//adding course to board
	public Board addCourseToBoard(String boardId, String courseId) {
		Board board = this.getBoard(boardId);
		board.setCourseId(courseId);
		mapper.batchSave(board);
		return board;
	}
}
