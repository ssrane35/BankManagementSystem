/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.event.*;
import java.sql.*;
public class SignupTwo extends JFrame implements ActionListener{
   
JTextField  pan,adhar;
JButton next;
JRadioButton syes,sno,eyes,eno;
JComboBox religion,category,income,education,occupation;

String formno;
     SignupTwo(String formno) {
       this.formno=formno;
         setLayout(null);
         setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
         
         
         JLabel additionalDetails=new JLabel("Page 2 : Additional Details");
         additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
         additionalDetails.setBounds(280,80,400,30);
         add(additionalDetails);
         
         
         
          
         JLabel name=new JLabel("Religion : ");
         name.setFont(new Font("Raleway",Font.BOLD,20));
         name.setBounds(100,140,100,30);
         add(name);
         
         String valReligion[]={"Hindu","Muslim","Shikh","Christan","Other"};
          religion =new JComboBox(valReligion);
         religion.setBounds(300, 140, 400, 30);
         religion .setBackground(Color.WHITE);
         add(religion);
         
 
         
         
         JLabel fname=new JLabel("Category : ");
         fname.setFont(new Font("Raleway",Font.BOLD,20));
         fname.setBounds(100,190,200,30);
         add(fname);
         
         
         String valcategory[]={"General","OBC","SC","ST","Other"};
          category=new JComboBox(valcategory);
         category.setBounds(300, 190, 400, 30);
         category.setBackground(Color.WHITE);
         add(category);
         
        
         
         JLabel dob=new JLabel("Income : ");
         dob.setFont(new Font("Raleway",Font.BOLD,20));
         dob.setBounds(100,240,300,30);
         add(dob);
         
         String incomecategory[]={"NULL","< 1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
         income=new JComboBox(incomecategory);
         income.setBounds(300, 240, 400, 30);
         income.setBackground(Color.WHITE);
         add(income);
       
         
         
         JLabel gender=new JLabel("Educational  ");
         gender.setFont(new Font("Raleway",Font.BOLD,20));
         gender.setBounds(100,290,200,30);
         add(gender);
         
         
         
         
         JLabel mail=new JLabel("Qualification : ");
         mail.setFont(new Font("Raleway",Font.BOLD,20));
         mail.setBounds(100,315,300,30);
         add(mail);
         
         String educationValues[]={"Non-Graduation","Graduate","Post-Gradution","Doctrate","Others"};
        education=new JComboBox(educationValues);
         education.setBounds(300, 315, 400, 30);
         education.setBackground(Color.WHITE);
         add(education);
         
          

         
         
         
         
         
         JLabel marital=new JLabel("Occupation : ");
         marital.setFont(new Font("Raleway",Font.BOLD,20));
         marital.setBounds(100,390,300,30);
         add(marital);
         
         String OccupationValues[]={"Salaried","Self-Employed","Bussienss","Student","Retired","Other"};
         occupation=new JComboBox(OccupationValues);
         occupation.setBounds(300, 390, 400, 30);
         occupation.setBackground(Color.WHITE);
         add(occupation);
         
       
         
         
         JLabel address=new JLabel("PAN Number : ");
         address.setFont(new Font("Raleway",Font.BOLD,20));
         address.setBounds(100,440,300,30);
         add(address);
         
           pan=new JTextField();
         pan.setFont(new Font("Raleway",Font.BOLD,14));
         pan.setBounds(300, 440, 400, 30);
         add(pan);
         
         
         
          JLabel city=new JLabel("Aadhar Number : ");
         city.setFont(new Font("Raleway",Font.BOLD,20));
         city.setBounds(100,490,300,30);
         add(city);
         
          adhar=new JTextField();
         adhar.setFont(new Font("Raleway",Font.BOLD,14));
         adhar.setBounds(300, 490, 400, 30);
         add(adhar);
         
         
         JLabel State=new JLabel("Senior Citizen : ");
         State.setFont(new Font("Raleway",Font.BOLD,20));
         State.setBounds(100,540,300,30);
         add(State);
         
         syes=new JRadioButton("Yes");
         syes.setBounds(300, 540, 100, 30);
         syes.setBackground(Color.WHITE);
         add(syes);
         
           sno=new JRadioButton("No");
         sno.setBounds(450, 540, 100, 30);
         sno.setBackground(Color.WHITE);
         add(sno);
         
         ButtonGroup maritalGroup=new ButtonGroup();
         maritalGroup.add(syes);
         maritalGroup.add(sno);
        
          
         
         JLabel pincode=new JLabel("Existing Account : ");
         pincode.setFont(new Font("Raleway",Font.BOLD,20));
         pincode.setBounds(100,590,300,30);
         add(pincode);
         
         eyes=new JRadioButton("Yes");
         eyes.setBounds(300, 590, 100, 30);
         eyes.setBackground(Color.WHITE);
         add(eyes);
         
           eno=new JRadioButton("No");
         eno.setBounds(450, 590, 100, 30);
         eno.setBackground(Color.WHITE);
         add(eno);
         
         ButtonGroup emaritalGroup=new ButtonGroup();
         emaritalGroup.add(eyes);
         emaritalGroup.add(eno);
          
         
          next=new JButton("Next");
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.setBounds(620, 660, 80, 30);
         next.addActionListener(this);
         add(next);
         
         getContentPane().setBackground(Color.WHITE);
         setSize(850,800);
         setLocation(350,10);
         setVisible(true);
    }

    /**
     *
     * @param ae
     */
     @Override
    public void actionPerformed(ActionEvent ae){
       
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }
        
        String span=pan.getText();
        String sadhar=adhar.getText();
        
        
        try{
            
             Conn c=new Conn();
             String query="insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
              c.s.executeUpdate(query);
              
              //signupthree object
            setVisible(false);
            new signupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    public static void main(String[] args) {
        new SignupTwo("");
    
        
    }
}
        