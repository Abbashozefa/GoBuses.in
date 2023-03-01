package jdbctrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class NextPage extends JFrame implements ActionListener
 {
   /**
	 * 
	 */
	JButton btn1, btn2;
	JPanel newPanel; 
	private static final long serialVersionUID = 1L;
NextPage()

  {
	
	
  
  btn1=new JButton("Login");
  btn1.setBounds(10,20,10,10);
  btn2=new JButton("Sign up");
  btn2.setBounds(70,20,10,10);
  btn1.addActionListener(this);
  btn2.addActionListener(this);
  newPanel = new JPanel(new GridLayout(3, 1));
  newPanel.add(btn1);
  newPanel.add(btn2);
  add(newPanel, BorderLayout.CENTER);
  setTitle("GOBUSES.IN");
   
  
  setSize(400, 200);
   }
   public void actionPerformed(ActionEvent ae)
   {
   if(ae.getSource()==btn1) {
	   Login frame=new Login();
       frame.setVisible(true);
       frame.setSize(700,400);}
   else {
	   
	   Signup frame=new Signup();
       frame.setVisible(true);
       frame.setSize(700,400);
	   
   }
 
 }
  }
