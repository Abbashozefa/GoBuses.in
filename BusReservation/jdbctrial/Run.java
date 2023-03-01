package jdbctrial;

import java.sql.*;
import java.util.Scanner ;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 

public class Run{
 public static void main(String args[])throws ClassNotFoundException{
     Scanner sc =new Scanner(System.in);
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
     Statement stmt=conn.createStatement();
     String name=sc.next();
     String pass=sc.next();
     String sql="Insert into auth values('"+name+"','"+pass+"')";
      
     int result =stmt.executeUpdate(sql);
     if (result > 0)
             System.out.println("successfully inserted");

         else
             System.out.println(
                 "unsucessful insertion ");

         // closing connection
         
     
     stmt.close();
     conn.close();
     sc.close();
 }
     catch (SQLException e) {
         System.out.println(e);
     }
 }
     
     



 }


