package org.isep.rottencave.restservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("test")
public class RestServiceExample {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response jsonGet() {
		String result = "ok";
		return Response.status(200).entity(result).build();
	}
}
