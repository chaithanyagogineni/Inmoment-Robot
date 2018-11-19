package com.chaitu.inmoment.myRobot.model;


/*
 * This is the model object for Robot Status.All the GET and POST requests of REST API returns JSON objects which are mapped to
 * this object.
 */
public class RobotStatus {
	private String status;
	private int timeUsed;
	private int timeRemaining;
	private String currentTerm;
	private String currentTermDefinition;
	private int currentPageIndex;
	private int currentTermIndex;
	private boolean hasNextPage;
	private boolean hasPreviousPage;
	private boolean hasNextTerm;
	private boolean hasPreviousTerm;
	private String error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTimeUsed() {
		return timeUsed;
	}
	public void setTimeUsed(int timeUsed) {
		this.timeUsed = timeUsed;
	}
	public int getTimeRemaining() {
		return timeRemaining;
	}
	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	public String getCurrentTerm() {
		return currentTerm;
	}
	public void setCurrentTerm(String currentTerm) {
		this.currentTerm = currentTerm;
	}
	public String getCurrentTermDefinition() {
		return currentTermDefinition;
	}
	public void setCurrentTermDefinition(String currentTermDefinition) {
		this.currentTermDefinition = currentTermDefinition;
	}
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	public int getCurrentTermIndex() {
		return currentTermIndex;
	}
	public void setCurrentTermIndex(int currentTermIndex) {
		this.currentTermIndex = currentTermIndex;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public boolean isHasNextTerm() {
		return hasNextTerm;
	}
	public void setHasNextTerm(boolean hasNextTerm) {
		this.hasNextTerm = hasNextTerm;
	}
	public boolean isHasPreviousTerm() {
		return hasPreviousTerm;
	}
	public void setHasPreviousTerm(boolean hasPreviousTerm) {
		this.hasPreviousTerm = hasPreviousTerm;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	

}
