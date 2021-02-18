package ExamS1;

import java.util.Random;

public class TheAlgorithm {
    public static void main(String[] args){
        int[] numbers = new int[4];
        int[] three = new int[4];
        int count = 0;
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            numbers[i] = rand.nextInt(200);
            System.out.println(numbers[i]);
        }
        System.out.println("\n");
        for (int value: numbers) {
            if ((value/100)<10){
                if ((value/10)>10){
                    three[count]=value;
                    System.out.println(value);
                    count++;
                }
            }
        }
    }
}
