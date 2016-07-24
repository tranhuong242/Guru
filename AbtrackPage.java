package Test;

import java.util.Random;

public class AbtrackPage {
	
	public String randomString(){
		Random rand = new Random();
		int number = rand.nextInt(900) + 1;
		String numberString = Integer.toString(number);
		return numberString;
}
}

