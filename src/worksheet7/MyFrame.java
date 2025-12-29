package worksheet7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class MyFrame extends JFrame implements ActionListener{
//
//    private static final int FRAME_WIDTH = 800;
//    private static final int FRAME_HEIGHT = 600;
//    private static final int FRAME_X_ORIGIN = 150;
//    private static final int FRAME_Y_ORIGIN = 150;

//    private final JButton cancelButton;
//    private final JButton okButton;


//    public MyFrame(){
//
//        Container contentPane = getContentPane();
//
//        setSize(FRAME_WIDTH, FRAME_HEIGHT);
//        setResizable(false);
//
//        setTitle("Program JButtonFrame");
//        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
////        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        contentPane.setLayout(new FlowLayout());
//
//        okButton = new JButton("OK");
//        contentPane.add(okButton);
//        cancelButton = new JButton("CANCEL");
//        contentPane.add(cancelButton);
//
//        cancelButton.addActionListener(this);
//        okButton.addActionListener(this);
//
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent event) {
//        JButton clickedButton = (JButton) event.getSource();
//        String buttonText = clickedButton.getText();
//        setTitle(buttonText);
//        System.out.println(buttonText);
//    }

//}


public class MyFrame extends JFrame{

    MyFrame() {
        getContentPane().setLayout(null);
        setTitle("Name and Address");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JLabel

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setSize(300, 30);
        nameLabel.setLocation(50, 20);
        add(nameLabel);

        // JTextField

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameTextField.setSize(300, 30);
        nameTextField.setLocation(200, 20);
        add(nameTextField);

        // JTextArea

        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        addressLabel.setSize(300, 30);
        addressLabel.setLocation(50, 70);
        add(addressLabel);

        JTextArea resultsText = new JTextArea();
        resultsText.setFont(new Font("Arial", Font.PLAIN, 15));
        resultsText.setSize(300, 100);
        resultsText.setLocation(200, 70);
        resultsText.setLineWrap(true);
        add(resultsText);


        // JButton

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(250, 325);
        add(submitButton);

        // JPasswordField

        JLabel pwLabel = new JLabel("Password: ");
        pwLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        pwLabel.setSize(300, 30);
        pwLabel.setLocation(50, 260);
        add(pwLabel);

        JPasswordField pwTextField = new JPasswordField();
        pwTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        pwTextField.setSize(300, 30);
        pwTextField.setLocation(200, 260);
        pwTextField.setEchoChar('*');
        add(pwTextField);


        // Image Icon

        JLabel logoLabel = new JLabel("");
//        logoLabel.setSize(50, 50);
        logoLabel.setBounds(10, 10, 512, 512);
        ImageIcon img = new
        ImageIcon(this.getClass().getResource("java.png"));
        logoLabel.setIcon(new ImageIcon(img.getImage()));
        add(logoLabel);





    }

}
