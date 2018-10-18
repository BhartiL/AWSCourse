package com.csye6225.fall2018.courseservice3.datamodel;

import java.util.HashSet;

public class Program {
	
	private String programId;
	private String programName;
	private HashSet<String> courses = new HashSet<>();
	private HashSet<Long> enrolledStudents = new HashSet<>();

	public Program(String programId, String programName, HashSet<String> courses, HashSet<String> students) {

	}

	public Program() {

	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public HashSet<String> getCourses() {
		return courses;
	}

	public void setCourses(HashSet<String> courses) {
		this.courses = courses;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public HashSet<Long> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(HashSet<Long> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public void addStudent(Long studentId) {
		this.getEnrolledStudents().add(studentId);
	}

	public void addCourse(String courseId) {
		this.getCourses().add(courseId);
	}

}
