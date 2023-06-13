/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author abhijeet
 */
public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardJTextField;
    JPasswordField pinJTextField;
Login(){
    setTitle("Machine Testing");
    setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        
        JLabel label=new JLabel(i3);
        label.setBounds(125, 10, 100, 100);
        add(label);
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osword",Font.BOLD,38));
        text.setBounds(250, 40, 400, 40);
        
        add(text);
        
          JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Railway",Font.BOLD,28));
        card.setBounds(120, 150, 400, 40);
        
        add(card);
        cardJTextField = new JTextField();
        cardJTextField.setBounds(300, 150, 230, 30);
        add(cardJTextField);
        
        
          JLabel pin=new JLabel("Pin No:");
        pin.setFont(new Font("Railway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 20);
        add(pin);
        
      pinJTextField=new JPasswordField();
        pinJTextField.setBounds(300, 220, 230, 30);
        add(pinJTextField);
        
         login=new JButton("SIGN UP");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
          clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
          signup=new JButton("SIGN UP");
         signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(300, 250);
  
}public static void main(String[] args) {
        new Login();
    }

    
    public void actionPerformed(ActionEvent ae) {
        
         if(ae.getSource() == clear){
        cardJTextField.setText("");
        pinJTextField.setText("");
    
}else if(ae.getSource()==login)
{
    Conn conn =new Conn();
    String cardnumber=cardJTextField.getText();
    String pinnumber=pinJTextField.getText();
    String query="select * from login where cardnumber= '"+cardnumber+"' and pin='"+pinnumber+"'";
    try{
        ResultSet rs=conn.s.executeQuery(query);
        if(rs.next()){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin Number");
        }             
    } catch(Exception e){
        System.out.println(e);
    }
    
}else if(ae.getSource()==signup){
             setVisible(false);
             new SignupOne().setVisible(true);
}   
    }

   
}




