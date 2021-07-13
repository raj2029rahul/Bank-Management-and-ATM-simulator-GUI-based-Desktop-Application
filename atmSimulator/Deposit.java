package atmSimulator;

import java.awt.Color;
import java.util.Date;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.sql.*;
public class Deposit extends JFrame implements ActionListener {

	JTextField t1,t2;
	JButton b1,b2,b3;
	JLabel l1,l2,l3;
	Deposit(){
		setTitle("DEPOSIT");
		
		l1=new JLabel("ENTER AMOUNT YOU WANT");
		l1.setFont(new Font("System",Font.BOLD,35));
		l1.setForeground(Color.WHITE);
		
		l2=new JLabel("TO DEPOSIT");
		l2.setFont(new Font("System",Font.BOLD,35));
		l2.setForeground(Color.WHITE);
				
		l3=new JLabel("Enter Pin");
		l3.setFont(new Font("System",Font.BOLD,14));
		
		t1=new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,22));
		
		t2=new JTextField();
		t2.setFont(new Font("Raleway",Font.BOLD,14));
		
		b1=new JButton("DEPOSIT");
		b1.setFont(new Font("System",Font.BOLD,18));
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		
		b2=new JButton("BACK");
		b2.setFont(new Font("System",Font.BOLD,18));
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		
		b3=new JButton("EXIT");
		b3.setFont(new Font("System",Font.BOLD,18));
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		
		setLayout(null);
		l3.setBounds(620,10,80,30);
		add(l3);
		t2.setBounds(700,10,40,30);
		add(t2);
		l1.setBounds(150,150,800,60);
		add(l1);
		l2.setBounds(290,210,800,60);
		add(l2);
		t1.setBounds(250,300,300,50);
		add(t1);
		b1.setBounds(260,380,125,50);
		add(b1);
		b2.setBounds(415,380,125,50);
		add(b2);
		b3.setBounds(300,550,200,50);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		setSize(800,700);
		setLocation(500,30);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource()==b1) {
				String a=t1.getText();
				String b=t2.getText();
				Date date=new Date();
				if(t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
				}
				else {
					Conn c1=new Conn();
						String q1="insert into bank values('"+b+"','"+date+"','Deposit','"+a+"')";
						c1.s.executeUpdate(q1);
	
					JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Sucessfully");
					setVisible(false);
					new Transaction().setVisible(true);
					
				}	
			}
			else if(ae.getSource()==b2) {
				setVisible(false);
				new Transaction().setVisible(true);
				
			}
			else if(ae.getSource()==b3) {
				System.exit(0);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		
		new Deposit().setVisible(true);
	}

}
