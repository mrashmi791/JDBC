/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class NumberPattern {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rows");
		int row = sc.nextInt();
		
		int k = 1;
		
		for(int i = 1 ; i <= row ; i++ ) {
			for (int j = 1 ; j <= row ; j++) {
				System.out.print(k + " ");
				k++;
			}
			System.out.println();
		}
		
	}

}


