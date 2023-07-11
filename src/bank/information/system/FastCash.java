package bank.information.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrawal,fastcash,mini_statement,pin_change,balance_enquiry,exit;
    String pinnumber;

    FastCash(String pinNumber){
        this.pinnumber=pinNumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850,710,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,710);
        add(image);

        JLabel text= new JLabel("Select withdrawal amount");
        text.setBounds(208,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


        deposit =new JButton("Rs 100");
        deposit.setBounds(150,329,140,22);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal =new JButton("Rs 500");
        withdrawal.setBounds(345,329,140,22);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash =new JButton("Rs 1000");
        fastcash.setBounds(150,357,140,22);
        fastcash.addActionListener(this);
        image.add(fastcash);

        mini_statement =new JButton("Rs 2000");
        mini_statement.setBounds(345,357,140,22);
        mini_statement.addActionListener(this);
        image.add(mini_statement);

        pin_change=new JButton("Rs 5000");
        pin_change.setBounds(150,385,140,22);
        pin_change.addActionListener(this);
        image.add(pin_change);

        balance_enquiry=new JButton("Rs 10000");
        balance_enquiry.setBounds(345,385,140,22);
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);

        exit=new JButton("Back");
        exit.setBounds(345,412,140,22);
        exit.addActionListener(this);
        image.add(exit);


        setSize(850,670);
        setLocation(210,8);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String fastCashAmount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c =new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;

                while(rs.next()){
                    if(rs.getString("transaction_type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -=Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance< Integer.parseInt(fastCashAmount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+fastCashAmount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+fastCashAmount+" debited successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        new FastCash("");

    }
}
