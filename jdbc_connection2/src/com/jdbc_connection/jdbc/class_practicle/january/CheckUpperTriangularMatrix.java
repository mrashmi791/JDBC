/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class CheckUpperTriangularMatrix {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter matrix size");
		int n = sc.nextInt();
		
		int arr[][] = new int [n][n];
		
		System.out.println("Enter matrix elements");
		
		for(int i = 0 ; i < n ; i++) {
			for(int j= 0 ; j < n ; j++) {
				arr[i][j] = sc.nextInt();
			}
			
		}
		
		int upper = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j < i && arr[i][j] != 0) {
					upper = 0;
				}
			}
		}
		if(upper == 1) {
			System.out.println("It is a upper triangular matrix");
			
			for(int i = 0 ; i < n ; i++) {
				for(int j= 0 ; j < n ; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
				
			}
		} else {
			System.out.println("Not a upper triangular matrix");
		}
		sc.close();
	}

}


