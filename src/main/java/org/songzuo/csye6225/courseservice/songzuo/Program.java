package org.songzuo.csye6225.courseservice.songzuo;

import java.util.HashMap;
import java.util.Map;

public class Program {
	public String programId;
	public String programName;
	public Map<String, Course> courses = new HashMap<>();
	public Map<String, Student> students = new HashMap<>();
	
//	public Program() {}
	
//	public Program(String programId, String programName) {
//		this.programId = programId;
//		this.programName = programName;
//	}
	
	public void addCourse(Course course) {
		this.courses.put(course.courseId, course);
	}
	
	public void addStudent(Student student) {
		this.students.put(student.studentId, student);
	}
	
}
