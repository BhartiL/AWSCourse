package com.csye6225.fall2018.courseservice3.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.service.CourseService;

@Path("course")
public class CourseResource {

	CourseService courseService = new CourseService();

	@GET
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getcourse(@PathParam("courseId") String courseId) {
		return courseService.getCourse(courseId);
	}

	@DELETE
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourses(@PathParam("courseId") String courseId) {
		return courseService.deleteCourse(courseId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course co) {
		co.setNotificationTopic(courseService.createTopic(co));
		return courseService.addCourse(co);
	}

	@PUT
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourses(@PathParam("courseId") String courseId, Course co) {
		return courseService.updateCourse(courseId, co);
	}

	@PUT
	@Path("/{courseId}/student/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addStudentToCourse(@PathParam("studentId") String studentId, @PathParam("courseId") String courseId) {
		return courseService.addStudentToCourse(courseId, studentId);
	}

	@PUT
	@Path("/{courseId}/board/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addBoardToCourse(@PathParam("courseId") String courseId, @PathParam("boardId") String boardId) {
		return courseService.addBoardToCourse(courseId, boardId);
	}

	@PUT
	@Path("/{courseId}/professor/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addProfessorToCourse(@PathParam("courseId") String courseId,
			@PathParam("professorId") String professorId) {
		return courseService.addProfessorToCourse(courseId, professorId);
	}
}
