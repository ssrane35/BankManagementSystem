/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author abhijeet
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener{
JTextField  amount;
 JButton   withdrawl,back;
 String pinnumber;
  Withdrawl(String pinnumber){
      this.pinnumber=pinnumber;
      setLayout(null);
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      
      JLabel image=new JLabel(i3);
      image.setBounds(0, 0, 900, 900);
      add(image);
      
      JLabel text=new JLabel("Enter the amount you want to withdraw ");
      text.setBounds(170, 300 ,400, 20);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
      
       amount=new JTextField();
         amount.setFont(new Font("Raleway",Font.BOLD,14));
         amount.setBounds(170, 350, 320, 25);
         add(amount);
      
         
      withdrawl=new JButton("Withdrawl ");
     withdrawl.setFont(new Font("Raleway",Font.BOLD,16));
     withdrawl.setBounds(355, 485, 150, 30);
     withdrawl.setBackground(Color.WHITE);
     withdrawl.addActionListener(this);
     image.add(withdrawl);
             
    back=new JButton("Back ");
     back.setFont(new Font("Raleway",Font.BOLD,16));
     back.setBounds(355, 520, 150, 30);
     back.setBackground(Color.WHITE);
     back.addActionListener(this);
     image.add(back);
             
             
      setSize(900,900);
      setLocation(300, 0);
      setVisible(true);
  }
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==withdrawl){
          String number=amount.getText();
          Date date=new Date();
          if(number.equals("")){
              JOptionPane.showMessageDialog(null,"Please Enter the amount you want to withdrawl");
          }else{
              try{
                  Conn conn=new Conn();
                  String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                  conn.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "Rs "+number+" withdrawl Successfully");
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
                  
              }catch(Exception e){
                  System.out.println(e);
              }
          }
      }else if(ae.getSource()== back){
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
      }
  }
    public static void main(String args[]) {
        new Withdrawl("");
    }
}

