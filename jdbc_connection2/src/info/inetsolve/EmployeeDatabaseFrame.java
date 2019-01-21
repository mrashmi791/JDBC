/**
 * 
 */
package info.inetsolve;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author lenovo
 *
 */
public class EmployeeDatabaseFrame extends Frame implements ActionListener {

	
	Label l1, l2, l3;
	TextField tf1, tf2, tf3;
	
	Button b;
	String status ="";
	
	public EmployeeDatabaseFrame() {
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("Student Info");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.pink);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		
		l1 = new Label("Student Id");
		l2 = new Label("Student Name");
		l3 = new Label("Student Roll");
		//l4 = new Label("Employee Address");
		
		tf1 = new TextField(20);
		tf2 = new TextField(20);
		tf3 = new TextField(20);
	//	tf4 = new TextField(20);
		
		b = new Button("ADD");
		b.addActionListener(this);
		
		
		Font font = new Font("consolas" , Font.BOLD, 18);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
	//	l4.setFont(font);
		
		tf1.setFont(font);
		tf2.setFont(font);
		tf3.setFont(font);
	//	tf4.setFont(font);
		b.setFont(font);
		
		
		this.add(l1);this.add(tf1);
		this.add(l2);this.add(tf2);
		this.add(l3);this.add(tf3);
		//this.add(l4);this.add(tf4);
		this.add(b);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			
			int id = Integer.parseInt(tf1.getText());
			String name = tf2.getText();
			int roll = Integer.parseInt(tf3.getText());
		//	String address = tf4.getText();
			
			EmployeeFacility empfacility = new EmployeeFacility();
			
			status = empfacility.add(id ,name, roll);
			repaint();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void paint(Graphics g) {
		Font font = new Font("consolas", Font.BOLD,25);
		g.setFont(font);
		g.drawString("status :", 100, 400);
	}

}


