package jdbctrial;

import javax.swing.*;
public class LoginDemo
{
 public static void main(String arg[])
 {
 try
 {
 Login frame=new Login();
 frame.setSize(300,100);
 frame.setVisible(true);
 }
 catch(Exception e)
 {JOptionPane.showMessageDialog(null, e.getMessage());}
 }

}