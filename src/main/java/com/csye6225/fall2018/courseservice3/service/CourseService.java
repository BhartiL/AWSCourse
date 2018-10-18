package com.csye6225.fall2018.courseservice3.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.datamodel.Lecture;
import com.csye6225.fall2018.courseservice3.datamodel.StudentInformationSystemDatabase;

public class CourseService {

	public static HashMap<String, Course> course_Map = StudentInformationSystemDatabase.getCoursesDB();

	//adding courses
	public Course addCourse(String courseId, Course course) {
		course_Map.put(courseId, course);
		return course_Map.get(courseId);
	}

	// getting specific course based on course id
	public Course getCourses(String courseId) {
		return course_Map.get(courseId);
	}

	// Deleting a course id
	public Course deleteCourse(String courseId) {
		Course deletedCourses = course_Map.get(courseId);
		course_Map.remove(courseId);
		return deletedCourses;
	}

	// updating course based on course id 
	public Course updateCourse(String courseId, Course course) {
		course_Map.put(courseId, course);
		return course;
	}
	//getting all courses
	public List<Course> getAllCourses() {
		// Getting the list
		ArrayList<Course> list = new ArrayList<>();
		for (Course course : course_Map.values()) {
			list.add(course);
		}
		return list;
	}
	
	// enrolling student to course
	//mapping course id to student id
	public Course addStudentToCourse(String courseId, Long studentId) {
		Course course = course_Map.get(courseId);
		course.addStudent(studentId);
		return course;

	}

	// adding course in program 
	// mapping program to course
	public Course addProgramToCourse(String courseId, String programId) {
		Course course = course_Map.get(courseId);
		course.setProgramId(programId);
		return course;

	}
		
	// adding lecture to course
	public ArrayList<Lecture> addLectureInCourse(String courseId, Lecture lecture) {
		Course course = course_Map.get(courseId);
		lecture.setLectureId(course.getLectures().size() + 1);
		return course.addLecture(lecture);
	}

	// getting lecture based on course id and lecture id
	public Lecture getLecture(String courseId, int lectureId) {
		Course course = course_Map.get(courseId);
		return course.getLectures().get(lectureId - 1);
	}


	public Lecture updateLectureForCourse(String courseId, Lecture lecture) {
		Lecture postedLecture = getLecture(courseId, lecture.getLectureId());
		postedLecture.setMaterials(lecture.getMaterials());
		postedLecture.setNotes(lecture.getNotes());
		return postedLecture;
	}
}
