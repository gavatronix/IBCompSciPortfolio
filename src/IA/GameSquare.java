package IA;

import javax.swing.*;

public class GameSquare extends JButton {
    public enum  types{Normal,Star, Disabled}
    public types type;

    public void setType(types type) {
        this.type = type;
    }
}
