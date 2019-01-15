/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class InvertedTriangle {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rows");
		int n = sc.nextInt();
		
		for(int i = n ; i > 0; i--) {
			
			for(int j = n; j > i ; j-- ) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i*2-1 ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		sc.close();
	}

}


