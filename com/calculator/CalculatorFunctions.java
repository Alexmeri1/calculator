package com.calculator;

import java.util.Stack;
import java.util.regex.Pattern;

public class CalculatorFunctions {

	private String expression;

	public CalculatorFunctions(String expression) {
		this.expression = expression;
	}

	private static boolean isSymbol(char charAtI) {

		// The possible
		if (charAtI == '-' || charAtI == '+' || charAtI == '*' || charAtI == '/' || charAtI == '^') {
			return true;
		}
		return false;
	}

	private String stringWithNoSpaces(String expression) {
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
		if(ex == null) {
			return false;
		}

		String expression = stringWithNoSpaces(ex);

		//empty expression
				if (expression == "" ) {
					return false;
				}
				
		for (int i = 0; i < expression.length(); i++) {

			char charAtI = expression.charAt(i);
			char charAtLeft = (i > 0) ? expression.charAt(i - 1) : ' ';

			char charAtRight = (i < expression.length() - 1) ? expression.charAt(i + 1) : ' ';

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

					isDigitAtLeft = Character.isDigit(charAtLeft);

					isBracketAtLeft = charAtLeft == ')';

					isDigitAtRight = Character.isDigit(charAtRight);

					isBracketAtRight = charAtRight == '(';

					boolean isLeftValid = (isDigitAtLeft || isBracketAtLeft);
					boolean isRightValid = (isDigitAtRight || isBracketAtRight);
					// If the left or right is wrong and if theirs a symbol left or right
					if (!isLeftValid || !isRightValid && !(isSymbol(charAtRight) || isSymbol(charAtLeft))) {

						return false;
					}

				}

				if (!(Character.isDigit(expression.charAt(i - 1))) && !(Character.isDigit(expression.charAt(i + 1)))) {
					return false;
				}

			} else if (charAtI == '.' || charAtI == ',') {
				 boolean hasDigitOnLeft = (i > 0) && Character.isDigit(charAtLeft);
				 boolean hasDigitOnRight = (i < expression.length() -1)
						 					&& Character.isDigit(charAtRight);
				if (!hasDigitOnLeft && !hasDigitOnRight) {
					return false;
				}
				
			}

			/*
			 * else if (charAtI == '^') { // (8^3) or (8)^(3+5)
			 * 
			 * boolean isRightGood = false; boolean isLeftGood = false;
			 * 
			 * 
			 * isLeftGood = (Character.isDigit(charAtLeft) || (charAtLeft == ')'));
			 * 
			 * //Right either a digit or '(' isRightGood = (Character.isDigit(charAtRight)
			 * || (charAtRight == '('));
			 * 
			 * 
			 * 
			 * if( isRightGood && isLeftGood) { return false; //If left or right are not
			 * digits or if at left its not a digit and at right its not a opening bracket.
			 * } }
			 */
			else if (Character.isDigit(charAtI)) {
				continue;
				// do nothing just to be sure it's at least a digit
			} else {
				return false;
			}

		}
		
		
		return stackForBrackets.isEmpty();
	}

	public double answer(String expression) {

		
		
		
		return 0.0;
	}

}
