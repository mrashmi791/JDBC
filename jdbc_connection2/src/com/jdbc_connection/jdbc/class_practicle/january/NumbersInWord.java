/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class NumbersInWord {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number");
		String number = sc.nextLine();
		
		
       int numLength = number.length();
	       
	        String numberToWord = "";

	        for (int j = 0; j < numLength; j++) {

	            switch (number.charAt(j)) {

	                case '1': {  
	                    numberToWord = numberToWord +" " + "one";
	                    break;
	                }
	                case '2': { 
	                    numberToWord = numberToWord + " " + "two";
	                    break;
	                }
	                case '3': {
	                    numberToWord = numberToWord + " " + "three";
	                    break;
	                }
	                case '4': {
	                    numberToWord = numberToWord + " " + "four";
	                    break;
	                }
	                case '5': {
	                    numberToWord = numberToWord + " " + "five";
	                    break;
	                }
	                case '6': {
	                    numberToWord = numberToWord + " " + "six";
	                    break;
	                }
	                case '7': {
	                    numberToWord = numberToWord + " " + "seven";
	                    break;
	                }
	                case '8': {
	                    numberToWord = numberToWord + " " + "eight";
	                    break;
	                }
	                case '9': {
	                    numberToWord = numberToWord + " " + "nine";
	                    break;
	                }
	                default: {
	                    numberToWord = numberToWord + " " + "zero";
	                }
	            }
	        }
	        System.out.println(numberToWord);
	        sc.close();
	}

}


