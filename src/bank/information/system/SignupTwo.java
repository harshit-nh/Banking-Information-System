package bank.information.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame  implements ActionListener{


    JTextField pan,aadhaar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,occupation,education;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");


        JLabel additionalDetails=new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,50,400,30);
        add(additionalDetails);


        JLabel name=new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,100,100,30);
        add(name);

        String []valReligion ={"Hindu","Sikh","Christian","Muslim","Others"};
        religion =new JComboBox(valReligion);
        religion.setBounds(300,100,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname=new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,150,200,30);
        add(fname);

        String []valCategory={"General","OBC","SC","ST"};
        category =new JComboBox(valCategory);
        category.setBounds(300,150,400,30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel dob=new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,335,200,30);
        add(dob);

        String []valIncome={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(valIncome);
        income.setBounds(300,335,400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender=new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,200,200,30);
        add(gender);

        JLabel email=new JLabel("Qualification: ");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,230,200,30);
        add(email);

        String []educationValues={"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        education= new JComboBox(educationValues);
        education.setBounds(300,215,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel marital=new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,280,200,30);
        add(marital);

        String []occupationValues={"Salaried","Self-Employed","Businessmen","Student","Retired"};
        occupation= new JComboBox(occupationValues);
        occupation.setBounds(300,280,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address=new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,395,200,30);
        add(address);

        pan= new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,395,400,30);
        add(pan);

        JLabel state=new JLabel("Aadhaar Number: ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,450,200,30);
        add(state);

        aadhaar= new JTextField();
        aadhaar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhaar.setBounds(300,450,400,30);
        add(aadhaar);

        JLabel city=new JLabel("Senior Citizen: ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,500,200,30);
        add(city);

        syes= new JRadioButton("Yes");
        syes.setBounds(300,500,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno= new JRadioButton("No");
        sno.setBounds(450,500,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup =new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);


        JLabel pincode=new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,550,200,30);
        add(pincode);

        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,550,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno= new JRadioButton("No");
        eno.setBounds(450,550,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existGroup =new ButtonGroup();
        existGroup.add(eyes);
        existGroup.add(eno);

        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(700,600,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,670);
        setLocation(210,8);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }

        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }
        String span=pan.getText();
        String saadhaar=aadhaar.getText();

        try{
            Conn c=new Conn();
            String query="insert into signuptwo values('"+formno+"' , '"+sreligion+"' , '"+scategory+"' , '"+sincome+"' , '"+seducation+"' , '"+soccupation+"' , '"+span+"' , '"+saadhaar+"' , '"+seniorcitizen+"' , '"+existingaccount+"')";
            c.s.executeUpdate(query);

            //SignupThree object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new SignupTwo("");
    }
}
