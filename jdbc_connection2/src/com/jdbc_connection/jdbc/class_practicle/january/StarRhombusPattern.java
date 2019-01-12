/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class StarRhombusPattern {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rows");
		int rows = sc.nextInt();
		
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print(" ");
				
			}
			for(int j = 1; j< rows + 1; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		sc.close();
	}

}


