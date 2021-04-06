package IA;

import javax.swing.*;

public class GameSquare extends JButton {
    public enum  types{Normal,Star, Disabled, End, WhiteStart,BlackStart,Dice, CenterStar}
    public enum  teams{White,Black,Empty}
    public types type;
    public teams team;
    public boolean occupied;
    public int contains;
    public  int position;
    public String defaultText;

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    public void take(){
        contains-=1;
        this.setText(Integer.toString(contains));
        if (contains == 0){
            occupied = false;
            this.team = teams.Empty;
        }
    }
    public void add(teams team){
        contains+=1;
        occupied = true;
        this.team = team;
        if (type != types.WhiteStart && type != types.BlackStart && type != types.End){
            this.setText(team.toString());
        } else {
            this.setText(Integer.toString(contains));
        }
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

    public void updateText(){
        if (!occupied){
            this.setText(defaultText);
        } else if (this.type == types.WhiteStart || this.type == types.BlackStart){
            this.setText(Integer.toString(contains));
            defaultText = Integer.toString(contains);
        } else {
            this.setText(team.toString());
        }
    }
}
