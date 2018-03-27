package org.songzuo.csye6225.courseservice.songzuo;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("programs/{programId}/courses/")
public class CourseAPIs {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void postCourse(@PathParam("programId") String programId, Course course) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			program.addCourse(course);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Course> getCourse(@PathParam("programId") String programId) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			return program.courses.values();
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{courseId}")
	public Course getCourseByCourseId(@PathParam("programId") String programId, @PathParam("courseId") String courseId) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			if (program.courses.containsKey(courseId)) {
				return program.courses.get(courseId);
			}
		}
		return null;
	}
	
	@DELETE
	@Path("{courseId}")
	public void deleteCourse(@PathParam("programId") String programId, @PathParam("courseId") String courseId) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			program.courses.remove(courseId);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("courses/{courseId}/students/{studentId}")
	public void addStudentToCourse(@PathParam("programId") String programId, @PathParam("courseId") String courseId, Student student) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			if (program.courses.get(courseId) != null) {
				Course course = program.courses.get(courseId);
				course.addStudent(student);
			}
		}
	}
	
}
