/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class NumbersInReadingWord {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	
	
	public static void convert(int d,int m,int y) {
		  int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 
		    y -= (m < 3) ? 1 : 0; 
		    int h = ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
		

		    switch (h) {

            case 1: {  
               System.out.println("monday");
                break;
            }
            case 2: { 
            	 System.out.println("Tuesday");
                break;
            }
            case 3: {
            	 System.out.println("Wednesday");
                break;
            }
            case 4: {
            	 System.out.println("Thursday");
                break;
            }
            case 5: {
            	 System.out.println("Friday");
                break;
            }
            case 6: {
            	 System.out.println("Saturday");
                break;
            }
            case 7: {
           	 System.out.println("Sunday");
               break;
           }
            default: {
            	 System.out.println("Invalid date");
            }
		  }
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Date");
		int d = sc.nextInt();
		
		System.out.println("Enter Month");
		int m = sc.nextInt();
		
		System.out.println("Enter year");
		int y = sc.nextInt();
		
		 convert(d,m,y);
		sc.close();
	}

}


