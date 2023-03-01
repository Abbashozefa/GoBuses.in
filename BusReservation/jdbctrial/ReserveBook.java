package jdbctrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReserveBook  extends JFrame implements ActionListener{
    String busname;
	JButton ConfirmBook;
	  JPanel panel;
	  JLabel label1,label1_2,label2,label2_2,label3,label3_2,label4,label4_2,label5,label5_2,label6,label6_2;
	  
	  JFrame f;
	
	
	ReserveBook()
	
	{  try {  //create instance of the NewPage 
	   	Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
	       Statement stmt=conn.createStatement();
	       
	       String sql1="select busname from buses where source='"+Book.value1+"' and destination='"+Book.value2+"' and date='"+Book.value3+"'";
	       
	       ResultSet rs =stmt.executeQuery(sql1);
	       rs.next();
	       busname=rs.getString(1);
	       stmt.close();
	       conn.close();}
	   	catch(ClassNotFoundException e) {
	   		System.out.println(e);
	   	}
	   	catch (SQLException e) {
	           System.out.println(e);
	       }
		
		String name=Login.name;
	label6= new JLabel();
	   label6.setText("Busname:");
	   label6_2= new JLabel();
	   label6_2.setText(busname);
	   label1_2 = new JLabel();
	   label1_2.setText(name);
		label1 = new JLabel();
		   label1.setText("Name:");
		   label1_2 = new JLabel();
		   label1_2.setText(name);
		   
		   label2 = new JLabel();
		   label2.setText("From:");
		   label2_2 = new JLabel();
		   label2_2.setText(Book.value1);
//		   text2 = new JTextField(15);
		   label3 = new JLabel();
		   label3.setText("To:");
		   label3_2 = new JLabel();
		   label3_2.setText(Book.value2);
//		   text3 = new JTextField(15);
		   label4= new JLabel();
		   label4.setText("Date:");
		   label4_2= new JLabel();
		   label4_2.setText(Book.value3);
//		   text4= new JTextField(15);
		   label5= new JLabel();
		   label5.setText("No. of Seats:");
		   label5_2= new JLabel();
		   label5_2.setText(Integer.toString(Book.value4));
//		   text5= new JTextField(15);
		  
		  
		   ConfirmBook=new JButton("Confirm Book");
		   
		   panel=new JPanel(new GridLayout(7,2));
		   panel.add(label1);
		   panel.add(label1_2);
		   panel.add(label2);
		   panel.add(label2_2);
		   panel.add(label3);
		   panel.add(label3_2);
		   panel.add(label4);
		   panel.add(label4_2);
		   panel.add(label5);
		   panel.add(label5_2);
		   
		   panel.add(ConfirmBook);
		   add(panel,BorderLayout.CENTER);
		   ConfirmBook.addActionListener(this);
		   
		   setTitle("CONFIRMATION PAGE -- GOBUSES.IN");
		   
}
	public void actionPerformed(ActionEvent ae)
	   {
		String value1=label1_2.getText();
		String value2=label2_2.getText();
		String value3=label3_2.getText();
		String value4=label4_2.getText();
		int value5=Integer.parseInt(label5_2.getText());
		String value6=label6_2.getText();
		
		
		try {  //create instance of the NewPage 
		   	Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
		       Statement stmt=conn.createStatement();
		       
		       String sql="Insert into bookings values('"+value1+"','"+value2+"','"+value3+"','"+value4+"',"+value5+",'"+value6+"')";
		       
		       int rs =stmt.executeUpdate(sql);
		       
		       stmt.close();
		       conn.close();}
		   	catch(ClassNotFoundException e) {
		   		System.out.println(e);
		   	}
		   	catch (SQLException e) {
		           System.out.println(e);
		       }
		JOptionPane.showMessageDialog(this,"Thank You "+Login.name+" Your Booking has been processed");
	   
	 }
		
}
