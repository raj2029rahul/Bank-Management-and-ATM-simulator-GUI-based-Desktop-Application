package atmSimulator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;
public class Fastcash extends JFrame implements ActionListener{
	JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    
    Fastcash(){
    	
    	setTitle("FAST CASH");
    	l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
       // l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));
        
        l2=new JLabel("Enter PIN");
        l2.setFont(new Font("System",Font.BOLD,13));
        
        t1=new JTextField();
        t1.setFont(new Font("System",Font.BOLD,13));

        b1 = new JButton("Rs 100");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Rs 500");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Rs 1000");
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("Rs 2000");
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("Rs 5000");
        b5.setBackground(Color.BLUE);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("Rs 10000");
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("EXIT");
        b7.setBackground(Color.BLUE);
        b7.setForeground(Color.WHITE);
        
        setLayout(null);

        l1.setBounds(80, 60, 700, 35);
        add(l1);
        l2.setBounds(80,10,60,40);
        add(l2);
        t1.setBounds(200,10,60,30);
        add(t1);

        b1.setBounds(80, 130, 150, 35);
        add(b1);

        b2.setBounds(290, 130, 150, 35);
        add(b2);

        b3.setBounds(80, 200, 150, 35);
        add(b3);

        b4.setBounds(290, 200, 150, 35);
        add(b4);

        b5.setBounds(80, 270, 150, 35);
        add(b5);

        b6.setBounds(290, 270, 150, 35);
        add(b6);

        b7.setBounds(190, 340, 150, 35);
        add(b7);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(520, 470);
        setLocation(500, 20);
        
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
    	try {
    		
    		String a=t1.getText();
    		String amount = ((JButton)ae.getSource()).getText().substring(3); 
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+a+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transaction().setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+a+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transaction().setVisible(true);
            } 
    	}catch(Exception e) {e.printStackTrace();}
    }
	public static void main(String[] args) {
		new Fastcash().setVisible(true);

	}

}
