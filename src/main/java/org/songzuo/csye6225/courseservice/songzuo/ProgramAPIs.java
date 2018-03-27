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

@Path("programs")
public class ProgramAPIs {
	
	private static Map<String, Program> programMap = new HashMap<String, Program>();
	
	public static Program getProgram(String programId) {
		return programMap.get(programId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program addProgram(Program program) {
		if (!programMap.containsKey(program.programId)) {
			programMap.put(program.programId, program);
		}
		return program;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Program> getPrograms() {
		return programMap.values();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{programId}")
	public Program getProgramByAPI(@PathParam("programId") String programId) {
		return getProgram(programId);
	}
	
	@DELETE
	@Path("{programId}")
	public void deleteProgram(@PathParam("programId") String programId) {
		programMap.remove(programId);
	}
	
}
