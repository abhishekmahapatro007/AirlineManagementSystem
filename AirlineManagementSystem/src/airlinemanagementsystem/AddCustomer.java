
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfphone,tfaadhar,tfnationality,tfaddress;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220,20,500,35);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("Tahoma",Font.BOLD, 32));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,80,150,25);
//        lblname.setForeground(Color.white);
        lblname.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220,80,200,25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,130,150,25);
        lblnationality.setForeground(Color.black);
        lblnationality.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220,130,200,25);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60,180,150,25);
        lblaadhar.setForeground(Color.black);
        lblaadhar.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lblaadhar);
        
        tfaadhar= new JTextField();
        tfaadhar.setBounds(220,180,200,25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setForeground(Color.black);
        lbladdress.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,230,200,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setForeground(Color.black);
        lblgender.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setForeground(Color.black);
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setForeground(Color.black);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60,330,150,25);
        lblphone.setForeground(Color.black);
        lblphone.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,200,25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setBounds(220,400,150,30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450,80,280,400);
        add(lblimage);
                
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        
        if(rbmale.isSelected()){
            gender = "Male";
        }
        else{
            gender = "Female";
        }
        try{
            Conn conn = new Conn();
            
            String query  = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
        
            setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
