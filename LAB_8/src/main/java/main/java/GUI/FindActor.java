package main.java.GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import main.java.Main;

public class FindActor extends JFrame implements ActionListener {
    JLabel lb, lb1, lb2, lb5;
    JTextField tf1, tf2, tf5;
    JButton btn;
    JButton deleteActor;

    public FindActor() {
        super("Fetching Actor's Information");
        lb5 = new JLabel("Enter Name:");
        lb5.setBounds(20, 20, 100, 30);
        tf5 = new JTextField(20);
        tf5.setBounds(130, 20, 200, 30);
        btn = new JButton("Submit");
        btn.setBounds(20, 50, 100, 30);
        btn.addActionListener(this);
        deleteActor = new JButton("Delete");
        deleteActor.setBounds(130, 50, 100, 30);
        deleteActor.addActionListener(e -> {
            try {
                String str = tf5.getText();
                Connection con = Main.getConnection();
                PreparedStatement st = con.prepareStatement("delete from MOVIE_CAST where lower(trim(MOVIEACTOR))=lower(trim(?))");
                st.setString(1, str);
                st.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        lb = new JLabel("Fetching Actor's Information From Database");
        lb.setBounds(30, 80, 450, 30);
        lb.setForeground(Color.black);
        lb.setFont(new Font("Serif", Font.BOLD, 20));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        lb1 = new JLabel("ID:");
        lb1.setBounds(20, 130, 100, 30);
        tf1 = new JTextField(50);
        tf1.setBounds(130, 130, 200, 30);
        lb2 = new JLabel("Name:");
        lb2.setBounds(20, 180, 100, 30);
        tf2 = new JTextField(100);
        tf2.setBounds(130, 180, 200, 30);
        setLayout(null);
        //Add components to the JFrame
        add(lb5);
        add(tf5);
        add(btn);
        add(lb);
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(deleteActor);

        tf1.setEditable(false);
        tf2.setEditable(false);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            String str = tf5.getText();
            Connection con = Main.getConnection();
            PreparedStatement st = con.prepareStatement("select * from MOVIE_CAST where lower(trim(MOVIEACTOR))=lower(trim(?))");
            st.setString(1, str);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                tf1.setText(String.valueOf(id));
                tf2.setText(name);
            } else {
                JOptionPane.showMessageDialog(null, "Name not Found");
            }
            //Create Exception Handler
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //Running Constructor
    public static void main(String[] args) {
        new FindActor();
    }
}