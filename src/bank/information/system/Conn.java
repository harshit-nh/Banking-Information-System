package bank.information.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            //Step1: CREATING THE CONNECTION
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","captaincook");
            //Step2: CREATE STATEMENT
            s=c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
