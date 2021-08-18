package common;

public class Topic_03_Enum {
	enum Level {
		  LOW,
		  MEDIUM,
		  HIGH
		}
	
	public void Test_Enum() {
		
	    Level myVar = Level.MEDIUM;

	    switch(myVar) {
	      case LOW:
	        System.out.println("Low level");
	        break;
	      case MEDIUM:
	         System.out.println("Medium level");
	        break;
	      case HIGH:
	        System.out.println("High level");
	        break;
	    }
	}
}
