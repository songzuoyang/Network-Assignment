package org.songzuo.csye6225.courseservice.songzuo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("programs/{programId}/students")
public class StudentAPIs {
	
//	private Map<String, Student> studentMap = new HashMap<String, Student>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Student> getAllStudent(@PathParam("programId") String programId) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			return program.students.values();
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student addStudentToProgram(@PathParam("programId") String programId, Student student) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			program.students.put(student.studentId, student);
		}
		return student;
	}
	
	@GET
	@Path("{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentByStudentId(@PathParam("programId") String programId, @PathParam("studentId") String studentId) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			return program.students.get(studentId);
		}
		return null;
	}
	
	@DELETE
	@Path("{studentId}")
	public void deleteStudent(@PathParam("programId") String programId, @PathParam("studentId") String studentId) {
		if (ProgramAPIs.getProgram(programId) != null) {
			Program program = ProgramAPIs.getProgram(programId);
			program.students.remove(studentId);
		}
	}
}
