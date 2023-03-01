package jdbctrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CheckBuses extends Book {
	String data[][]= new String[8][5];
    JFrame f;    
    CheckBuses(){ 
    	
    	try {  //create instance of the NewPage 
    		String from,to;
        	
        	from=Book.value1;
        	to=Book.value2;
        	int seats=Book.value4;
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
    	    	   if(seats>=Integer.parseInt(data[i][4]))
    	    		   data[i][4]="Not Available";
    	    	   else
    	    		   data[i][4]="Available";
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
        
    String column[]={"BUS","FROM","TO","DATE","SEATS LEFT"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(700,400);    
    f.setVisible(true);
    setTitle("CHECK AVAILABILITY");
}

}
