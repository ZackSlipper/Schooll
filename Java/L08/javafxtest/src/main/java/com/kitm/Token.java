package com.kitm;

public class Token {

	private static String operators = "+-x/";

	private Integer number;
	private Character operator;
	private TokenType type;

	public Token(String token) {
		if (token.length() == 1 && operators.indexOf(token) > -1) {
			type = TokenType.OPERATOR;
			operator = token.charAt(0);
		}
		else {
			type = TokenType.NUMBER;
			try {
				number = Integer.parseInt(token);
			} catch (NumberFormatException e) {
				type = TokenType.INVALID;
			}
		}
	}

	public Integer getNumber() {
		return number;
	}

	public Character getOperator() {
		return operator;
	}

	public TokenType getType() {
		return type;
	}

	@Override
	public String toString() {
		if (type == TokenType.NUMBER) {
			return number.toString();
		} else if (type == TokenType.OPERATOR) {
			return operator.toString();
		} else {
			return "Invalid";
		}
	}
}
