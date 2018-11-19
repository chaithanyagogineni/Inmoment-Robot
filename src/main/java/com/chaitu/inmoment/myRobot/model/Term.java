package com.chaitu.inmoment.myRobot.model;


/*
 * This is model object for TERM .All requests and response from browser(client) to server are mapped to this object
 */
public class Term {
	private String term;
	private String term_definition;
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTerm_definition() {
		return term_definition;
	}
	public void setTerm_definition(String term_definition) {
		this.term_definition = term_definition;
	}
	

}
