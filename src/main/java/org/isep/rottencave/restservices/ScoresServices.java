package org.isep.rottencave.restservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.isep.rottencave.model.PlayerResult;
import org.isep.rottencave.services.ScoreService;

@Path("scores")
@Produces(MediaType.APPLICATION_JSON)
public class ScoresServices {
	
	@GET
	@Path("get/{id}")
	public Response getScore(@PathParam("id") int id) {
		ScoreService ss = new ScoreService();
		PlayerResult pr = ss.findById(id);
		return Response.status(200).entity(pr).build();
	}
	
	@GET
	@Path("list")
	public Response getScoreList() {
		ScoreService ss = new ScoreService();
		List<PlayerResult> prs = ss.listScores();
		return Response.status(200).entity(prs).build();
	}
	
	// Not yet useful
//	@POST
//	@Path("update")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response updateScore(PlayerResult pr) {
//		ScoreService ss = new ScoreService();
//		ss.updateScore(pr);
//		return Response.status(200).build();
//	}
	
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertScore(PlayerResult pr) {
		ScoreService ss = new ScoreService();
		ss.persistScore(pr);
		return Response.status(200).build();
	}

	// Not yet useful
//	@DELETE
//	@Path("delete/{id}")
//	public Response deleteScore(@PathParam("id") String id) {
//		ScoreService ss = new ScoreService();
//		ss.deleteScore(Integer.parseInt(id));
//		return Response.status(200).build();
//	}
}
