package org.songzuo.csye6225.courseservice.songzuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
	public String courseId;
	public String courseName;
	public Map<String, Student> students = new HashMap<>();
	public List<Lecture> lectures = new ArrayList<>();
	public Board board;
	public Roster roster;
	
//	public Course(String courseId, String courseName) {
//		this.courseId = courseId;
//		this.courseName = courseName;
//	}
	
	public void addStudent(Student student) {
		students.put(student.studentId, student);
	}
	
	public void addBoard(Board board) {
		this.board = board;
	}
	
	public void addRoster(Roster roster) {
		this.roster = roster;
	}
	
}
