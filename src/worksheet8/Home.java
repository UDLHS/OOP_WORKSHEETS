package worksheet8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    private JButton btnBack;
    private JFrame previous; // reference to SignUp frame

    public Home(JFrame previous) {
        this.previous = previous;

        // Frame settings
        setTitle("Home");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(20, 20, 80, 25);
        add(btnBack);
        btnBack.addActionListener(this);

        // Label
        JLabel lblHome = new JLabel("Welcome to Home");
        lblHome.setFont(new Font("Arial", Font.BOLD, 18));
        lblHome.setBounds(100, 80, 250, 30);
        add(lblHome);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            previous.setVisible(true); // show SignUp frame again
            dispose();                // close Home
        }
    }
}
