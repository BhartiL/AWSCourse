package com.csye6225.fall2018.courseservice3.resource;

import java.util.ArrayList;
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

import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.datamodel.Lecture;
import com.csye6225.fall2018.courseservice3.service.CourseService;

@Path("course")
public class CourseResource {

	CourseService courseService = new CourseService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	// ... webapi/course/1
	@GET
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getcourse(@PathParam("courseId") String courseId) {
		return courseService.getCourses(courseId);
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
		return courseService.addCourse(co.getCourseId(), co);
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
	public Course addStudentToCourse(@PathParam("studentId") Long studentId, @PathParam("courseId") String courseId) {
		return courseService.addStudentToCourse(courseId, studentId);
	}

	@PUT
	@Path("/{courseId}/program/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course registerProgram(@PathParam("programId") String programId, @PathParam("courseId") String courseId) {
		return courseService.addProgramToCourse(courseId, programId);
	}

	@GET
	@Path("/{courseId}/getLectures")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lecture> getLectures(@PathParam("courseId") String courseId) {
		return courseService.getCourses(courseId).getLectures();
	}

	@POST
	@Path("/{courseId}/postLecture")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Lecture> postLecture(@PathParam("courseId") String courseId, Lecture lecture) {
		return courseService.addLectureInCourse(courseId, lecture);
	}

	@GET
	@Path("/{courseId}/lecture/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture getLecture(@PathParam("courseId") String courseId, @PathParam("lectureId") int lectureId) {
		return courseService.getLecture(courseId, lectureId);
	}

	@PUT
	@Path("/{courseId}/lecture")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture updatelecture(@PathParam("courseId") String courseId, Lecture lecture) {
		return courseService.updateLectureForCourse(courseId, lecture);
	}
}
