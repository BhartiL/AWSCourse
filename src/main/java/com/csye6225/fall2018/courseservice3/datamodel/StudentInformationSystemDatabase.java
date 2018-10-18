package com.csye6225.fall2018.courseservice3.datamodel;

import java.util.HashMap;

public class StudentInformationSystemDatabase {

	private static HashMap<Long, Student> studentDB = new HashMap<>();
	private static HashMap<String, Course> coursesDB = new HashMap<>();
	private static HashMap<String, Program> programDB = new HashMap<>();
	public static HashMap<Long, Lecture> lecturesDB = new HashMap<>();

	public static HashMap<Long, Student> getStudentDB() {
		return studentDB;
	}

	public static HashMap<String, Course> getCoursesDB() {
		return coursesDB;
	}

	public static HashMap<String, Program> getProgramDB() {
		return programDB;
	}

	public static HashMap<Long, Lecture> getLecturesDB() {
		return lecturesDB;
	}
}
