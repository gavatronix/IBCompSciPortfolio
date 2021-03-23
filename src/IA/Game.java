package IA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {
    private GameSquare[] gameSquares = new GameSquare[30];
    private Dice dice = new Dice();
    private boolean winWhite = false;
    private boolean winBlack = false;
    private int recentRoll;
    private double turn = 0;
    private String winner;
    private int temp;
    private String tempText;

    public Game() throws InterruptedException {

        //Initialization
        this.setLayout(new GridLayout(10, 3));
        for (int i = 0; i < gameSquares.length; i++) {
            gameSquares[i] = new GameSquare();
            gameSquares[i].addActionListener(new clickListener());
            gameSquares[i].setPosition(i);
            if (i == 9 || i == 11) {
                gameSquares[i].setBackground(Color.white);
                gameSquares[i].setEnabled(false);
                gameSquares[i].setType(GameSquare.types.Disabled);
            } else if (i == 3 || i == 5 || i == 13 || i == 21 || i == 23) {
                gameSquares[i].setType(GameSquare.types.Star);
                gameSquares[i].setText("X");
            } else if (i == 6 || i == 8) {
                gameSquares[i].setType(GameSquare.types.End);
                gameSquares[i].setText("Finish");
            } else if (i == 27) {
                gameSquares[i].setType(GameSquare.types.WhiteStart);
                gameSquares[i].setText("11");
            } else if (i == 29) {
                gameSquares[i].setType(GameSquare.types.BlackStart);
                gameSquares[i].setText("11");
            } else if (i == 28) {
                gameSquares[i].setType(GameSquare.types.Dice);
                gameSquares[i].setText("Click to roll dice");
            } else if (i == 24 || i == 25 || i == 26) {
                gameSquares[i].setBackground(Color.white);
                gameSquares[i].setEnabled(false);
                gameSquares[i].setType(GameSquare.types.Disabled);
            } else {
                gameSquares[i].setType(GameSquare.types.Normal);
                gameSquares[i].setText("O");
            }
            this.add(gameSquares[i]);
        }
        System.out.println("Init Complete");
    }

    public int moveOne(int square, GameSquare.teams team) {
        //All White specific moves
        if (team == GameSquare.teams.White) {
            if (square == 27) {
                return 12;
            } else if (square == 12) {
                return 15;
            } else if (square == 15) {
                return 18;
            } else if (square == 18) {
                return 21;
            } else if (square == 21) {
                return 22;
            } else if (square == 1) {
                return 0;
            } else if (square == 0) {
                return 3;
            } else if (square == 3) {
                return 6;
            }
            // All Black specific moves
        } else if (team == GameSquare.teams.Black) {
            if (square == 29) {
                return 14;
            } else if (square == 14) {
                return 17;
            } else if (square == 17) {
                return 20;
            } else if (square == 20) {
                return 23;
            } else if (square == 23) {
                return 22;
            } else if (square == 1) {
                return 2;
            } else if (square == 2) {
                return 5;
            } else if (square == 5) {
                return 8;
            }
        }
        //General moves
        return square-3;
    }

    //Button listener and check for legal move
    private class clickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button Clicked!");
            System.out.println("Turn:" + turn);
            GameSquare clicked = (GameSquare) e.getSource();
            System.out.println("Type: " + clicked.type);
            System.out.println(turn%1);
            //If clicked square has a peice and the peice is of the players turn
            if (clicked.occupied && clicked.team == turnCheck() || clicked.type == GameSquare.types.Dice){
                //If the dice has been rolled for that turn
                if (turn % 0.5 == 0) {
                    if (clicked.type == GameSquare.types.Dice) {
                        recentRoll = dice.roll();
                        System.out.println(recentRoll);
                        gameSquares[28].setText(Integer.toString(recentRoll));
                        turn += 0.5;
                    } else {
                        tempText = clicked.getText();
                        clicked.setText("Move a peice first!");
                    }
                } else if (turn % 1 == 0.5) {
                    if (clicked.getText() == "Move a peice first!"){
                        clicked.setText(tempText);
                    }
                    if (clicked.type == GameSquare.types.Normal) {
                        clicked.occupied = false;
                        gameSquares[28].setText("Click to roll");

                        //Generating what square to move to
                        temp = moveOne(clicked.getPosition(), clicked.team);
                        for (int i = 0; i < recentRoll - 1; i++) {
                            temp = moveOne(temp, clicked.team);
                        }
                        //Move invalid if square to move on is a star
                        if (gameSquares[temp].type != GameSquare.types.Star) {
                            //Kicking out peice if there is already one there
                            if (gameSquares[temp].team == GameSquare.teams.White) {
                                gameSquares[27].add();
                            } else if (gameSquares[temp].team == GameSquare.teams.Black) {
                                gameSquares[29].add();
                            }
                            //Adding the peice to the new square
                            gameSquares[temp].setTeam(clicked.team);
                            clicked.setTeam(GameSquare.teams.Empty);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Move");
                        }
                    }
                }
            }
            try {
                winCheck();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        private void winCheck() throws InterruptedException {
            if (gameSquares[6].contains == 11) {
                JOptionPane.showMessageDialog(null, "White Wins");
                Thread.sleep(5000);
                System.exit(1);
            } else if (gameSquares[8].contains == 11) {
                JOptionPane.showMessageDialog(null, "Black Wins");
                Thread.sleep(5000);
                System.exit(1);
            }
        }
        private GameSquare.teams turnCheck(){
            if (turn%2 == 1){
                return GameSquare.teams.Black;
            } else {
                return GameSquare.teams.White;
            }
        }
    }
}
