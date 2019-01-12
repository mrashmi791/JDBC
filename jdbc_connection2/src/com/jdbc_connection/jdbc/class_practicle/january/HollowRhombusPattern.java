/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author Rashmi
 *
 */
public class HollowRhombusPattern {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Rows");
		int row = sc.nextInt();
		
		for(int i = 1; i <= row; i++)  {
			for(int j = 1; j< i; j++) {
				System.out.print(" ");
				
			}
			for(int j = 1; j < row +i; j++) {
				if(j >= i) {
					if(i == 1 || i == j || i == row  || j == row + i-1) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			
			}
			System.out.println();
		}
		
		sc.close();

	}

}


