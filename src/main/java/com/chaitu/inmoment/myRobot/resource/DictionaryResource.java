package com.chaitu.inmoment.myRobot.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.chaitu.inmoment.myRobot.model.Term;
import com.chaitu.inmoment.myRobot.service.EnglishDictionaryService;

/*
 * This is a resource class for Dictionary.It takes request from browser and sends the request to appropriate 
 * Service of dictionary
 */
@Path("/dictionary")
public class DictionaryResource {

	EnglishDictionaryService service=new EnglishDictionaryService();
	
	
	@POST()
	@Path("/getTermDefinition")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTermDefinition(Term term)
	{
		if(term==null)
			return Response.status(400).entity("Term Not Found").header("Access-Control-Allow-Origin", "*").build();	
		term.setTerm_definition(service.getTermDefiniton(term.getTerm()));
	   System.out.println(term.getTerm()+"  "+term.getTerm_definition());
	   return Response.status(200).entity(term).header("Access-Control-Allow-Origin", "*").build();		
	}
}
