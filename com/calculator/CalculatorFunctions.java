package com.calculator;

import java.util.Stack;
import java.util.regex.Pattern;

public class CalculatorFunctions {

	private String expression;

	public CalculatorFunctions(String expression) {
		this.expression = expression;
	}

	public static boolean isSymbol(char charAtI) {
		if (charAtI == '-' || charAtI == '+' || charAtI == '*' || charAtI == '/' || charAtI == '^') {
			return true;
		}
		return false;
	}

	public String stringWithNoSpaces(String expression) {
		String newExpresssion = "";

		for (int i = 0; i < expression.length(); i++) {
			char charAtI = expression.charAt(i);
			if (charAtI != ' ') {
				newExpresssion += charAtI;
			}

		}
		System.out.println("The unedited expression is:" + expression);
		System.out.println("The edited expression is:" + newExpresssion);
		return newExpresssion;

	}

	public boolean isExpressionValid(String ex) {
		// So that only () this is correct or () ( () ) , but not this ( () ))
		Stack<Character> stackForBrackets = new Stack<>();
		// So that + or - or * or / or ^ have either something in front or behind
		// (either number or bracket),
		// no 2 concurrent symbols

		String expression = stringWithNoSpaces(ex);

		for (int i = 0; i < expression.length(); i++) {

			char charAtI = expression.charAt(i);

			if (charAtI == '(') {

				stackForBrackets.push(charAtI);

			} else if (charAtI == ')') {

				if (stackForBrackets.isEmpty()) {

					return false;

				} else {

					stackForBrackets.pop();
				}

			} else if (isSymbol(charAtI)) {

				if (i == 0 || i == expression.length() - 1) {

					return false; // Symbols cannot be at the start or end

				} else {

					boolean isDigitAtLeft = false;
					boolean isDigitAtRight = false;
					boolean isBracketAtLeft = false;
					boolean isBracketAtRight = false;

					boolean isSymbolAtRight = false;
					boolean isSymbolAtLeft = false;

					char charAtLeft = expression.charAt(i - 1);
					char charAtRight = expression.charAt(i + 1);

					isDigitAtLeft = Character.isDigit(charAtLeft);

					isBracketAtLeft = charAtLeft == ')';

					isSymbolAtLeft = isSymbol(charAtLeft);

					isDigitAtRight = Character.isDigit(charAtRight);

					isBracketAtRight = charAtRight == '(';

					isSymbolAtRight = isSymbol(charAtRight);

					boolean isLeftValid = (isDigitAtLeft || isBracketAtLeft);
					boolean isRightValid = (isDigitAtRight || isBracketAtRight);
					// If the left or right is wrong and if theirs a symbol left or right
					if (!isLeftValid || !isRightValid && !(isSymbol(charAtRight) || isSymbol(charAtLeft))) {
 
						return false;
					}

				}
				//LOL
				if (!(Character.isDigit(expression.charAt(i - 1))) && !(Character.isDigit(expression.charAt(i + 1)))) {
					return false;
				}

			} else if (Character.isDigit(charAtI)) {
				continue;
				// do nothing just to be sure it's at least a digit
			} else {
				return false;
			}

		}

		return stackForBrackets.isEmpty();
	}

}
