package jdbctrial;

import javax.swing.JOptionPane;

public class Home {
	public static void main(String args[])
	 {
	 try
	 {
	 NextPage frame=new NextPage();
	 
	 frame.setSize(700,400);
	 frame.setVisible(true);
	 }
	 catch(Exception e)
	 {JOptionPane.showMessageDialog(null, e.getMessage());}
	 }

	}


