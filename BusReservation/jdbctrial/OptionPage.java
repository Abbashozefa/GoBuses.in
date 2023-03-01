package jdbctrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OptionPage extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btn1,btn2,btn3,btn4;
	  JPanel panel;
	  
	  
	   OptionPage()
	   {
	   
	  
	   btn1=new JButton("Check Booking Status");
	   btn2=new JButton("Book Tickets");
	   btn3=new JButton("Check Buses");
	   btn4=new JButton("Contact Us");
	   btn1.addActionListener(this);
	   btn2.addActionListener(this);
	   btn3.addActionListener(this);
	   btn4.addActionListener(this);
	   
	   panel=new JPanel(new GridLayout(3,1));
	   
	   
	   panel.add(btn1);
	   panel.add(btn2);
	   panel.add(btn3);
	   panel.add(btn4);
	   add(panel,BorderLayout.CENTER);
	   
	   setTitle("HOMEPAGE-GOBUSES.IN");
	   }
	  public void actionPerformed(ActionEvent ae)
	   {
		  if (ae.getSource()==btn1) {
			  new MyBookings();
		  }////if authentic, navigate user to a new page  
              
	      else if(ae.getSource()==btn2) {
	    	  Book frame=new Book();
	          frame.setVisible(true);
	          frame.setSize(700,400);
	      }
	      else if(ae.getSource()==btn3) {
	    	 new Buses();
	    	 
	       }
	      else  {}	            
	              
	            //make page visible to the user              
	          
	    }  
}
