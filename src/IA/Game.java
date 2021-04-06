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
    private GameSquare tempSquare;
    private boolean error = false;

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
                gameSquares[i].defaultText = " ";
            } else if (i == 3 || i == 5 || i == 21 || i == 23) {
                gameSquares[i].setType(GameSquare.types.Star);
                gameSquares[i].setText("X");
                gameSquares[i].defaultText = "X";
            } else if (i == 6 || i == 8) {
                gameSquares[i].setType(GameSquare.types.End);
                gameSquares[i].setText("Finish");
                gameSquares[i].defaultText = "Finish";
            } else if (i == 27) {
                gameSquares[i].setType(GameSquare.types.WhiteStart);
                gameSquares[i].setText("7");
                gameSquares[i].defaultText = "7";
                gameSquares[i].occupied = true;
                gameSquares[i].contains = 7;
                gameSquares[i].team = GameSquare.teams.White;
            } else if (i == 29) {
                gameSquares[i].setType(GameSquare.types.BlackStart);
                gameSquares[i].setText("7");
                gameSquares[i].defaultText = "7";
                gameSquares[i].occupied = true;
                gameSquares[i].contains = 7;
                gameSquares[i].team = GameSquare.teams.Black;
            } else if (i == 28) {
                gameSquares[i].setType(GameSquare.types.Dice);
                gameSquares[i].setText("Click to roll dice");
                gameSquares[i].defaultText = "Click to roll dice";
            } else if (i == 24 || i == 25 || i == 26) {
                gameSquares[i].setBackground(Color.white);
                gameSquares[i].setEnabled(false);
                gameSquares[i].setType(GameSquare.types.Disabled);
                gameSquares[i].defaultText = " ";
            } else if (i == 13) {
                gameSquares[i].setType(GameSquare.types.CenterStar);
                gameSquares[i].setText("X");
                gameSquares[i].defaultText = "X";
            } else {
                gameSquares[i].setType(GameSquare.types.Normal);
                gameSquares[i].setText("O");
                gameSquares[i].defaultText = "O";
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
            if (error){
                tempSquare.setText(tempText);
                error=false;
            }
            GameSquare clicked = (GameSquare) e.getSource();
            /*
            System.out.println("Button Clicked!");
            System.out.println("Turn:" + turn);
            System.out.println("Half Turn: " + turn%1);
            System.out.println("Type: " + clicked.type); */

                //If the dice has been rolled for that turn
                if (turn % 1 == 0) {
                    if (clicked.type == GameSquare.types.Dice) {
                        recentRoll = dice.roll();
                        gameSquares[28].setText(Integer.toString(recentRoll));
                        if (recentRoll == 0){
                            turn+=1;
                            JOptionPane.showMessageDialog(null, "Lose a turn");
                            clicked.updateText();
                        } else {
                            turn += 0.5;
                        }
                    } else {
                        tempText = clicked.getText();
                        tempSquare = clicked;
                        error = true;
                        clicked.setText("Roll the dice first!");
                    }
                } else if (turn % 1 == 0.5) {
                    if ((clicked.type == GameSquare.types.Normal || clicked.type == GameSquare.types.WhiteStart || clicked.type == GameSquare.types.BlackStart)&& clicked.occupied) {
                        gameSquares[28].updateText();
                        //Generating what square to move to
                        temp = clicked.position;
                        for (int i = 0; i < recentRoll; i++) {
                            temp = moveOne(temp, clicked.team);
                        }
                        System.out.println(temp);
                        //Move invalid if square to move on is a star or is of the same team
                        if (gameSquares[temp].type != GameSquare.types.CenterStar && gameSquares[temp].team != clicked.team) {
                            //Kicking out peice if there is already one there
                            if (gameSquares[temp].occupied) {
                                if (gameSquares[temp].team == GameSquare.teams.White) {
                                    gameSquares[27].add(gameSquares[27].team);
                                } else if (gameSquares[temp].team == GameSquare.teams.Black) {
                                    gameSquares[29].add(gameSquares[29].team);
                                }
                                gameSquares[temp].take();
                            }
                            //Adding the peice to the new square
                            gameSquares[temp].setTeam(clicked.team);
                            gameSquares[temp].add(clicked.team);
                            clicked.take();
                            clicked.updateText();

                            if (gameSquares[temp].type != GameSquare.types.CenterStar || gameSquares[temp].type != GameSquare.types.Star){
                                turn+=0.5;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Move");
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
            if (gameSquares[6].contains == 7) {
                JOptionPane.showMessageDialog(null, "White Wins");
                Thread.sleep(5000);
                System.exit(1);
            } else if (gameSquares[8].contains == 7) {
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
