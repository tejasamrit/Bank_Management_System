package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JButton next;
    JTextField textName,textFname,textEmail,textadd,textpin,textcity;
    JDateChooser dateChooser;

    Random rand=new Random();
    long first4=(rand.nextLong()%9000L)+1000L;
    String first=" "+Math.abs(first4);



    SignUp(){
        super("Application Form");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,20,100,100);
        add(image);

         JLabel label1=new JLabel("Application Form No."+first);
         label1.setBounds(230,30,600,35);
         label1.setFont(new Font("Rale way",Font.BOLD,32));
         add(label1);

         JLabel label2=new JLabel("Page 1");
         label2.setFont(new Font("Rale way",Font.BOLD,19));
         label2.setBounds(390,65,600,26);
         add(label2);

         JLabel label3=new JLabel("Personal Details");
         label3.setFont(new Font("Rale way",Font.BOLD,19));
         label3.setBounds(345,90,600,28);
         add(label3);

         JLabel labelName=new JLabel("Name:");
        labelName.setFont(new Font("Rale way",Font.BOLD,19));
        labelName.setBounds(100,160,100,28);
        add(labelName);

        textName =new JTextField();
        textName.setFont(new Font("Rale way",Font.BOLD,13));
        textName.setBounds(300,160,320,28);
        add(textName);


        JLabel labelFName=new JLabel("Fathers Name:");
        labelFName.setFont(new Font("Rale way",Font.BOLD,19));
        labelFName.setBounds(100,200,200,28);
        add(labelFName);

        textFname =new JTextField();
        textFname.setFont(new Font("Rale way",Font.BOLD,13));
        textFname.setBounds(300,200,320,28);
        add(textFname);

        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Rale way",Font.BOLD,19));
        dob.setBounds(100,240,200,28);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,240,320,28);
        add(dateChooser);

        JLabel labelG=new JLabel("Gender:");
        labelG.setFont(new Font("Rale way",Font.BOLD,19));
        labelG.setBounds(100,280,100,28);
        add(labelG);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Rale way",Font.BOLD,19));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,280,100,28);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Rale way",Font.BOLD,19));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(440,280,100,28);
        add(r2);

        ButtonGroup btngrp=new ButtonGroup();
        btngrp.add(r1);
        btngrp.add(r2);

        JLabel email=new JLabel("Email ID:");
        email.setFont(new Font("Rale way",Font.BOLD,19));
        email.setBounds(100,320,200,28);
        add(email);

        textEmail =new JTextField();
        textEmail.setFont(new Font("Rale way",Font.BOLD,13));
        textEmail.setBounds(300,320,320,28);
        add(textEmail);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Rale way",Font.BOLD,19));
        address.setBounds(100,360,200,28);
        add(address);

        textadd =new JTextField();
        textadd.setFont(new Font("Rale way",Font.BOLD,13));
        textadd.setBounds(300,360,320,28);
        add(textadd);


        JLabel labelm=new JLabel("Marital Status:");
        labelm.setFont(new Font("Rale way",Font.BOLD,19));
        labelm.setBounds(100,400,170,28);
        add(labelm);

        r3=new JRadioButton("Married");
        r3.setFont(new Font("Rale way",Font.BOLD,19));
        r3.setBackground(new Color(222,255,228));
        r3.setBounds(300,400,130,28);
        add(r3);

        r4=new JRadioButton("Unmarried");
        r4.setFont(new Font("Rale way",Font.BOLD,19));
        r4.setBackground(new Color(222,255,228));
        r4.setBounds(440,400,130,28);
        add(r4);

        ButtonGroup btngrp1=new ButtonGroup();
        btngrp1.add(r3);
        btngrp1.add(r4);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Rale way",Font.BOLD,19));
        city.setBounds(100,440,200,28);
        add(city);

        textcity =new JTextField();
        textcity.setFont(new Font("Rale way",Font.BOLD,13));
        textcity.setBounds(300,440,320,28);
        add(textcity);

        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Rale way",Font.BOLD,19));
        pincode.setBounds(100,480,200,28);
        add(pincode);

        textpin =new JTextField();
        textpin.setFont(new Font("Rale way",Font.BOLD,13));
        textpin.setBounds(300,480,320,28);
        add(textpin);


        next=new JButton("Next");
        next.setFont(new Font("Rale way",Font.BOLD,19));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(390,535,90,30);
        add(next);
        next.addActionListener(this);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,640);
        setLocation(360,40);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=first;
        String name=textName.getText();
        String fname=textFname.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;

        if(r1.isSelected()){
            gender="Male";
        }
        else if(r2.isSelected()){
            gender="Female";
        }

        String email=textEmail.getText();
        String marital=null;
        if(r3.isSelected()){
            marital="Married";
        }
        else if(r4.isSelected()){
            marital="Unmarried";
        }

        String address=textadd.getText();
        String city=textcity.getText();
        String pin=textpin.getText();

        try{
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else{
                Conn con1=new Conn();
                String q="insert into signUp values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"')";
                con1.statement.executeUpdate(q);
                new SignUp2(formno);
                setVisible(false);
            }

        }catch (Exception E1){
            E1.printStackTrace();
        }


    }

    public static void main(String[] args) {

        new SignUp();
    }
}
