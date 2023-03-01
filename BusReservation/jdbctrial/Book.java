package jdbctrial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Book extends JFrame implements ActionListener {
	String data[][]= new String[8][5];
	public static  String value1,value2,value3;
	public static int value4;
	JButton Check,BookSeat;
	  JPanel panel;
	  JLabel label1,label2,label3,label4;
	  final JTextField  text1,text2,text3,text4;
	  DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	  JFormattedTextField txtDate = new JFormattedTextField(df);
	Book()
	{
		label1 = new JLabel();
		   label1.setText("From:");
		   text1 = new JTextField(15);
		 
		   label2 = new JLabel();
		   label2.setText("To:");
		   text2 = new JTextField(15);
		   label3 = new JLabel();
		   label3.setText("Date:");
		   text3 = new JTextField(15);
		   label4= new JLabel();
		   label4.setText("	Seats:");
		   text4= new JTextField(15);
		  
		   Check=new JButton("Check Availability");
		   BookSeat=new JButton("Book");
		   
		   panel=new JPanel(new GridLayout(5,2));
		   panel.add(label1);
		   panel.add(text1);
		   panel.add(label2);
		   panel.add(text2);
		   panel.add(label3);
		   panel.add(text3);
		   panel.add(label4);
		   panel.add(text4);
		   panel.add(Check);
		   panel.add(BookSeat);
		   add(panel,BorderLayout.CENTER);
		   Check.addActionListener(this);
		   BookSeat.addActionListener(this);
		   setTitle("BOOKING PAGE--GOBUSES.IN");
}
	public void actionPerformed(ActionEvent ae)
	   {
		value1=text1.getText();
		    value2=text2.getText();
		    value3=text3.getText();
		    value4=Integer.parseInt(text4.getText());
		   if (ae.getSource()==Check) {
			   new CheckBuses();
		   }
		   
		   else  {
			   try {  //create instance of the NewPage 
		    		String from,to;
		        	
		        	from=value1;
		        	to=value2;
		        	int seats=value4;
		        	System.out.println(from+to);
		    	   	Class.forName("com.mysql.cj.jdbc.Driver");
		    	       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
		    	       Statement stmt=conn.createStatement();
		    	       String sql="select * from buses where source='"+from+"' and destination='"+to+"'";
		    	       
		    	       ResultSet rs =stmt.executeQuery(sql);
		    	       int i=0;
		    	       
		    	       while(rs.next()) {
		    	    	   data[i][0]=rs.getString(1);
		    	    	   data[i][1]=rs.getString(2);
		    	    	   data[i][2]=rs.getString(3);
		    	    	   data[i][3]=rs.getString(4);
		    	    	   data[i][4]=rs.getString(5);
		    	    	   i++;
		    	    	   
		    	       }
		    	       for(int j=0;j<5;j++)
		    	    	   System.out.println(data[0][j]);
		    	       rs.close();
		    	       stmt.close();
		    	       conn.close();}
		    	   	catch(ClassNotFoundException e) {
		    	   		System.out.println(e);
		    	   	}
		    	   	catch (SQLException e) {
		    	           System.out.println(e);
		    	       }
		   if(value4<=Integer.parseInt(data[0][4])  && value1.equals(data[0][1]) && value2.equals( data[0][2]) && value3.equals(data[0][3]) ) {
			   try {  
//				   && data[0][1]==value1 && data[0][2]==value2 && data[0][3]==value3
		    		
		        	
		    	   	Class.forName("com.mysql.cj.jdbc.Driver");
		    	       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
		    	       Statement stmt=conn.createStatement();
		    	       String sql="update buses set seats=seats-"+value4;
		    	       
		    	       int rs =stmt.executeUpdate(sql);
		    	       stmt.close();
		    	       conn.close();}
		    	   	catch(ClassNotFoundException e) {
		    	   		System.out.println(e);
		    	   	}
		    	   	catch (SQLException e) {
		    	           System.out.println(e);
		    	       }
			   ReserveBook frame=new ReserveBook();
			   frame.setSize(700,400);    
			    frame.setVisible(true);
		   }
		   else{
			   System.out.println("enter the valid username and password");
			   JOptionPane.showMessageDialog(this,"The Bus that you are looking for is not available");
			   }
		   
			   
		   }
		
	   
	 }
}

