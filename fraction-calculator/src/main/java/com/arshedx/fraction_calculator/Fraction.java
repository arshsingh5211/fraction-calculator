package com.arshedx.fraction_calculator;

public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		if (denominator == 0 && numerator != 0) { // WHY DID I HAVE TO ADD NUMERATOR != 0 TO PREVENT EXCEPTION
			throw new IllegalArgumentException("Denominator must be greater than 0.");
		}
		if ((denominator < 0 && numerator > 0) || (denominator < 0 && numerator < 0)) {
			denominator *= -1;
			numerator *= -1;
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction(int numerator) {
		if (denominator == 0 && numerator != 0) {
			this.numerator = numerator;
			this.denominator = 1;
		}
	}
	
	public Fraction() {
		if (numerator == 0 && denominator == 0) {
			this.numerator = 0;
			this.denominator = 1;
		}
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}
	
	public String toString() {
		String fractionToString = "";
		if (numerator != 0 && denominator != 1) {
			fractionToString = numerator + "/" + denominator;
		}
		else fractionToString = "" + numerator;
		return fractionToString;
	}
	
	public double toDouble() {
		return (double)(1.000 * numerator/denominator);
	}
	
	public Fraction add(Fraction other) {
		Fraction sum = new Fraction(0, 0);
		sum.numerator = (this.numerator * other.denominator) + (this.denominator * other.numerator);
		sum.denominator = this.denominator * other.denominator;
		return sum;
	}
	
	public Fraction subtract(Fraction other) {
		Fraction diff = new Fraction(0, 0);
		diff.numerator = (this.numerator * other.denominator) - (this.denominator * other.numerator);
		diff.denominator = this.denominator * other.denominator;
		return diff;
	}

	public Fraction multiply(Fraction other) {
		Fraction product = new Fraction(0, 0);
		product.numerator = this.numerator * other.numerator;
		product.denominator = this.denominator * other.denominator;
		return product;
	}
	
	public Fraction divide(Fraction other) {
		Fraction quotient = new Fraction(0, 0);
		quotient.numerator = this.numerator * other.denominator;
		quotient.denominator = this.denominator * other.numerator;
		return quotient ;
	}
	
	public boolean equals(Object other) {
		double thisDouble = Fraction.this.toDouble();
		double otherDouble = ((Fraction) other).toDouble();
		if ((!(other instanceof Fraction)) || (thisDouble != otherDouble)) {
			return false;
		}
			return true;
	}

	public void toLowestTerms() {
		numerator = Fraction.gcd(numerator, denominator) / numerator;
		denominator = Fraction.gcd(numerator, denominator) / denominator;
	}

	public static int gcd(int num, int den) {
		while (num != 0 && den != 0) {
			int remainder = den % num;
			num = den;
			den = remainder;
		}
			return num;
	}

}
