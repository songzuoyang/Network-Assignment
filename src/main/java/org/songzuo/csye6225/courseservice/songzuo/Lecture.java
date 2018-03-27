package org.songzuo.csye6225.courseservice.songzuo;

public class Lecture {
	public String lectureId;
	public String lectureName;
	public Note note;
	
	public Lecture(String lectureId, String lectureName) {
		this.lectureId = lectureId;
		this.lectureName = lectureName;
	}
	
	public void addNotes(Note note) {
		this.note = note;
	}
}
