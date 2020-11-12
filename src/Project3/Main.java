package Project3;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame("TicTacToe");
        window.setBounds(0,0,400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Game());
        window.setVisible(true);
    }
}
