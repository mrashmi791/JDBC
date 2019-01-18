/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class NumberRightangleTriangle {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rows");
		int row = sc.nextInt();
		
		for(int i = 1; i <=row; i++) {
			for(int j = 1; j<= i; j++) {
				System.out.print(row-i+1);
			}
			System.out.println();
		}
		sc.close();
	}

}


