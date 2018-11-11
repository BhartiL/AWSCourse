package com.csye6225.fall2018.courseservice3.service;

import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.datamodel.DynamoDBConnector;

public class CourseService {

	DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;

	public CourseService() {
		dynamoDB = new DynamoDBConnector();
		DynamoDBConnector.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}

	// adding courses
	public Course addCourse(Course course) {
		mapper.save(course);
		return course;
	}

	// getting specific course based on course id
	public Course getCourse(String courseId) {
		try {
			Course partitionKey = new Course();
			partitionKey.setCourseId(courseId);
			DynamoDBQueryExpression<Course> queryExpression = new DynamoDBQueryExpression<>();
			queryExpression.setHashKeyValues(partitionKey);
			queryExpression.setIndexName("courseId-index");
			queryExpression.setConsistentRead(false);
			List<Course> course = mapper.query(Course.class, queryExpression);
			if (course == null || course.isEmpty())
				throw new Exception("No course found with course id " + courseId);
			return course.get(0);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	// Deleting a course id
	public Course deleteCourse(String courseId) {
		Course co = getCourse(courseId);
		String id = co.getId();
		Course objTodelete = mapper.load(Course.class, id);
		objTodelete.setId(id);
		mapper.delete(objTodelete);
		System.out.println("This Course is deleted");
		return co;
	}

	// updating course based on course id
	public Course updateCourse(String courseId, Course co) {
		Course course = this.getCourse(courseId);
		co.setId(course.getId());
		co.setCourseId(courseId);
		mapper.batchSave(co);
		return co;
	}

	// enrolling student to course
	public Course addStudentToCourse(String courseId, String studentId) {
		Course course = this.getCourse(courseId);
		course.addStudent(studentId);
		mapper.batchSave(course);
		return course;
	}

	// adding board to course
	public Course addBoardToCourse(String courseId, String boardId) {
		Course course = this.getCourse(courseId);
		course.setBoardId(boardId);
		mapper.batchSave(course);
		return course;
	}

	// adding professor to course
	public Course addProfessorToCourse(String courseId, String professorId) {
		Course course = this.getCourse(courseId);
		course.setProfessorId(professorId);
		mapper.save(course);
		return course;
	}
}
