package package6;

import java.net.Inet4Address;
import java.util.ArrayList;

public class DotComNew {
	private String Name;
	private ArrayList<String> locationCells;
	
	public void setLocationCells(ArrayList<String> loc) {
		locationCells=loc;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	

	public String checkYourself(String userInput) {
		// TODO Auto-generated method stub
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if(index>=0) {
			locationCells.remove(index);
			if(locationCells.isEmpty()) {
				result="kill";
				System.out.println("Ouch! You sunk "+ Name +" :(");
			}
			else {
				result="hit";
			}
		}
		return result;
	}
}
