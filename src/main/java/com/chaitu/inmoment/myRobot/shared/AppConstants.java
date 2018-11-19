package com.chaitu.inmoment.myRobot.shared;


/*
 * This class holds the constants that can be shared among multiple packages of the application
 * This is referred as "Constant Interface Anti Pattern"
 * There are many advantages to use this instead of an interface
 * 
 */
public final class AppConstants {
      
	private AppConstants()	{	}
    
	public static final String BASE_URL_COMPANY_API="https://oke5yaeave.execute-api.us-west-2.amazonaws.com/prod";
      public static final String COMPANY_API_KEY="NiS2QQIpZyaVqAqaYEYcB47oLpmQIt0t11EfGtbk";
    
      //PATHS  TO GET ROBOT STATUS
      
      public static final String GET_ROBOT_STATUS="/status";
      
      //PATHS FOR ARMS ACTIONS
      
      public static final String MOVE_TO_NEXT_PAGE="/move-to-next-page";
      public static final String MOVE_TO_PREVIOUS_PAGE="/move-to-previous-page";
      public static final String JUMP_TO_FIRST_PAGE="/jump-to-first-page";
      public static final String JUMP_TO_LAST_PAGE="/jump-to-last-page";
      
    //PATHS FOR CAMERA ACTIONS
      
      public static final String MOVE_TO_NEXT_TERM="/move-to-next-term";
      public static final String MOVE_TO_PREVIOUS_TERM="/move-to-previous-term";
      public static final String JUMP_TO_FIRST_TERM="/jump-to-first-term";
      public static final String JUMP_TO_LAST_TERM="/jump-to-last-term";
      
      

}
