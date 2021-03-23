package POTW1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A {
    public static void main(String[] args){
        int[] Data = new int[7];
        Data[0] = 2;Data[1] = 4;Data[2] = 1;Data[3] = -2;Data[4] = -4;Data[5] = 1;Data[6] = 0;
        int[] Array = new int[4];

       int counter = 0;
       int sum = 0;


        for (int x = 0; x < 7; x++) {
            if (Data[x] > 0){
                Array[counter] = Data[x];
                counter++;
                sum += Array[counter];
            }
        }
        System.out.println(sum/counter);
    }
}
