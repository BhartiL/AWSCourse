package com.csye6225.fall2018.courseservice3.service;

import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.csye6225.fall2018.courseservice3.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice3.datamodel.Student;

public class StudentService {

	DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;

	public StudentService() {
		dynamoDB = new DynamoDBConnector();
		DynamoDBConnector.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}

	public Student addStudent(Student stu) {
		mapper.save(stu);
		return stu;
	}

	// Getting One student
	public Student getStudent(String studentId) {
			try {
			Student StudentObj = new Student();
			StudentObj.setStudentId(studentId);
			DynamoDBQueryExpression<Student> queryExpression = new DynamoDBQueryExpression<>();
			queryExpression.setHashKeyValues(StudentObj);
			queryExpression.setIndexName("studentId-index");
			queryExpression.setConsistentRead(false);
			List<Student> student = mapper.query(Student.class, queryExpression);
			if (student == null || student.isEmpty())
				throw new Exception("No students found with student id " + studentId);
			return student.get(0);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	// Deleting a student
	public Student deleteStudent(String studentId) {
		Student deletedStuDetails = getStudent(studentId);
		String id = deletedStuDetails.getId();
		Student objTodelete = mapper.load(Student.class, id);
		objTodelete.setId(id);
		mapper.delete(objTodelete);
		System.out.println("The following student got deleted");
		return deletedStuDetails;
	}

	// Updating student Info
	public Student updateStudentInformation(String studentId, Student stu) {
		Student student = this.getStudent(studentId);
		stu.setId(student.getId());
		stu.setStudentId(studentId);
		mapper.save(stu);
		return stu;
	}

	//enrolling a student to a course
	public Student enrollStudentToCourse(String courseId, String studentId) {
		Student stuObject = this.getStudent(studentId);
		stuObject.addCourse(courseId);
		mapper.save(stuObject);
		return stuObject;
	}

}
