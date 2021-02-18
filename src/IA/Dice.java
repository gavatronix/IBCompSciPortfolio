package IA;
import java.util.Random;
import java.util.Random.*;

public class Dice {
    Random rand = new Random();
    int diceVal;
    public int roll(){
        diceVal=0;
        for (int i = 0; i < 4; i++) {
            diceVal+= rand.nextInt(2);
        }
        return diceVal;
    }
}
