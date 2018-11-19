package com.chaitu.inmoment.myRobot.service;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.BASE_URL_COMPANY_API;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.COMPANY_API_KEY;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.JUMP_TO_FIRST_PAGE;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.JUMP_TO_LAST_PAGE;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.JUMP_TO_FIRST_TERM;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.JUMP_TO_LAST_TERM;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.MOVE_TO_NEXT_PAGE;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.MOVE_TO_PREVIOUS_PAGE;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.MOVE_TO_PREVIOUS_TERM;
import static com.chaitu.inmoment.myRobot.shared.AppConstants.MOVE_TO_NEXT_TERM;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.chaitu.inmoment.myRobot.model.RobotStatus;


/*
 * 
 * 
 This service helps to perform operations on English Dictionary
 It creates a new client with given target and allow it to access dictionary
 * 
 * 
 * 
 */
public class EnglishDictionaryService {
	private ClientConfig config;
    private Client client;
    private WebTarget target;
    static RobotStatus current_status=null;
	public EnglishDictionaryService()
	{
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
		target = client.target(UriBuilder.fromUri(BASE_URL_COMPANY_API).build());
	}
	
   
	/*
	 * 
	 * This Method takes String as argument and returns the definition of the entered string.
	 * This method checks the first charatcer of given string and calls appropriate method to search
	 */
    public String getTermDefiniton(String term)
    {
    	if(term.toLowerCase().charAt(0)-'m'>0)
    	{
    	 return searchFromLastPage(term);	
    	}
    	return searchFromFirstPage(term);
    }
    
    /*
     * This method searches for the given string from starting of the dictionary
     * Checks whether given string exists or not and returns the definiton of the term
     */
    private String searchFromFirstPage(String term)
    {
    	 current_status = target.path(JUMP_TO_FIRST_PAGE).request().
                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
  
    	current_status = target.path(JUMP_TO_LAST_TERM).request().
                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	
    	
    	while(current_status.getCurrentTerm().compareToIgnoreCase(term)<0)
    	{
    	
    		current_status = target.path(MOVE_TO_NEXT_PAGE).request().
                    accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
           current_status = target.path(JUMP_TO_LAST_TERM).request().
                    accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	}
    	
    	if(current_status.getCurrentTerm().compareToIgnoreCase(term) == 0)
		{
			return current_status.getCurrentTermDefinition();
		}
    	String current_last_term=current_status.getCurrentTerm();
    	System.out.println("current last term is "+current_last_term);
    	current_status = target.path(JUMP_TO_FIRST_TERM).request().
                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	if(current_status.getCurrentTerm().compareToIgnoreCase(term) == 0)
		{
			return current_status.getCurrentTermDefinition();
		}
    	System.out.println(Math.abs(term.compareToIgnoreCase(current_status.getCurrentTerm()))+"Comparing "+Math.abs(term.compareToIgnoreCase(current_last_term)));
    	if(Math.abs(term.compareToIgnoreCase(current_status.getCurrentTerm()))<=Math.abs(term.compareToIgnoreCase(current_last_term)))
    			{
    		    return startFromFront(term);
    			}
    	current_status = target.path(JUMP_TO_LAST_TERM).request().
                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	return startFromBack(term);
    		
    }
    
    /*
     * This method searches for the given string from ending of the dictionary
     * Checks whether given string exists or not and returns the definiton of the term if exists.
     */
    private String searchFromLastPage(String term)
    {
    	
    	 current_status = target.path(JUMP_TO_LAST_PAGE).request().
                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	 current_status= target.path(JUMP_TO_FIRST_TERM).request().
                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	
    	
    	while(current_status.getCurrentTerm().compareToIgnoreCase(term)>0)
    	{
    		//System.out.println(current_status.getCurrentTerm());
    		current_status = target.path(MOVE_TO_PREVIOUS_PAGE).request().
                    accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
           current_status = target.path(JUMP_TO_FIRST_TERM).request().
                    accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	}
    	
    	String current_first_term=current_status.getCurrentTerm();
    	if(current_first_term.compareToIgnoreCase(term)==0)
    		return current_status.getCurrentTermDefinition();
    	current_status = target.path(JUMP_TO_LAST_TERM).request().
                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
    	if(current_status.getCurrentTerm().compareToIgnoreCase(term) == 0)
		{
			return current_status.getCurrentTermDefinition();
		}
    //	System.out.println(term.compareToIgnoreCase(current_status.getCurrentTerm()))+"Comparing "+Math.abs(term.compareToIgnoreCase(current_first_term)));
    	System.out.println(Math.abs(term.compareToIgnoreCase(current_status.getCurrentTerm()))+"Comparing "+term.compareToIgnoreCase(current_first_term));
    	if(Math.abs(term.compareToIgnoreCase(current_status.getCurrentTerm()))<=Math.abs(term.compareToIgnoreCase(current_first_term)))
		{
	    return startFromBack(term);
		}
current_status = target.path(JUMP_TO_FIRST_TERM).request().
        accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
return startFromFront(term);
     
    }
    
    //This method searches for the given term from the start of the page
	private String startFromFront(String term) {
		System.out.println("I am searching from front");
		while(current_status.isHasNextTerm())
		{
			if(current_status.getCurrentTerm().compareToIgnoreCase(term)>0)
				break;
			if(current_status.getCurrentTerm().compareToIgnoreCase(term) == 0)
    		{
    			return current_status.getCurrentTermDefinition();
    		}	
			else
			{
				System.out.println(current_status.getCurrentTerm().toLowerCase());
				current_status=target.path(MOVE_TO_NEXT_TERM).request().
		               accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
			}
		}

	return "TERM NOT FOUND";
	}
	//This method searches for the given string in reverse order of the page.
	private String startFromBack(String term) {
		System.out.println("I am searching from back");
		while(current_status.isHasPreviousTerm())
		{
			if(current_status.getCurrentTerm().compareToIgnoreCase(term)<0)
				break;
			if(current_status.getCurrentTerm().compareToIgnoreCase(term) == 0)
    		{
    			return current_status.getCurrentTermDefinition();
    		}	
			else
			{
				System.out.println(current_status.getCurrentTerm());
				current_status=target.path(MOVE_TO_PREVIOUS_TERM).request().
		                accept(MediaType.APPLICATION_JSON).header("x-api-key",COMPANY_API_KEY).post(null,RobotStatus.class);
			}
		}
	
	return "TERM NOT FOUND";
	}

}
