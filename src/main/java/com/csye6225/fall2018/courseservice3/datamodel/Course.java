package com.csye6225.fall2018.courseservice3.datamodel;

import java.util.ArrayList;
import java.util.HashSet;

public class Course {

	String courseId;
	Long professorId;
	Long studentTAId;
	String programId;
	String board;
	ArrayList<String> roster = new ArrayList<>();
	ArrayList<Lecture> lectures = new ArrayList<>();
	HashSet<Long> enrolledStudents = new HashSet<>();

	public Course() {

	}

	public Course(String courseId, String board, ArrayList<String> roster, Long professor, Long studentTA) {
		this.courseId = courseId;
		this.board = board;
		this.roster = roster;
		this.professorId = professor;
		this.studentTAId = studentTA;
	}


	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public Long getStudentTAId() {
		return studentTAId;
	}

	public void setStudentTAId(Long studentTAId) {
		this.studentTAId = studentTAId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public ArrayList<String> getRoster() {
		return roster;
	}

	public void setRoster(ArrayList<String> roster) {
		this.roster = roster;
	}

	public ArrayList<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
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

	public ArrayList<Lecture> addLecture(Lecture lecture) {
		lectures.add(lecture);
		return lectures;

	}
	
	public ArrayList<Lecture> removeLecture(Lecture lecture) {
		lectures.remove(lecture);
		return lectures;
	}
}
