package com.kitm;

public class Main {
	public static void main(String[] args) {
		/*//Challenge #1
		byte byteNum = 127;
		short shortNum = 25000;
		int intNum = 2000000000;
		long longNum = 50000 + 10 * (long)(byteNum + shortNum + intNum);
		
		System.out.println(byteNum);
		System.out.println(shortNum);
		System.out.println(intNum);
		System.out.println(longNum);
		
		//Floating point numbers
		float floatNum = 3.14f;
		double doubleNum = 3.14;
		
		//Challenge #2
		float pounds = 200f;
		double kilograms = pounds * 0.45359237;
		
		System.out.println(pounds + " pounds is equal to " + kilograms + " kilograms.");
		
		//Char
		char myChar = 'S';
		char myUnicodeChar = '\u0043';
		char myNumChar = 65;
		
		System.out.println(myChar);
		System.out.println(myUnicodeChar);
		System.out.println(myNumChar);
		
		//Challenge #3
		char questionMark1 = '?';
		char questionMark2 = '\u003F';
		char questionMark3 = 63;
		
		System.out.println(questionMark1);
		System.out.println(questionMark2);
		System.out.println(questionMark3);
		
		//String
		String myString = "This is a string";
		System.out.println(myString);
		
		System.out.println(myString.charAt(5));
		
		//Challenge #4
		boolean gameOver = true;
		int score = 0;
		int levelCompleted = 0;
		int bonus = 0;
		
		score = 10000;
		levelCompleted = 8;
		bonus = 200;
		
		if (gameOver) {
			int finalScore = score + (levelCompleted * bonus);
			System.out.println("Your final score is " + finalScore);
		}*/
		
		Student.SayHello("Zack");
		System.out.println(Student.ShowStudentName("Zack"));
    }
}
