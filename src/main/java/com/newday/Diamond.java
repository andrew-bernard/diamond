package com.newday;

import java.util.Scanner;

public class Diamond {
	private final String SPACE = " ";
	private int asciiLetterA = 65;

	public static void main(String[] args) {
		System.out.print("Enter a letter between A to Z : ");

		Scanner reader = new Scanner(System.in);

		String letter = reader.next("[A-Z]");
		Diamond diamond = new Diamond();
		System.out.println(diamond.print(letter));
	}

	public int getLetterPosition(String letterEntered) {
		return (char) letterEntered.charAt(0) - asciiLetterA;
	}

	public String print(String letter) {
		int letterIndex = getLetterPosition(letter);

		StringBuilder diamondString = new StringBuilder();
		int letterPosition = (char) letter.charAt(0);
		int iterations = getLetterPosition(letter);
		for (int letterCount = 0; letterCount <= iterations; letterCount++) {
			addSpace(diamondString, letterIndex, letterCount);

			if (letterPosition != asciiLetterA) {
				addLetters(diamondString, letterCount);
			} else {
				diamondString.append(Character.toString(letterCount));
			}
			addSpace(diamondString, letterIndex, letterCount);
			diamondString.append("\n");
		}

		reverse(new StringBuilder(diamondString).reverse().toString().split("\n"), diamondString);

		return diamondString.toString();
	}

	private void reverse(String[] diamondStringArray, StringBuilder diamondString) {
		StringBuilder reverse = new StringBuilder();
		for (int i = 2; i <= diamondStringArray.length - 1; i++) {
			reverse.append(diamondStringArray[i]).append("\n");
		}
		diamondString.append(reverse);
	}

	private void addLetters(StringBuilder diamondString, int rowCount) {
		diamondString.append((String) Character.toString(asciiLetterA + rowCount));
		addSpace(diamondString, rowCount);
		if (rowCount > 0)
			diamondString.append((String) Character.toString(asciiLetterA + rowCount));

	}

	private void addSpace(StringBuilder diamondString, int letterIndex, int letterCount) {
		for (int spaceCount = 0; spaceCount < letterIndex - letterCount; spaceCount++) {
			diamondString.append(SPACE);
		}
	}

	private void addSpace(StringBuilder diamondString, int index) {
		for (int j = 1; j <= 2 * index - 1; j++) {
			diamondString.append(SPACE);
		}
	}

}
