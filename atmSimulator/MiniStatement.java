package atmSimulator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class MiniStatement extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1;
	MiniStatement(){
		super("Mini Statement");
		setTitle("MINI STATEMENT");
		
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(450,40);
        
        l1 = new JLabel();
        add(l1);
        
        l2 = new JLabel("UCO Bank");
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(130, 120, 100, 20);
        add(l2);
        
        l3 = new JLabel();
        l3.setBounds(60, 160, 300, 20);
        add(l3);
        
        l4 = new JLabel();
        l4.setBounds(60, 480, 300, 20);
        add(l4);
        
        l5=new JLabel("Enter PIN");
        l5.setBounds(60,20,100,30);
        add(l5);
        t1=new JTextField();
        t1.setBounds(140,20,80,30);
        add(t1);
        //b1 20 60 80 30
        //b2 300 60 80 30
        b2=new JButton("GET");
        b2.setBounds(80,60,80,30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        l1.setBounds(60, 220, 400, 200);
        b1.setBounds(200, 60, 80, 30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
		
	}
	public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b2) {
        	String a=t1.getText();
		try{
        	
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+a+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+a+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("mode").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
	}
        else if(ae.getSource()==b1) {
        	System.exit(0);
        }
	}
	public static void main(String[] args) {
		new MiniStatement().setVisible(true);

	}

}
