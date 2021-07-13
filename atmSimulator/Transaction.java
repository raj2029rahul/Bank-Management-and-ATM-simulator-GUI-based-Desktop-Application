package atmSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.JFrame;

public class Transaction extends JFrame implements ActionListener {

	JLabel l;
	JButton b1,b2,b3,b4,b5,b6,b7;
	Transaction(){
		setTitle("TRANSACTION");
		l=new JLabel("Please select your transaction");
		l.setFont(new Font("System",Font.BOLD,38));
		l.setForeground(Color.WHITE);
		
		b1=new JButton("DEPOSIT");
		b1.setFont(new Font("System",Font.BOLD,18));
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		
		b2=new JButton("CASH WITHDRAWL");
		b2.setFont(new Font("System",Font.BOLD,18));
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		
		b3=new JButton("FAST CASH");
		b3.setFont(new Font("System",Font.BOLD,18));
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		
		b4=new JButton("MINI STATEMENT");
		b4.setFont(new Font("System",Font.BOLD,18));
		b4.setBackground(Color.BLUE);
		b4.setForeground(Color.WHITE);
		
		b5=new JButton("PIN CHANGE");
		b5.setFont(new Font("System",Font.BOLD,18));
		b5.setBackground(Color.BLUE);
		b5.setForeground(Color.WHITE);
		
		b6=new JButton("BALANCE ENQUIRY");
		b6.setFont(new Font("System",Font.BOLD,18));
		b6.setBackground(Color.BLUE);
		b6.setForeground(Color.WHITE);
		
		b7=new JButton("EXIT");
		b7.setFont(new Font("System",Font.BOLD,18));
		b7.setBackground(Color.BLUE);
		b7.setForeground(Color.WHITE);
		
		setLayout(null);
		l.setBounds(100,100,700,40);
		add(l);
		
		b1.setBounds(40,220,300,60);
		add(b1);
		b2.setBounds(440,220,300,60);
		add(b2);
		b3.setBounds(40,330,300,60);
		add(b3);
		b4.setBounds(440,330,300,60);
		add(b4);
		b5.setBounds(40,440,300,60);
		add(b5);
		b6.setBounds(440,440,300,60);
		add(b6);
		b7.setBounds(240,570,300,60);
		add(b7);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(800,700);
		setLocation(500,50);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			new Deposit().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b2) {
			new Withdrawl().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b3) {
			new Fastcash().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b4) {
			new MiniStatement().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b5) {
			new Pin().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b6) {
			new BalanceEnquiry().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b7) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Transaction().setVisible(true);
	}
}
