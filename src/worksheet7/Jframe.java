package worksheet7;

import javax.swing.*;

public class Jframe {

    public static void main(String[] args){
        JFrame jframe;
        jframe = new JFrame();
        jframe.setSize(800, 600);
        jframe.setVisible(true);

        String str = JOptionPane.showInputDialog(null, "Enter age:");
        int age = Integer.parseInt(str);
    }

}
