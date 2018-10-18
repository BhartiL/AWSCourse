/*package com.csye6225.fall2018.courseservice3.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.fall2018.courseservice3.datamodel.Lecture;
import com.csye6225.fall2018.courseservice3.datamodel.StudentDatabase;

public class LectureService {
	public static HashMap<Long, Lecture> lectures_Map = StudentDatabase.getLecturesDB();

	public Lecture addLecture( Lecture lec) {
		long nextAvailableId = lectures_Map.size() + 1;
		lec.setLectureId(nextAvailableId);
		lectures_Map.put(nextAvailableId, lec);
		return lectures_Map.get(nextAvailableId);
	}

	public Lecture getLecture(Long lectureID) {
		return lectures_Map.get(lectureID);
	}

	// Deleting a lecture
	public Lecture deleteLecture(long lectureID) {
		Lecture deletedlectures = lectures_Map.get(lectureID);
		lectures_Map.remove(lectureID);
		return deletedlectures;
	}

	public Lecture updateLecture(long lectureID, Lecture lecture) {
		lectures_Map.put(lectureID, lecture);
		return lecture;
	}

	public List<Lecture> getAllLectures() {
		// Getting the list
		ArrayList<Lecture> list = new ArrayList<>();
		for (Lecture lec : lectures_Map.values()) {
			list.add(lec);
		}
		return list;
	}
	
	 

}
*/