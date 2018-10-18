package com.csye6225.fall2018.courseservice3.datamodel;

import java.util.HashSet;

public class Student {

	private String studentName;
	private String programId;
	private long studentId;
	private String photo;
	private HashSet<String> courses = new HashSet<>();

	public Student() {

	}

	public Student(long studentId, String studentName, String programName, String photo) {
		this.photo = photo;
		this.studentName = studentName;
		this.programId = programName;
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public HashSet<String> getCourses() {
		return courses;
	}

	public void setCourses(HashSet<String> courses) {
		this.courses = courses;
	}

	public void addCourse(String courseId) {
		this.getCourses().add(courseId);
	}

}
