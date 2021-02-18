package POTW1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BC {
    public static void main(String[] args) {
        //B
        List<Integer> passengers = Arrays.asList(203, 213, 504, 230, 111, 20, 305, 710, 210, 310, 999);
        Iterator<Integer> iterator = passengers.listIterator();
        ArrayList<Integer> P_Array = new ArrayList<>();
        while (iterator.hasNext()) {
            P_Array.add(iterator.next());
        }

        //C
        int[] sumsOfDays = new int[7];
        int[] numberOfDataPerDay = new int[7];
        int[] averagePerDay = new int[7];
        int highestAvgDay = 0;

        for (int i = 0; i < P_Array.size(); i++) {
            sumsOfDays[i % 7] = P_Array.get(i);
            numberOfDataPerDay[i % 7] += 1;
        }
        for (int i = 0; i < 7; i++) {
            averagePerDay[i] = sumsOfDays[i] / numberOfDataPerDay[i];
            if (averagePerDay[i] > averagePerDay[highestAvgDay]) {
                highestAvgDay = i;
            }
        }
        for (int avg : averagePerDay) {
            System.out.println(avg);
        }
        System.out.println(highestAvgDay);
        System.out.println(convert(highestAvgDay));
    }

    static String convert(int day) {
        if (day == 0) {
            return "Monday";
        } else if (day == 1) {
            return "Tuesday";
        } else if (day == 2) {
            return "Wednesday";
        } else if (day == 3) {
            return "Thursday";
        } else if (day == 4) {
            return "Friday";
        } else if (day == 5) {
            return "Saturday";
        } else if (day == 6) {
            return "Sunday";
        } else {
            return "Invalid";
        }
    }
}
