package worksheet10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Q1 {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("Student Data");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Table data
        String[] columnNames = {"Name", "ID", "Marks"};
        Object[][] data = {
                {"Amal", "CS/2022/020", 85},
                {"Nimali", "ET/2022/014", 77},
                {"Kamal", "CT/2022/011", 92}
        };

        // JTable (non-editable)
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // makes table non-editable
            }
        };
        JTable table = new JTable(model);

        // Place table in JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add to frame
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

