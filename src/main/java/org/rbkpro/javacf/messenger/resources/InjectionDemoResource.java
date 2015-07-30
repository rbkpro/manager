package org.rbkpro.javacf.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injection")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectionDemoResource {
	
	@GET
	@Path("annotation")

	public String getPramUsingAnnotation(@MatrixParam("param") String matParam,
										 @HeaderParam("myValue") String valueParam,
										 @CookieParam("name") String cookPram){
		
		return "matrix param : "+matParam+" / header costume param : "+valueParam+" / cookie param : "+cookPram;
	}
	
	public String getParamContext(@Context UriInfo  uriInfo){
	    
		return "test";
		
	}

	
}
