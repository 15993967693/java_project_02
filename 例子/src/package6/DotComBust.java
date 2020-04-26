package package6;

import java.util.*;

import package5.DotCom;
import package5.GameHelper;
public class DotComBust {
	private GameHelperNew helper =new GameHelperNew();
	private ArrayList<DotComNew> dotComsList = new ArrayList<DotComNew>();
	private int numOfGuesses=0;//helper对象为输入辅助对象，dotComList为保存cell名字
								//numOfGuesses为计数变量
	private void setUpGame() {
		DotComNew one =new DotComNew();
		one.setName("Pets.com");
		DotComNew two = new DotComNew();
		two.setName("eToys.com");
		DotComNew three=new DotComNew();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);		//
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		for(DotComNew dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
	}

	private void checkUserGuess(String userGuess) {
		// TODO Auto-generated method stub
		numOfGuesses++;
		String result="miss";
		for(DotComNew dotComToTest:dotComsList) {
			result=dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")){
				break;
			}
			if(result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
			System.out.println(result);
		}
	}
	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if(numOfGuesses<=18) {
			System.out.println("It only took you " +numOfGuesses+"guesses.");
			System.out.println("You got out before your options sank,");
			
		}else {
			System.out.println("Took you long enough."+numOfGuesses +"guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}
	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}
