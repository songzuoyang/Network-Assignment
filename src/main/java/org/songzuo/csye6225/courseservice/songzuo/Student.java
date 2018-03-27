package org.songzuo.csye6225.courseservice.songzuo;

import java.util.ArrayList;
import java.util.List;

public class Student {
	public String studentId;
	public String studentName;
	public String email;
	public Program program;
	public List<Course>courses = new ArrayList<>();
	
	public void addProgram(Program program) {
		this.program = program;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
} 
