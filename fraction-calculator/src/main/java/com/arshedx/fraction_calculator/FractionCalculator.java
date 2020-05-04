package com.arshedx.fraction_calculator;

import java.util.Scanner;

public class FractionCalculator {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner (System.in);
		System.out.println("This program is a fraction calculator.");
		System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
		System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
		System.out.println("-------------------------------------------------------------------------------");
		//System.out.println();
		
		boolean run = true;
		while (run) {
			System.out.print("Please enter an operation (+, -, *, /, =, or Q to quit): ");
			String op = getOperation(userInput);
				if (op.equals("Q") || op.equals("q")) {
					run = false;
					System.exit(0);
				}
				else run = true;
			
			System.out.print("Please enter a fraction(a/b) or integer(a): ");
			Fraction fractOne = getFraction(userInput);
			System.out.print("Please enter another fraction(a/b) or integer(a): ");
			Fraction fractTwo = getFraction(userInput);
				if (op.equals("+")) {
					Fraction addedFract = fractOne.add(fractTwo);
					System.out.println(fractOne + " + " + fractTwo + " = " + addedFract);
				}
				if (op.equals("-")) {
					Fraction subtractedFract = fractOne.subtract(fractTwo);
					System.out.println(fractOne + " - " + fractTwo + " = " + subtractedFract);
				}
				if (op.equals("*")) {
					Fraction multipliedFract = fractOne.multiply(fractTwo);
					System.out.println(fractOne + " * " + fractTwo + " = " + multipliedFract);
				}
				if (op.equals("/")) {
					Fraction dividedFract = fractOne.divide(fractTwo);
					if (fractTwo.getNumerator() == 0) {
						System.out.println(fractOne + " / " + fractTwo + " = undefined ");
					}
					else System.out.println(fractOne + " / " + fractTwo + " = " + dividedFract);
				}
				if (op.equals("=")) {
					boolean equalFract = fractOne.equals(fractTwo);
					System.out.println(fractOne + " = " + fractTwo + " is " + equalFract + ".");
				}
			System.out.println("-------------------------------------------------------------------------------");
		}
	}

	
	public static String getOperation(Scanner opInput) {
	    String op = opInput.nextLine();
	    while (!(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("Q") || op.equals("q") || op.equals("="))) {
	        System.err.print(op + " is not valid! Please select a valid operator (+, -, /, *, =, or Q to quit): ");
	        op = opInput.nextLine();
	    }
	    	return op;
	}
	
	public static boolean isValidFraction(String s) {
		if ((s.contains("/") && isNumber(s)) || isNumber(s)) {
			return true;
		}
			return false;
	}
	
	public static boolean isNumber (String s) {
		boolean b = false;
		String[] numberArray = s.split("/");
		for (int i = 0; i < numberArray.length; i++) {
			Integer.parseInt(numberArray[i]);
			if ((numberArray[i].indexOf("-") == 0) || !numberArray[i].contains("-")) {
				b = true;
			}
				b = false;
        }
				return b;
	}
		
	public static Fraction getFraction(Scanner input) {
		Fraction fract = new Fraction (0, 1);
	    String f = input.nextLine();
	    while (f.isEmpty() || !f.matches("[0-9/-]+")) { //("[0-9/]+(,[0-9]+)*,?")
	        System.err.print("Sorry, that is not valid! Please enter a fraction(a/b) or integer(a) to continue: ");
	        f = input.nextLine();
	    }
	    String[] fractArray = f.split("/");
	    	for (int i = 0; i < fractArray.length; i++) {
	    		if (fractArray.length > 1) {
	    			fract = new Fraction((Integer.parseInt(fractArray[0])), (Integer.parseInt(fractArray[1])));
	    		}
	    		if (fractArray.length == 1) {
	    			fract = new Fraction(Integer.parseInt(fractArray[0]));
	    		}
	    	}
	    		return fract;
	}
}
