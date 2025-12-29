package worksheet10;

import javax.swing.*;
import java.awt.*;

public class Q3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Example");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.LIGHT_GRAY); // set background color

        JButton saveBtn = new JButton("Save");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(saveBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

