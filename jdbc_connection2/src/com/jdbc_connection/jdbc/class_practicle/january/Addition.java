/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

/**
 * @author lenovo
 *
 */
public class Addition {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	
	
	public int add(int a, int b) {
		int c = a+b;
		return c;
		
	}
	
	
	public static void main(String[] args) {
		
		int count = new Addition().add(20, 30);
		System.out.println(count);
		
		//System.out.println(new Addition().add(20, 30));
		
	}

}


