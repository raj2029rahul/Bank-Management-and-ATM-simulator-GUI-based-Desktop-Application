package atmSimulator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class BalanceEnquiry extends JFrame implements ActionListener {
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	JTextField t1;
	BalanceEnquiry(){

        /*JLabel l3 = new JLabel();
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
*/		setTitle("BALANCE ENQUIRY");
        l1 = new JLabel();
       // l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1=new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,14));
        l4=new JLabel("Enter Pin");
		l4.setFont(new Font("System",Font.BOLD,14));
		
        b1 = new JButton("BACK");
        b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		
        b2= new JButton("CHECK BALANCE");
        b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
        setLayout(null);

        l1.setBounds(70, 150, 400, 35);
        add(l1);

        l4.setBounds(120,10,80,30);
		add(l4);
		t1.setBounds(200,10,80,30);
		add(t1);
        b1.setBounds(250, 80, 80, 35);
        add(b1);
        
        b2.setBounds(70,80,150,35);
        add(b2);
        
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        

        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(450, 250);
        //setUndecorated(true);
        setLocation(500, 200);
        setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		int balance = 0;
        try{
        	String a=t1.getText();
        	if(ae.getSource()==b2){
        		if(t1.getText().equals("")) {
    				JOptionPane.showMessageDialog(null, "Please enter your PIN");
    			}else {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+a+"'");
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
		}
        	}else if(ae.getSource()==b1) {
        		setVisible(false);
                new Transaction().setVisible(true);
        	}
    }catch(Exception e){}
        l1.setText("Your Current Account Balance is Rs "+balance);
		
	}
	public static void main(String[] args) {
		
		new BalanceEnquiry().setVisible(true);
		
	}

}
