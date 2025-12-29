package worksheet8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener {

    // ===== DB =====
    String url = "jdbc:mysql://localhost:3306/signup?useSSL=false";
    String uname = "root";
    String passwordDB = "mysql@123";

    // ===== SIGN UP =====
    JTextField txtName, txtEmailSU;
    JRadioButton rbMale, rbFemale;
    JComboBox<String> cbDay, cbMonth, cbYear;
    JPasswordField txtPasswordSU;
    JCheckBox chkRobot;
    JButton btnSignUp;

    // ===== SIGN IN =====
    JTextField txtEmailSI;
    JPasswordField txtPasswordSI;
    JButton btnSignIn;

    JLabel lblStatus;

    public SignUp() {

        // Load Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Registration Form");
        setSize(450, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== SIGN UP TITLE =====
        JLabel lblSU = new JLabel("Sign Up");
        lblSU.setFont(new Font("Arial", Font.BOLD, 20));
        lblSU.setForeground(Color.BLUE);
        lblSU.setBounds(170, 10, 200, 30);
        add(lblSU);

        addLabel("Name", 50);
        txtName = addTextField(50);

        addLabel("Email", 90);
        txtEmailSU = addTextField(90);

        addLabel("Gender", 130);
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        rbMale.setBounds(150, 130, 70, 20);
        rbFemale.setBounds(230, 130, 80, 20);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        add(rbMale); add(rbFemale);

        addLabel("Birthday", 170);
        cbDay = new JComboBox<>();
        for (int i = 1; i <= 31; i++) cbDay.addItem("" + i);
        cbDay.setBounds(150, 170, 50, 20);
        add(cbDay);

        cbMonth = new JComboBox<>(new String[]{
                "January","February","March","April","May","June",
                "July","August","September","October","November","December"
        });
        cbMonth.setBounds(210, 170, 90, 20);
        add(cbMonth);

        cbYear = new JComboBox<>();
        for (int i = 1990; i <= 2025; i++) cbYear.addItem("" + i);
        cbYear.setBounds(310, 170, 70, 20);
        add(cbYear);

        addLabel("Password", 210);
        txtPasswordSU = new JPasswordField();
        txtPasswordSU.setBounds(150, 210, 200, 20);
        add(txtPasswordSU);

        chkRobot = new JCheckBox("I am not a robot.");
        chkRobot.setBounds(150, 240, 200, 20);
        add(chkRobot);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(120, 270, 200, 30);
        add(btnSignUp);

        // ===== SIGN IN =====
        JLabel lblSI = new JLabel("Sign In");
        lblSI.setFont(new Font("Arial", Font.BOLD, 20));
        lblSI.setForeground(Color.BLUE);
        lblSI.setBounds(170, 330, 200, 30);
        add(lblSI);

        addLabel("Email", 370);
        txtEmailSI = addTextField(370);

        addLabel("Password", 410);
        txtPasswordSI = new JPasswordField();
        txtPasswordSI.setBounds(150, 410, 200, 20);
        add(txtPasswordSI);

        btnSignIn = new JButton("Sign In");
        btnSignIn.setBounds(120, 450, 200, 30);
        add(btnSignIn);

        lblStatus = new JLabel("");
        lblStatus.setBounds(120, 500, 300, 20);
        lblStatus.setForeground(Color.RED);
        add(lblStatus);

        btnSignUp.addActionListener(this);
        btnSignIn.addActionListener(this);

        setVisible(true);
    }

    private void addLabel(String text, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(50, y, 100, 20);
        add(lbl);
    }

    private JTextField addTextField(int y) {
        JTextField txt = new JTextField();
        txt.setBounds(150, y, 200, 20);
        add(txt);
        return txt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ===== SIGN UP LOGIC =====
        if (e.getSource() == btnSignUp) {

            if (!chkRobot.isSelected()) {
                JOptionPane.showMessageDialog(this, "Verify robot check!");
                return;
            }

            String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : null;
            if (gender == null) {
                JOptionPane.showMessageDialog(this, "Please select gender!");
                return;
            }

            try {
                Connection con = DriverManager.getConnection(url, uname, passwordDB);

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO user(name,email,gender,dob,password) VALUES (?,?,?,?,?)"
                );

                ps.setString(1, txtName.getText());
                ps.setString(2, txtEmailSU.getText());
                ps.setString(3, gender);
                ps.setString(4,
                        cbDay.getSelectedItem() + "-" +
                                cbMonth.getSelectedItem() + "-" +
                                cbYear.getSelectedItem()
                );
                ps.setString(5, new String(txtPasswordSU.getPassword()));

                ps.execute();
                con.close();

                lblStatus.setText("Sign Up Successful!");
                clearSignUpFields();

            } catch (Exception ex) {
                ex.printStackTrace();
                lblStatus.setText("Sign Up Failed!");
            }
        }

        // ===== SIGN IN LOGIC =====
        if (e.getSource() == btnSignIn) {

            try {
                Connection con = DriverManager.getConnection(url, uname, passwordDB);

                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM user WHERE email=? AND password=?"
                );

                ps.setString(1, txtEmailSI.getText());
                ps.setString(2, new String(txtPasswordSI.getPassword()));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    new Home(this);   // pass current SignUp frame
                    setVisible(false);
                } else {
                    lblStatus.setText("Invalid Credentials!");
                }

                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void clearSignUpFields() {
        txtName.setText("");
        txtEmailSU.setText("");
        txtPasswordSU.setText("");
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
        chkRobot.setSelected(false);
        cbDay.setSelectedIndex(0);
        cbMonth.setSelectedIndex(0);
        cbYear.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
