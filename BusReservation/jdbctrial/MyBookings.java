package jdbctrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;    
public class MyBookings {  
	String data[][]= new String[5][7];
    JFrame f;    
    MyBookings(){ 
    	try {  //create instance of the NewPage 
    	   	Class.forName("com.mysql.cj.jdbc.Driver");
    	       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctrial","abbas","AB11**as");
    	       Statement stmt=conn.createStatement();
    	       String sql="select * from bookings where name='"+Login.name+"'";
    	       
    	       ResultSet rs =stmt.executeQuery(sql);
    	       int i=0;
    	       
    	       while(rs.next()) {
    	    	   data[i][0]=rs.getString(1);
    	    	   data[i][1]=rs.getString(2);
    	    	   data[i][2]=rs.getString(3);
    	    	   data[i][3]=rs.getString(4);
    	    	   data[i][4]=rs.getString(5);
    	    	   data[i][5]=rs.getString(6);
    	    	   data[i][6]="Confirm";
    	    	   
    	    	   i++;
    	       }
    	       System.out.println(data);
    	       rs.close();
    	       stmt.close();
    	       conn.close();}
    	   	catch(ClassNotFoundException e) {
    	   		System.out.println(e);
    	   	}
    	   	catch (SQLException e) {
    	           System.out.println(e);
    	       }
    	
    
    f=new JFrame();    
        
    String column[]={"Full Name","FROM","TO","DATE","SEATS BOOKED","BUSNAME","Booking Status"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(700,400);    
    f.setVisible(true);    
}
	}
