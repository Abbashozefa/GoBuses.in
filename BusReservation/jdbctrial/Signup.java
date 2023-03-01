package jdbctrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class Signup extends JFrame implements ActionListener
 {String name,pwd;
  JButton SUBMIT;
  JPanel panel;
  JLabel label1,label2,label3;
  final JTextField  text1,text2,text3;
   Signup()
   {
   label1 = new JLabel();
   label1.setText("Username:");
   text1 = new JTextField(20);
   
   label2 = new JLabel();
   label2.setText("New Password:");
   text2 = new JPasswordField(20);
   
   label3 = new JLabel();
   label3.setText("Confirm Password:");
   text3 = new JPasswordField(20);
  
   SUBMIT=new JButton("SUBMIT");
   
   panel=new JPanel(new GridLayout(5,2));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(label3);
   panel.add(text3);
   panel.add(SUBMIT);
   add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   setTitle("GOBUSES.IN SIGN UP PAGE");
   }
  public void actionPerformed(ActionEvent ae)
   {
   String value1=text1.getText();
   String value2=text2.getText();
   String value3=text3.getText();
   if(value2.equals(value3)) {
   
   try {  //create instance of the NewPage 
   	Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
       Statement stmt=conn.createStatement();
       String sql="Insert into auth values('"+value1+"','"+value2+"')";
       
       int rs =stmt.executeUpdate(sql);
       
       
       stmt.close();
       conn.close();
       JOptionPane.showMessageDialog(this,"Account Created Successfully!!Please Log In with your credentials");
       Login page=new Login();
       page.setVisible(true);
       page.setSize(700,400);}
   	catch(ClassNotFoundException e) {
   		System.out.println(e);
   	}
   	catch (SQLException e) {
           System.out.println(e);
       }}
   
   else{
   System.out.println("enter the valid username and password");
   JOptionPane.showMessageDialog(this,"New Password and Confirm Password not same",
   "Error",JOptionPane.ERROR_MESSAGE);
   }
 }
 }