package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Topic_01_DataTypes {
	
	public void Test_String() {
		//format string
		String formatted = String.format("Toi la %s", "Lucy");
		System.out.println(formatted);
	}
	
	public void Test_Array() {
		String[] lsNames = {"Tam", "Nam", "Anh", "Phong"};
		List<String> studenNames = new ArrayList<String>();
		studenNames.add("one");
		studenNames.add("two");
		
		//loop 1
		for (int i = 0; i < lsNames.length; i++) {
			System.out.println(lsNames[i]);
		}
		
		//loop 2
		for (String name : lsNames) {
			System.out.println(name);
		}
		
		//loop 3
		for (Iterator<String> iterator = studenNames.iterator(); iterator.hasNext();) {
			String name = (String) iterator.next();
			System.out.println(name);
		}
		
		//sort
	}

	public void Test_List() {
		
	}
	
	public void Test_DateTime() {
		
	}
	
}
