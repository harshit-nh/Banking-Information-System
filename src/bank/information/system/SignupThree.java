package bank.information.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree  extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);

        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280,10,400,40);
        add(l1);

        JLabel type= new JLabel("Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,70,200,30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(110,120,160,30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,120,220,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(110,170,160,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,170,240,30);
        add(r4);

        ButtonGroup accountgroup=new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card= new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100,225,200,30);
        add(card);

        JLabel number= new JLabel("XXXX-XXXX-XXXX-4567 ");
        number.setFont(new Font("Raleway", Font.BOLD,20));
        number.setBounds(330,227,270,30);
        add(number);

        JLabel carddetails= new JLabel("Your 16 digit Card Number ");
        carddetails.setFont(new Font("Raleway", Font.BOLD,12));
        carddetails.setBounds(100,257,300,20);
        add(carddetails);


        JLabel pin= new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,290,200,30);
        add(pin);

        JLabel pnumber= new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD,20));
        pnumber.setBounds(330,290,270,30);
        add(pnumber);

        JLabel pindetails= new JLabel("Your 4 digit Password ");
        pindetails.setFont(new Font("Raleway", Font.BOLD,12));
        pindetails.setBounds(100,320,300,20);
        add(pindetails);


        JLabel services= new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD,22));
        services.setBounds(100,360,240,30);
        add(services);

        c1= new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(110,400,200,30);
        add(c1);

        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,400,200,30);
        add(c2);

        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(110,440,200,30);
        add(c3);

        c4= new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,440,200,30);
        add(c4);

        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(110,480,200,30);
        add(c5);

        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,480,200,30);
        add(c6);


        c7= new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,13));
        c7.setBounds(100,540,600,33);
        add(c7);

        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(260,590,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(440,590,100,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,670);
        setLocation(210,8);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Savings Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Recurring Deposit Account";
            }

            Random random=new Random();
            String cardNumber= "65229401" + Math.abs((random.nextLong()% 90000000L)+ 10000000L);

            String pinNumber = "" + Math.abs((random.nextLong()% 9000L)+1000L);

            String facility = "";
            if(c1.isSelected()){
                facility= facility+" ATM Card";
            }else if(c2.isSelected()){
                facility= facility+" Internet Banking";
            }else if(c3.isSelected()){
                facility= facility+" Mobile Banking";
            }else if(c4.isSelected()){
                facility= facility+" EMAIL & SMS Alerts";
            }else if(c5.isSelected()){
                facility= facility+" Cheque Book";
            }else if(c6.isSelected()){
                facility= facility+" E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                }else{
                    Conn conn =new Conn();
                    String query1= "insert into signupthree values('"+formno+"' , '"+accountType+"' , '"+cardNumber+"' , '"+pinNumber+"' , '"+facility+"')";
                    String query2= "insert into login values('"+formno+"' , '"+cardNumber+"' , '"+pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: " +cardNumber+ "\n PIN Number: "+pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                }
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args){
        new SignupThree("");
    }
}
