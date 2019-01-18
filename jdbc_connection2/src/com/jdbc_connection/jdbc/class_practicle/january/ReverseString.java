/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author lenovo
 *
 */
public class ReverseString {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	
	
	public static String reverse(String s1) {
		  Pattern pattern = Pattern.compile("\\s"); 
		  
		  String[] temp = pattern.split(s1); 
	        String result = ""; 
	  
	        for (int i = 0; i < temp.length; i++) { 
	            if (i == temp.length - 1) 
	                result = temp[i] + result; 
	            else
	                result = " " + temp[i] + result; 
	        } 
	        return result; 
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String");
		String s1 = sc.nextLine();
		
		System.out.println(reverse(s1));
		
		sc.close();

	}

}


