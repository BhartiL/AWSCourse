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

import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.datamodel.Student;
import com.csye6225.fall2018.courseservice3.service.CourseService;
import com.csye6225.fall2018.courseservice3.service.StudentService;

@Path("student")
public class StudentResource {
	StudentService stuService = new StudentService();

	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("studentId") String studentId) {
		return stuService.getStudent(studentId);
	}

	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("studentId") String studentId) {
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
	public Student updateStudent(@PathParam("studentId") String studentId, Student stu) {
		return stuService.updateStudentInformation(studentId, stu);
	}

	@PUT
	@Path("/{studentId}/course/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student enrollStudentToCourse(@PathParam("courseId") String courseId,
			@PathParam("studentId") String studentId) {
		return stuService.enrollStudentToCourse(courseId, studentId);

	}

	@POST
	@Path("/{studentId}/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student registerCourses(@PathParam("studentId") String studentId, Course course) {
		String courseId = course.getCourseId();
		Student st = stuService.getStudent(studentId);
		String email = st.getEmailId();
		List<String> courseList = st.getRegisteredCourses();
		if (courseList.size() > 2) {
			throw new IllegalStateException("Student is already registered for 3 courses");
		}
		courseList.add(courseId);
		stuService.subscribe(courseId, email);
		st.setRegisteredCourses(courseList);
		CourseService cs = new CourseService();
		cs.addStudentToCourse(courseId, studentId);
		return stuService.updateStudentInformation(studentId, st);
	}
}
