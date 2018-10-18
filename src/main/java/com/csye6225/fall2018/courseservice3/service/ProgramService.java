package com.csye6225.fall2018.courseservice3.service;

import java.util.ArrayList;
import java.util.HashMap;
import com.csye6225.fall2018.courseservice3.datamodel.Course;
import com.csye6225.fall2018.courseservice3.datamodel.Program;
import com.csye6225.fall2018.courseservice3.datamodel.StudentInformationSystemDatabase;

public class ProgramService {

	static HashMap<String, Program> program_Map = StudentInformationSystemDatabase.getProgramDB();

	// adding program
	public Program addProgram(String programID, Program prog) {
		program_Map.put(programID, prog);
		return program_Map.get(programID);
	}

	// getting program based on program id
	public Program getProgram(String programId) {
		return program_Map.get(programId);
	}

	// deleting program based on program id
	public Program deleteProgram(String programId) {
		Program deletedProgram = program_Map.get(programId);
		program_Map.remove(programId);
		return deletedProgram;
	}

	// updating program based on program id
	public Program updateProgram(String programId, Program program) {
		program_Map.put(programId, program);
		return program;
	}

	// getting all program list
	public ArrayList<Program> getAllPrograms() {
		ArrayList<Program> list = new ArrayList<>();
		for (Program prog : program_Map.values()) {
			list.add(prog);
		}
		return list;
	}

	// adding student in program
	public Program addStudentInProgram(String programId, Long studentId) {
		Program program = program_Map.get(programId);
		program.addStudent(studentId);
		StudentService.student_Map.get(studentId).setProgramId(programId);
		return program;

	}

	// adding courses in program
	public Program addCourseInProgram(String programId, String courseId) {
		Program proObject = program_Map.get(programId);
		proObject.addCourse(courseId);
		Course course = CourseService.course_Map.get(courseId);
		course.setProgramId(programId);
		return proObject;
	}
}
