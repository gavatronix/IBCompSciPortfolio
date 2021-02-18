package IA;

import Project3.TicTacToeButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {
    private GameSquare[] gameSquares = new GameSquare[24];
    private GamePeice[] whitePeices = new GamePeice[11];
    private GamePeice[] blackPeices = new GamePeice[11];
    public Game(){
        this.setLayout(new GridLayout(8, 3));
        for (int i = 0; i < gameSquares.length ; i++) {
            if (i == 6 || i == 8 || i == 9 || i==11){
                gameSquares[i].setBackground(Color.white);
                gameSquares[i].setEnabled(false);
                gameSquares[i].setType(GameSquare.types.Disabled);
            } else if (i == 3 || i == 5 || i == 13 || i == 21 || i == 23){
                gameSquares[i].setType(GameSquare.types.Star);
                gameSquares[i].addActionListener(new ButtonListener());
            } else {
                gameSquares[i].setType(GameSquare.types.Normal);
                gameSquares[i].addActionListener(new ButtonListener());
            }
            this.add(gameSquares[i]);
        }

    }
}
