package IA;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame window = new JFrame("The Royal Game of UR");
        window.setBounds(0,0,400,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Game());
        window.setVisible(true);
    }
}
