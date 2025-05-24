package com.kitm;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(nonStart("Hello", "There"));
		System.out.println(nonStart("java", "code"));
		System.out.println(nonStart("shotl", "java"));

		System.out.println(removeStartingX("xxl"));
		System.out.println(removeStartingX("hxi"));
		System.out.println(removeStartingX("java"));

		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" World");
		
		System.out.println(sb.toString());


		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Hello " + name);
		scanner.close();
	}
	
	public static String nonStart(String text1, String text2) {
		return text1.substring(1).concat(text2.substring(1));
	}

	public static String removeStartingX(String text) {
		text = text.replaceFirst("x", "");
		text = text.replaceFirst("x", "");
		return text;
	}
}