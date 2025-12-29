package worksheet7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationForm extends JFrame implements ActionListener {

    // Components
    private JTextField txtName, txtMobile;
    private JRadioButton rbMale, rbFemale;
    private JComboBox<String> cbDay, cbMonth, cbYear;
    private JTextArea txtAddress, txtOutput;
    private JCheckBox chkTerms;
    private JButton btnSubmit, btnReset;
    private JLabel lblStatus;

    // ===== Database variables (PDF Step 4) =====
    String url = "jdbc:mysql://localhost:3306/registration?useSSL=false";
    String uname = "root";
    String password = "mysql@123";

    public RegistrationForm() {

        // ===== Load MySQL JDBC Driver =====
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Frame settings
        setTitle("Registration Form");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title
        JLabel lblTitle = new JLabel("Registration Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(270, 10, 250, 30);
        add(lblTitle);

        // Name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 60, 100, 20);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(150, 60, 150, 20);
        add(txtName);

        // Mobile
        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(50, 90, 100, 20);
        add(lblMobile);

        txtMobile = new JTextField();
        txtMobile.setBounds(150, 90, 150, 20);
        add(txtMobile);

        // Gender
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(50, 120, 100, 20);
        add(lblGender);

        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        rbMale.setBounds(150, 120, 70, 20);
        rbFemale.setBounds(230, 120, 80, 20);

        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbMale);
        bgGender.add(rbFemale);

        add(rbMale);
        add(rbFemale);

        // DOB
        JLabel lblDOB = new JLabel("DOB");
        lblDOB.setBounds(50, 150, 100, 20);
        add(lblDOB);

        cbDay = new JComboBox<>();
        for (int i = 1; i <= 31; i++)
            cbDay.addItem(String.valueOf(i));
        cbDay.setBounds(150, 150, 50, 20);
        add(cbDay);

        cbMonth = new JComboBox<>(new String[]{
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        });
        cbMonth.setBounds(210, 150, 60, 20);
        add(cbMonth);

        cbYear = new JComboBox<>();
        for (int i = 1990; i <= 2025; i++)
            cbYear.addItem(String.valueOf(i));
        cbYear.setBounds(280, 150, 70, 20);
        add(cbYear);

        // Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(50, 180, 100, 20);
        add(lblAddress);

        txtAddress = new JTextArea();
        JScrollPane spAddress = new JScrollPane(txtAddress);
        spAddress.setBounds(150, 180, 200, 60);
        add(spAddress);

        // Terms
        chkTerms = new JCheckBox("Accept Terms And Conditions.");
        chkTerms.setBounds(150, 250, 250, 20);
        add(chkTerms);

        // Buttons
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnSubmit.setBounds(150, 280, 80, 25);
        btnReset.setBounds(250, 280, 80, 25);

        add(btnSubmit);
        add(btnReset);

        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);

        // Output area
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane spOutput = new JScrollPane(txtOutput);
        spOutput.setBounds(400, 60, 300, 200);
        add(spOutput);

        // Status label
        lblStatus = new JLabel("");
        lblStatus.setBounds(150, 320, 300, 20);
        lblStatus.setForeground(Color.BLUE);
        add(lblStatus);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ===== SUBMIT BUTTON =====
        if (e.getSource() == btnSubmit) {

            if (!chkTerms.isSelected()) {
                JOptionPane.showMessageDialog(this,
                        "Please accept Terms and Conditions");
                return;
            }

            // Read form values
            String nameq = txtName.getText();
            int mobileq = Integer.parseInt(txtMobile.getText());
            String genderq = rbMale.isSelected() ? "Male" : "Female";
            String dobq = cbDay.getSelectedItem() + "-" +
                    cbMonth.getSelectedItem() + "-" +
                    cbYear.getSelectedItem();
            String addressq = txtAddress.getText();

            // Display output
            txtOutput.setText(
                    "Name : " + nameq + "\n" +
                            "Mobile : " + mobileq + "\n" +
                            "Gender : " + genderq + "\n" +
                            "DOB : " + dobq + "\n" +
                            "Address : " + addressq
            );

            // ===== Database INSERT (PDF Step 7) =====
            try {
                Connection connection =
                        DriverManager.getConnection(url, uname, password);

                PreparedStatement preparedStmt =
                        connection.prepareStatement(
                                "INSERT INTO user (Name, Mobile, Gender, DOB, Address) VALUES (?, ?, ?, ?, ?)"
                        );

                preparedStmt.setString(1, nameq);
                preparedStmt.setInt(2, mobileq);
                preparedStmt.setString(3, genderq);
                preparedStmt.setString(4, dobq);
                preparedStmt.setString(5, addressq);

                preparedStmt.execute();
                connection.close();

                lblStatus.setText("Registration Successfully..");

            } catch (SQLException exception) {
                exception.printStackTrace();
                lblStatus.setText("Database Error!");
            }
        }

        // ===== RESET BUTTON =====
        if (e.getSource() == btnReset) {
            txtName.setText("");
            txtMobile.setText("");
            txtAddress.setText("");
            txtOutput.setText("");
            chkTerms.setSelected(false);
            lblStatus.setText("");
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
