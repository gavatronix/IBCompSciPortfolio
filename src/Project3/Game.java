package Project3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {
    private TicTacToeButton[] buttons = new TicTacToeButton[9];
    private boolean turn1 = true;
    private String[] board = new String[9];
    private String name;

    public Game() {
        this.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new TicTacToeButton();
            buttons[i].position = i;
            if (i < 3) {
                buttons[i].setBackground(new Color(37, 45, 41));
            } else if (i < 6) {
                buttons[i].setBackground(new Color(43, 107, 64));
            } else {
                buttons[i].setBackground(new Color(237, 237, 237));
            }
            buttons[i].addActionListener(new buttonListener());
            this.add(buttons[i]);
        }
    }

    private void check(TicTacToeButton button) {
        //Checks if a corner was hit to add the diagonal check
        if (button.position == 0 || button.position == 2 || button.position == 4 || button.position == 6 || button.position == 8){
            //Left and Right diagonal checks
            if (buttons[0].team == buttons[4].team && buttons[4].team == buttons[8].team){
                if (buttons[0].team != null && buttons[4].team != null && buttons[8].team != null){
                    win();
                }
            } else if (buttons[2].team == buttons[4].team && buttons[4].team == buttons[6].team){
                if (buttons[2].team != null && buttons[4].team != null && buttons[6].team != null){
                    win();
                }
            }
        }
        //Vertical Checks
        for (int i = 0; i < 3; i++) {
            if (buttons[i].team == buttons[i+3].team && buttons[i].team == buttons[i+6].team){
                if (buttons[i].team != null && buttons[i+1].team != null && buttons[i+2].team != null){
                    win();
                }
            }
        }
        //Horizontal Checks
        for (int i = 0; i < 3; i+=3) {
            if (buttons[i].team == buttons[i+1].team && buttons[i].team == buttons[i+2].team){
                if (buttons[i].team != null && buttons[i+1].team != null && buttons[i+2].team != null){
                    win();
                }
            }
        }
    }
    private void win(){
        for (int i = 0; i < 100; i++) {
            System.out.println("*.*.*");
            System.out.println("PLAYER "+name+" WINS");
            System.out.println("*.*.*");
        }
        removeAll();
        repaint();
    }
    private class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            TicTacToeButton buttonClicked = (TicTacToeButton) e.getSource();
            buttonClicked.setEnabled(false);
            if (turn1) {
                buttonClicked.setText("X");
                buttonClicked.team = TicTacToeButton.teams.X;
                check(buttonClicked);
                turn1 = false;
                name = "2";
            } else {
                buttonClicked.setText("O");
                buttonClicked.team = TicTacToeButton.teams.O;
                check(buttonClicked);
                turn1 = true;
                name = "1";
            }

        }
    }
}
