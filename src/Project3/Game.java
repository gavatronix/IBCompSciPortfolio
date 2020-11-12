package Project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {
    private JButton[] buttons = new JButton[9];
    private boolean turn1 = true;
    private String[] board = new String[9];
    public Game(){
        this.setLayout(new GridLayout(3,3));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Hello There");
            /*if (i<3){
                buttons[i].setBackground(new Color(37, 45, 41));
            } else if (i<6){
                buttons[i].setBackground(new Color(43, 107, 64));
            } else {
                buttons[i].setBackground(new Color(237,237,237));
            }*/
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton buttonclicked = (JButton) e.getSource();
                    if (turn1){
                        buttonclicked.setText("X");
                        turn1 = false;
                    } else {
                        buttonclicked.setText("O");
                        turn1 = true;
                    }
                }
            });
            this.add(buttons[i]);
        }
    }
    /*private boolean check() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[2].getText() = board[i];
        }
        if(turn1){

        }else {
            return false;
        }*/
}
