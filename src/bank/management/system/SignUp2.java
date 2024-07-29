package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener {
    JComboBox comboBox,comboBox2,comboBox3,comboBox4;
    JButton next;
    JTextField textField,textadhar;
    JRadioButton r1,r2;
    String formno;
    SignUp2(String formno){
        super("Application Form");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(190,15,100,100);
        add(image);

        this.formno=formno;
        JLabel l1=new JLabel("Page 2");
        l1.setFont(new Font("Rale way",Font.BOLD,19));
        l1.setBounds(340,30,100,40);
        add(l1);
        JLabel l2=new JLabel("Additional Details");
        l2.setFont(new Font("Rale way",Font.BOLD,19));
        l2.setBounds(340,60,200,40);
        add(l2);

        JLabel l3=new JLabel("Religion:");
        l3.setFont(new Font("Rale way",Font.BOLD,19));
        l3.setBounds(150,140,200,40);
        add(l3);

        String religion[]={"Hindu","Muslim","Christian","Sikh","Other"};
        comboBox=new JComboBox(religion);
        comboBox.setBackground(new Color(252,208,75));
        comboBox.setFont(new Font("Rale way",Font.BOLD,18));
        comboBox.setBounds(350,142,200,30);
        add(comboBox);


        JLabel l4=new JLabel("Category:");
        l4.setFont(new Font("Rale way",Font.BOLD,19));
        l4.setBounds(150,190,200,40);
        add(l4);

        String category[]={"Open","OBC","SC","ST","Other"};
        comboBox2=new JComboBox(category);
        comboBox2.setBackground(new Color(252,208,75));
        comboBox2.setFont(new Font("Rale way",Font.BOLD,18));
        comboBox2.setBounds(350,192,200,30);
        add(comboBox2);


        JLabel l5=new JLabel("Income:");
        l5.setFont(new Font("Rale way",Font.BOLD,19));
        l5.setBounds(150,240,200,40);
        add(l5);

        String income[]={"Null","<1.5lakh","<2.5lakh","<5lakh","<10lakh"};
        comboBox3=new JComboBox(income);
        comboBox3.setBackground(new Color(252,208,75));
        comboBox3.setFont(new Font("Rale way",Font.BOLD,18));
        comboBox3.setBounds(350,242,200,30);
        add(comboBox3);

        JLabel l6=new JLabel("education:");
        l6.setFont(new Font("Rale way",Font.BOLD,19));
        l6.setBounds(150,290,200,40);
        add(l6);

        String education[]={"Non-Graduate","Graduate","Post-Graduate","Others"};
        comboBox4=new JComboBox(education);
        comboBox4.setBackground(new Color(252,208,75));
        comboBox4.setFont(new Font("Rale way",Font.BOLD,18));
        comboBox4.setBounds(350,292,200,30);
        add(comboBox4);

        JLabel l7=new JLabel("Pan No.:");
        l7.setFont(new Font("Rale way",Font.BOLD,19));
        l7.setBounds(150,340,200,40);
        add(l7);

        textField=new JTextField();
        textField.setFont(new Font("Rale way",Font.BOLD,19));
        textField.setBounds(350,342,200,30);
        add(textField);

        JLabel l8=new JLabel("Aadhar No.:");
        l8.setFont(new Font("Rale way",Font.BOLD,19));
        l8.setBounds(150,390,200,40);
        add(l8);

        textadhar=new JTextField();
        textadhar.setFont(new Font("Rale way",Font.BOLD,19));
        textadhar.setBounds(350,392,200,30);
        add(textadhar);


        JLabel l9=new JLabel("Existing Account:");
        l9.setFont(new Font("Rale way",Font.BOLD,19));
        l9.setBounds(150,440,200,40);
        add(l9);

        r1=new JRadioButton("Yes");
        r1.setBackground(new Color(252,208,75));
        r1.setFont(new Font("Rale way",Font.BOLD,18));
        r1.setBounds(350,442,80,30);
        add(r1);

        r2=new JRadioButton("No");
        r2.setBackground(new Color(252,208,75));
        r2.setFont(new Font("Rale way",Font.BOLD,18));
        r2.setBounds(460,442,80,30);
        add(r2);

        ButtonGroup btngrp=new ButtonGroup();
        btngrp.add(r1);
        btngrp.add(r2);

        JLabel l11=new JLabel("Form No.:");
        l11.setFont(new Font("Rale way",Font.BOLD,19));
        l11.setBounds(600,10,100,40);
        add(l11);

        JLabel l12=new JLabel(formno);
        l12.setFont(new Font("Rale way",Font.BOLD,15));
        l12.setBounds(700,10,100,40);
        add(l12);

        next=new JButton("Next");
        next.setFont(new Font("Rale way",Font.BOLD,19));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(390,525,98,38);
        add(next);
        next.addActionListener(this);




        setLayout(null);
        setSize(800,650);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,75));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel=(String)comboBox.getSelectedItem();
        String cat=(String)comboBox2.getSelectedItem();
        String inc=(String)comboBox3.getSelectedItem();
        String edu=(String)comboBox4.getSelectedItem();
        String pan=textField.getText();
        String adhar=textadhar.getText();
        String exit=null;
        if(r1.isSelected()){
            exit="yes";
        }
        else if(r2.isSelected()){
            exit="NO";
        }

        try{
            if(textField.getText().equals("")|| textadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill out all the fields.");
            }
            else{
                Conn c1=new Conn();
                String q="insert into signup2 values ('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+pan+"','"+adhar+"','"+exit+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new SignUp2("");
    }
}
