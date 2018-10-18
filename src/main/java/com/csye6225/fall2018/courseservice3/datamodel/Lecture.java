package com.csye6225.fall2018.courseservice3.datamodel;

import java.util.ArrayList;

public class Lecture {

	int lectureId;
	ArrayList<String> notes = new ArrayList<>();
	ArrayList<String> materials = new ArrayList<>();

	public int getLectureId() {
		return lectureId;
	}

	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}

	public ArrayList<String> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}

	public ArrayList<String> getMaterials() {
		return materials;
	}

	public void setMaterials(ArrayList<String> materials) {
		this.materials = materials;
	}

}
