package IA;

import javax.swing.*;

public class GameSquare extends JButton {
    public enum  types{Normal,Star, Disabled, End, WhiteStart,BlackStart,Dice}
    public enum  teams{White,Black,Empty}
    public types type;
    public teams team;
    public boolean occupied;
    public int contains;
    public  int position;

    public void take(){
        contains-=1;
        this.setText(Integer.toString(contains));
    }
    public void add(){
        contains+=1;
        this.setText(Integer.toString(contains));
    }

    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }

    public void setType(types type) {
        this.type = type;
    }

    public teams getTeam() { return team; }
    public void setTeam(teams team) {
        this.team = team;
        if (team == teams.White){
            this.setText("W");
        } else if (team == teams.Black){
            this.setText("B");
        }
    }
}
