//The person types out a mathematical expression in the appropraite for that a regex will verify




package com.calculator;




import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String expression = "1+1++1";
		CalculatorFunctions calc = new CalculatorFunctions(expression); 
		
		System.out.println("Your mathematical expression: " + calc.isExpressionValid(expression));
		
	}

}