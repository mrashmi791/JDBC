/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class NumberPattern1 {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter row");
		int row = sc.nextInt();
		
		for(int i = 1; i <= row; i++) {
			for(int j = i; j< i+ row; j++) {
				System.out.print(j + " " );
				
			}
			System.out.println();
		}
		sc.close();
	}

}


