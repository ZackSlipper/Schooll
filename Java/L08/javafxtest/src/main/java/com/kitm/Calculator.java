package com.kitm;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
	public static Token[] tokenizeExpression(String expression) {
		ArrayList<Token> tokens = new ArrayList<Token>();
		if (expression.length() == 0) {
			return new Token[0];
		} else if (expression.startsWith("-")) // Negative number fix
			expression = "0" + expression;

		StringBuilder number = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i))) {
				number.append(expression.charAt(i));
			} else {
				if (number.length() > 0) {
					tokens.add(new Token(number.toString()));
					number = new StringBuilder();
				}

				tokens.add(new Token(expression.charAt(i) + ""));
			}
		}

		if (number.length() > 0) {
			tokens.add(new Token(number.toString()));
		}

		return tokens.toArray(new Token[tokens.size()]);
	}

	public static boolean validateTokenSequence(Token[] tokens) {
		if (tokens == null || tokens.length == 0)
			return false;

		TokenType lastTokenType = TokenType.INVALID;
		for (Token token : tokens) {
			if (token.getType() == TokenType.INVALID)
				return false;

			if (token.getType() == TokenType.NUMBER) {
				if (lastTokenType == TokenType.NUMBER)
					return false;
			} else {
				if (lastTokenType == TokenType.OPERATOR)
					return false;
			}

			lastTokenType = token.getType();
		}

		if (lastTokenType != TokenType.NUMBER)
			return false;

		return true;
	}

	public static int evaluateTokens(Token[] tokens) {
		if (!validateTokenSequence(tokens))
			return 0;

		ArrayList<Token> remainingTokens = new ArrayList<>(Arrays.asList(tokens));
		// Multiplication
		for (int i = 0; i < remainingTokens.size(); i++) {
			Token token = remainingTokens.get(i);
			if (token.getType() != TokenType.OPERATOR || token.getOperator() != 'x')
				continue;

			int result = remainingTokens.get(i - 1).getNumber() * remainingTokens.get(i + 1).getNumber();
			System.out.println(remainingTokens.get(i - 1).getNumber() + " * " + remainingTokens.get(i + 1).getNumber() + " = " + result);
			for (int j = 0; j < 3; j++)
				remainingTokens.remove(i - 1);
			remainingTokens.add(i - 1, new Token(result + ""));
			i = 0;
		}

		// Division
		for (int i = 0; i < remainingTokens.size(); i++) {
			Token token = remainingTokens.get(i);
			if (token.getType() != TokenType.OPERATOR || token.getOperator() != '/')
				continue;

			int result = remainingTokens.get(i - 1).getNumber() / remainingTokens.get(i + 1).getNumber();
			System.out.println(remainingTokens.get(i - 1).getNumber() + " / " + remainingTokens.get(i + 1).getNumber() + " = " + result);
			for (int j = 0; j < 3; j++)
				remainingTokens.remove(i - 1);
			remainingTokens.add(i - 1, new Token(result + ""));
			i = 0;
		}

		// Subtraction
		for (int i = 0; i < remainingTokens.size(); i++) {
			Token token = remainingTokens.get(i);
			if (token.getType() != TokenType.OPERATOR || token.getOperator() != '-')
				continue;

			int result = remainingTokens.get(i - 1).getNumber() - remainingTokens.get(i + 1).getNumber();
			System.out.println(remainingTokens.get(i - 1).getNumber() + " - " + remainingTokens.get(i + 1).getNumber()
					+ " = " + result);
			for (int j = 0; j < 3; j++)
				remainingTokens.remove(i - 1);
			remainingTokens.add(i - 1, new Token(result + ""));
			i = 0;
		}

		// Addition
		for (int i = 0; i < remainingTokens.size(); i++) {
			Token token = remainingTokens.get(i);
			if (token.getType() != TokenType.OPERATOR || token.getOperator() != '+')
				continue;

			int result = remainingTokens.get(i - 1).getNumber() + remainingTokens.get(i + 1).getNumber();
			System.out.println(remainingTokens.get(i - 1).getNumber() + " + " + remainingTokens.get(i + 1).getNumber() + " = " + result);
			for (int j = 0; j < 3; j++)
				remainingTokens.remove(i - 1);
			remainingTokens.add(i - 1, new Token(result + ""));
			i = 0;
		}

		return remainingTokens.get(0).getNumber();
	}
}
