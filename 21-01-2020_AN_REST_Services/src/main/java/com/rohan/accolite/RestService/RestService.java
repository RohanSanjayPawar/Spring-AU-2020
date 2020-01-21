package com.rohan.accolite.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import java.util.*;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;;

@Path("/apis")
public class RestService {

	static List<String> str = new LinkedList<>();
	static List<Player> players = new LinkedList<>();

	@GET
	@Produces("application/json")
	public List<Player> getAllPlayers() {
		return players;
	}

	@PUT
	@Path("/add")
	@Consumes("application/json")
	public boolean putUser(Player player) {
		return players.add(player);
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Player deleteUser(@PathParam("id") int id) {
		return players.remove(id);
	}

	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Player updateUser(@PathParam("id") int id, Player player) {
		return players.set(id, player);
	}

}
