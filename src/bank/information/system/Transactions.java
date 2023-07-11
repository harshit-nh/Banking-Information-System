package bank.information.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawal,fastcash,mini_statement,pin_change,balance_enquiry,exit;
    String pin_number;

    Transactions(String pinNumber){
        this.pin_number=pinNumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850,710,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,710);
        add(image);

        JLabel text= new JLabel("Please select your transaction");
        text.setBounds(208,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


        deposit =new JButton("Deposit");
        deposit.setBounds(150,329,140,22);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal =new JButton("Cash Withdrawal");
        withdrawal.setBounds(345,329,140,22);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(150,357,140,22);
        fastcash.addActionListener(this);
        image.add(fastcash);

        mini_statement =new JButton("Mini Statement");
        mini_statement.setBounds(345,357,140,22);
        mini_statement.addActionListener(this);
        image.add(mini_statement);

        pin_change=new JButton("Pin Change");
        pin_change.setBounds(150,385,140,22);
        pin_change.addActionListener(this);
        image.add(pin_change);

        balance_enquiry=new JButton("Balance Enquiry");
        balance_enquiry.setBounds(345,385,140,22);
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);

        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin_number).setVisible(true);
        }else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pin_number).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pin_number).setVisible(true);
        }else if(ae.getSource() == pin_change){
            setVisible(false);
            new PinChange(pin_number).setVisible(true);
        }else if(ae.getSource() == balance_enquiry){
            setVisible(false);
            new BalanceEnquiry(pin_number).setVisible(true);
        }else if(ae.getSource() == mini_statement){
            new MiniStatement(pin_number).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Transactions("");

    }
}
