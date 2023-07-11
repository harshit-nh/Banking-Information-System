package bank.information.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JPasswordField pin,rePin;
    JButton change,back;
    String pinnumber;

    PinChange(String pin_number){
        this.pinnumber=pin_number;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(850,710, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image =new JLabel(i3);
        image.setBounds(0,0,850,710);
        add(image);


        JLabel text= new JLabel("Change your PIN");
        text.setBounds(245,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);

        JLabel pinText= new JLabel("New PIN: ");
        pinText.setBounds(160,265,150,25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(pinText);

        pin= new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(320,265,150,25);
        image.add(pin);

        JLabel rePinText= new JLabel("Re-enter new PIN: ");
        rePinText.setBounds(160,300,150,25);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(rePinText);

        rePin= new JPasswordField();
        rePin.setFont(new Font("Raleway",Font.BOLD,20));
        rePin.setBounds(320,300,150,25);
        image.add(rePin);


        change = new JButton("Change");
        change.setBounds(345, 383, 140, 24);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(345, 411, 140, 24);
        back.addActionListener(this);
        image.add(back);


        setSize(850,670);
        setLocation(210,8);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == change){
            try{
                String npin =pin.getText();
                String rpin =rePin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }

                Conn conn= new Conn();
                String query1= "update bank set pin ='"+rpin+"' where pin='"+pinnumber+"'";
                String query2= "update login set pin_number ='"+rpin+"' where pin_number='"+pinnumber+"'";
                String query3= "update signupthree set pin_number ='"+rpin+"' where pin_number='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args){
        new PinChange("").setVisible(true);


    }
}
