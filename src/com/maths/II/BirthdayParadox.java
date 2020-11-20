package com.maths.II;

/**
 * Question: How many people must be there in a room to make the probability 50%
 * that at-least two people in the room have same birthday?
 *
 */
public class BirthdayParadox {

	/**
	 * @param p is probability between 0 to 1 prints no of people not having same
	 *          birthday and having same birthday probability
	 */
	public static void sameBirthday(double p) {
		double x = 1.0;
		double denom = 365;
		double numer = 365;
		double people = 0;
		if (p == 1.0) {
			System.out.println("People " + 365 + " Probablity of not having same birthday " + 0);
			
			System.out
			.println("Probablity of two people having same birthday = 1- P(Not having same birthday) = " + 1 );
		return;
		}
		while (x > (1 - p)) {
			x = x * (numer) / denom;

			numer--;
			people++;
			System.out.println("People " + people + " Probablity of not having same birthday " + x);
		}
		System.out
				.println("Probablity of two people having same birthday = 1- P(Not having same birthday) = " + (1 - x));
	}

	public static void main(String[] args) {
		sameBirthday(1);

	}

}
