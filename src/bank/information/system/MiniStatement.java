package bank.information.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{

    String pinnumber;
    MiniStatement(String pin_number) {
        this.pinnumber = pin_number;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("INDIAN BANK");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_number = '"+pinnumber+"'");
            while(rs.next()){
                String cardNumber = rs.getString("card_number");
                String maskedCardNumber = "XXXXXXXXXXXX" + cardNumber.substring(12);
                card.setText("Card Number: " + maskedCardNumber);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn =new Conn();
            int bal=0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transaction_type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") +"<br><br><html>");

                if(rs.getString("transaction_type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs " + bal);
        }catch(Exception e){
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args){
        new MiniStatement("");
    }
}
