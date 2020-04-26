package package5;

import java.util.ArrayList;

public class game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfGuesses=0;
		GameHelper helper=new GameHelper();
		DotCom theDotCom=new DotCom();
		int random=(int)(Math.random()*5);
		String random1=String.valueOf(random);
		String random2=String.valueOf(random+1);
		String random3=String.valueOf(random+2);
		//int[] locations= {random,random+1,random+2};
		ArrayList<String> myList = new ArrayList<String>();
		myList.add(random1);
		myList.add(random2);
		myList.add(random3);
		theDotCom.setlocationCells(myList);
		boolean isAlive=true;
		while(isAlive==true) {
			String guess=helper.getUserInput("ÇëÊäÈë²Â²âÊý×Ö:");
			String result=theDotCom.checkYoursself(guess);
			System.out.println(result);
			numOfGuesses++;
			if(result.equals("kill")) {
				isAlive=false;
				System.out.println("You took "+numOfGuesses+" guess");
			}
		}
		
	}

}
