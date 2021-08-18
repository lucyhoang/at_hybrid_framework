package common;

public class Topic_02_Statements {
	
	public void Condition() {
		
	}
	
	public void Loop() {
		
	}
	
	//Rest parameter
	//Always at the last parameter
	public void Hello(String me, String... names) {
		for (String name : names) {
			System.out.println(me + " xin chao " + name);
		}
	}
}
