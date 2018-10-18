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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice3.datamodel.Student;
import com.csye6225.fall2018.courseservice3.service.StudentService;

@Path("student")
public class StudentResource {
	StudentService stuService = new StudentService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {
		return stuService.getAllStudents();
	}

	@GET
	@Path("/program/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentByProgramId(@QueryParam("programId") String programId) {
		if (programId == null) {
			return stuService.getAllStudents();
		}
		return stuService.getStudentsByProgram(programId);

	}

	// ... webapi/student/1
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("studentId") long studentId) {
		return stuService.getStudent(studentId);
	}

	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("studentId") long studentId) {
		return stuService.deleteStudent(studentId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student stu) {
		return stuService.addStudent(stu);
	}

	@PUT
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("studentId") long studentId, Student stu) {
		return stuService.updateStudentInformation(studentId, stu);
	}

	@PUT
	@Path("/{studentId}/course/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student enrollstudent(@PathParam("courseId") String courseId, @PathParam("studentId") long studentId) {
		return stuService.enrollStudentToCourse(courseId, studentId);

	}

	@PUT
	@Path("/{studentId}/program/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student enrollStudentToProgram(@PathParam("programId") String programId,
			@PathParam("studentId") long studentId) {
		return stuService.enrollStudentInProgram(programId, studentId);
	}

}
