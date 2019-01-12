/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class InvertedHollowRightAngleTriangle {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size");
		int n = sc.nextInt();
		
		for(int i = n; i >= 1; i--) {
			for(int j = 1; j <= i ; j++) {
				if(i == 1 || i == n || j == 1 || j == n || j == i ) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
				
			}
			
			System.out.println();
			sc.close();
		}

	}

}


