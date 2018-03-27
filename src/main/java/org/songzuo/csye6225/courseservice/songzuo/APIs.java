package org.songzuo.csye6225.courseservice.songzuo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/") 
public class APIs {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAPIs() {
		return "// Program\n"
				+ "POST /programs\n"
				+ "GET /programs\n"
				+ "GET /programs/{programId}\n"
				+ "DELETE /programs/{programId}\n"
				+ "\n"
				+ "// Course\n"
				+ "POST /programs/{programId}/courses\n"
				+ "GET /programs/{programId}/courses\n"
				+ "GET /programs/{programId}/courses/{courseId}\n"
				+ "DELETE /programs/{programId}/courses/{courseId}\n"
				+ "POST /programs/{programId}/courses/{courseId}/students/{studentId}\n"
				+ "\n"
				+ "// Student\n"
				+ "GET programs/{programId}/students\n"
				+ "POST /programs/{programId}/students\n"
				+ "GET /programs/{programId}/students/{studentId}\n"
				+ "DELETE /programs/{programId}/students/{studentId}\n"
				+ "\n";
	}
}
