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

import com.csye6225.fall2018.courseservice3.datamodel.Program;
import com.csye6225.fall2018.courseservice3.service.ProgramService;

@Path("program")
public class ProgramResource {

	ProgramService programService = new ProgramService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Program> getAllPrograms() {
		return programService.getAllPrograms();
	}

	// ... webapi/program/1
	@GET
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program getProgram(@PathParam("programId") String programId) {
		return programService.getProgram(programId);
	}

	@DELETE
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program deleteProgram(@PathParam("programId") String programId) {
		return programService.deleteProgram(programId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program addProgram(Program prog) {
		return programService.addProgram(prog.getProgramId(), prog);
	}

	@PUT
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program updateProgram(@PathParam("programId") String programId, Program prog) {
		return programService.updateProgram(programId, prog);
	}

	@PUT
	@Path("/{programId}/course/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program registerCourses(@PathParam("programId") String programId, @PathParam("courseId") String courseId) {
		return programService.addCourseInProgram(programId, courseId);
	}

	@PUT
	@Path("/{programId}/student/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program addStudentInProgram(@PathParam("studentId") Long studentId,
			@PathParam("programId") String programId) {
		return programService.addStudentInProgram(programId, studentId);
	}

}
