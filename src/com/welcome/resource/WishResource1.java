package com.welcome.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/wish")
public class WishResource {

	@GET
	@Path("/greet/{name}")
	public Response greet(@PathParam("name") String name) {
		System.out.println("Name --" + name);
		String msg = name + "Welcome to Restfull Services";
		Response resMsg = Response.ok(msg).build();
		return resMsg;
	}

	@GET
	@Path("/hi/{name}")
	public Response hi(@PathParam("name") String name) {
		System.out.println("Name -- " + name);
		return Response.ok(name + "HI, how are you?").build();
	}

	@GET
	@Path("/hello")
	public Response sayHe(@QueryParam("name") String name) {
		System.out.println("Name -- " + name);
		return Response.ok(name + "HI, how are you?").build();
	}

}
