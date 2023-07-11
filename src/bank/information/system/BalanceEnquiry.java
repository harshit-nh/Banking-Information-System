package bank.information.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;
    BalanceEnquiry(String pin_number){
        this.pinnumber=pin_number;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,710,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);

        JLabel image =new JLabel(i3);
        image.setBounds(0,0,850,710);
        add(image);

        back= new JButton("Back");
        back.setBounds(345, 411, 140, 24);
        back.addActionListener(this);
        image.add(back);


        Conn c =new Conn();
        int balance =0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("transaction_type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        JLabel text= new JLabel("Your current account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(180, 240, 700, 35);
        image.add(text);


        setSize(850,670);
        setLocation(210,8);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args){
        new BalanceEnquiry("");
    }

}
