package IA;

import Project3.TicTacToeButton;

public class GamePeice {
    public int position;
    public enum  teams{White,Black}
    public teams team;

    public void setPosition(int position) {
        this.position = position;
    }

    public void setTeam(teams team) {
        this.team = team;
    }
}
