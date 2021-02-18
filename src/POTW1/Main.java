package POTW1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> passengers = new ArrayList<>();
        passengers.add(123);
        passengers.add(234);
        passengers.add(345);
        passengers.add(456);
        passengers.add(567);
        passengers.add(678);
        passengers.add(789);

        int maxPassengers = 0;
        int maxDay = 0;
        int[] p_array = new int[passengers.size()];
        Iterator iterator = passengers.listIterator();
        int pos = 0;

        while (iterator.hasNext()){
            p_array[pos] = (int) iterator.next();
            pos++;
        }

        int[] avg_p = new int[7];
        for (int i = 0; i < p_array.length; i++) {
            int divisor = p_array.length/7;
            if (p_array.length%7>i){
                divisor++;
            }
            if (divisor>0){
                avg_p[i] /= divisor;
            }
            if (avg_p[i]>maxPassengers) {
                maxPassengers=avg_p[i];
                maxDay = i;

            }
        }
    }
}
