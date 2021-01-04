package FlowChartHW;

import java.util.Random;

public class FlowChart {
    public static void main(String[] args){
        Random rand = new Random();
        int[] values = new int[5];
        for (int i = 0; i < 5; i++) {
            values[i] = rand.nextInt(10);
        }
        System.out.printf("Before \n");
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        int limit = 4;
        int temporary;
        boolean flag = true;
        while (flag){
            flag = false;
            int counter = 0;
            while (counter < (limit)){
                if (values[counter]>values[counter+1]){
                    temporary = values[counter];
                    values[counter] = values[counter+1];
                    values[counter+1] = temporary;
                    flag = true;
                }
                counter++;
            }
        }
        System.out.println("After");
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}
