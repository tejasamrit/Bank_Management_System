package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame  implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Deposit(String pin){
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel l1=new JLabel("Enter amount to Deposit :");
        l1.setFont(new Font("System",Font.BOLD,19));
        l1.setBounds(460,180,400,35);
        l1.setForeground(Color.white);
        l3.add(l1);

        textField=new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setBounds(460,230,250,32);
        textField.setForeground(Color.white);
        textField.setFont(new Font("Rale way",Font.BOLD,22));
        l3.add(textField);

        b1=new JButton("Deposit");
        b1.setBounds(680,360,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setFont(new Font("Rale way",Font.BOLD,22));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);
//

        b2=new JButton("Back");
        b2.setBounds(680,400,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setFont(new Font("Rale way",Font.BOLD,22));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"plz,enter the deposit amount.");
                }
                else{
                    Conn c=new Conn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited successfully.");
                    setVisible(false);
                    new main_Class(pin);
                }
            }
            else if(e.getSource()==b2){
                setVisible(false);
                new main_Class(pin);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
