package util;

import java.util.Random;

public class RandomInt {

	/**
	* generate a pseudo-random number between 2 include values 
	* @param min : the min int
	* @param max : the max int
	* @param rand : the random
	* @return the pseudo-random number
	**/
	public static int randomInt(int min, int max, Random rand) {
		return rand.nextInt(max - min + 1) + min;
	}
}