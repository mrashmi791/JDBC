/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class ChessBoardPattern {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rows");
		int row = sc.nextInt();
		
		for (int i = 1; i <= row ; i++) {
			for(int j = 0 ; j <= row ; j++) {
				if (i % 2 == 1) {
					if(j % 2 == 0) {
						System.out.print("0");
					} else {
						System.out.print("1");
					}
					
				}
				
				
				else if(i % 2 == 0) {
					if(j % 2 == 1) {
						System.out.print("0");
					} else {
						System.out.print("1");
					}
				}
			}
			System.out.println();
		}
		sc.close();

	}

}


