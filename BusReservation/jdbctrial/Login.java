package jdbctrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class Login extends JFrame implements ActionListener
 {public static String name,pwd;
  JButton SUBMIT;
  JPanel panel;
  JLabel label1,label2;
  final JTextField  text1,text2;
   Login()
   {
   label1 = new JLabel();
   label1.setText("Username:");
   text1 = new JTextField(50);
 
   label2 = new JLabel();
   label2.setText("Password:");
   text2 = new JPasswordField(15);
  
   SUBMIT=new JButton("SUBMIT");
   
   panel=new JPanel(new GridLayout(3,2));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(SUBMIT);
   add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   setTitle("GOBUSES.IN LOGIN PAGE");
   }
  public void actionPerformed(ActionEvent ae)
   {
   String value1=text1.getText();
   String value2=text2.getText();
   System.out.println(value1+value2);
   
   try {  //create instance of the NewPage 
   	Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
       Statement stmt=conn.createStatement();
       String sql="select username,password from auth where username='"+value1+"'";
       
       ResultSet rs =stmt.executeQuery(sql);
       rs.next();
       name=rs.getString(1);
       pwd=rs.getString(2);
       System.out.println(name+pwd);
       rs.close();
       stmt.close();
       conn.close();}
   	catch(ClassNotFoundException e) {
   		System.out.println(e);
   	}
   	catch (SQLException e) {
           System.out.println(e);
       }
   if (value1.equals(name) && value2.equals(pwd)) {
	   JOptionPane.showMessageDialog(this,"Logged In Successfully");
	   JOptionPane.showMessageDialog(this,"Welcome "+name);
   OptionPage page=new OptionPage();
   page.setVisible(true);
   page.setSize(700,400);
//   JLabel label = new JLabel("Welcome:"+value1);
//   page.getContentPane().add(label);
   }
   else{
   System.out.println("enter the valid username and password");
   JOptionPane.showMessageDialog(this,"Incorrect login or password",
   "Error",JOptionPane.ERROR_MESSAGE);
   }
 }
 }