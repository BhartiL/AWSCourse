package com.csye6225.fall2018.courseservice3.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.csye6225.fall2018.courseservice3.datamodel.Board;
import com.csye6225.fall2018.courseservice3.service.BoardService;

@Path("board")
public class BoardResource {
	BoardService boardService = new BoardService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Board> getBoards() {
		return boardService.getBoards();
	}

	@GET
	@Path("/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Board getBoard(@PathParam("boardId") String boardId) {
		return boardService.getBoard(boardId);
	}

	@DELETE
	@Path("/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Board deleteBoard(@PathParam("boardId") String boardId) {
		return boardService.deleteBoard(boardId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board addBoard(Board bo) {
		return boardService.addBoard(bo);
	}

	@PUT
	@Path("/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board updateBoard(@PathParam("boardId") String boardId, Board bo) {
		return boardService.updateBoard(boardId, bo);
	}

	@PUT
	@Path("/{boardId}/course/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board addCourseToBoard(@PathParam("boardId") String boardId, @PathParam("courseId") String courseId) {
		return boardService.addCourseToBoard(boardId, courseId);
	}
}
