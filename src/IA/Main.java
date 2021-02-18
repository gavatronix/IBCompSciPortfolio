package IA;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Dice dice = new Dice();
        JFrame window = new JFrame("The Royal Game of UR");
        window.setBounds(0,0,400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game game = new Game();
        window.getContentPane().add(game);
        window.setVisible(true);
    }
}
