package com.csye6225.fall2018.courseservice3.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.datamodel.Program;
import com.csye6225.fall2018.courseservice3.datamodel.Student;
import com.csye6225.fall2018.courseservice3.datamodel.StudentInformationSystemDatabase;

public class StudentService {

	static HashMap<Long, Student> student_Map = StudentInformationSystemDatabase.getStudentDB();

	// Getting a list of all students
	public List<Student> getAllStudents() {
		// Getting the list
		ArrayList<Student> list = new ArrayList<>();
		for (Student stu : student_Map.values()) {
			list.add(stu);
		}
		return list;
	}

	// Adding a student
	public void addStudent(String studentName, String programName, String photo) {
		// Next Id
		long nextAvailableId = student_Map.size() + 1;
		Student stu = new Student(nextAvailableId, studentName, programName, photo);
		student_Map.put(nextAvailableId, stu);
	}

	public Student addStudent(Student stu) {

		long nextAvailableId = student_Map.size() + 1;
		stu.setStudentId(nextAvailableId);
		student_Map.put(nextAvailableId, stu);
		return student_Map.get(nextAvailableId);
	}

	// Getting One student
	public Student getStudent(Long studentId) {
		return student_Map.get(studentId);
	}

	// Deleting a student
	public Student deleteStudent(Long studentId) {
		Student deletedStuDetails = student_Map.get(studentId);
		student_Map.remove(studentId);
		return deletedStuDetails;
	}

	// Updating student Info
	public Student updateStudentInformation(Long studentId, Student stu) {
		Student stuObject = student_Map.get(studentId);
		studentId = stuObject.getStudentId();
		stu.setStudentId(studentId);
		// Publishing New Values
		student_Map.put(studentId, stu);
		return stu;
	}

	public List<Student> getStudentsByProgram(String programId) {
		// Getting the list
		ArrayList<Student> list = new ArrayList<>();
		for (Student stu : student_Map.values()) {
			if (stu.getProgramId().equals(programId)) {
				list.add(stu);
			}
		}
		return list;
	}

	// enrolling a student to a course
	public Student enrollStudentToCourse(String courseId, Long studentId) {
		Student stuObject = student_Map.get(studentId);
		stuObject.addCourse(courseId);
		Course course = CourseService.course_Map.get(courseId);
		course.addStudent(studentId);
		return stuObject;
	}

	// enrolling a student in a program
	public Student enrollStudentInProgram(String progId, Long studentId) {
		Student stuObject = student_Map.get(studentId);
		stuObject.setProgramId(progId);
		Program program = ProgramService.program_Map.get(progId);
		program.addStudent(studentId);
		return stuObject;
	}
}
