package Project4;

public class BubbleSorter implements Sorter{
    private boolean sorted = false;
    private int lastCount;
    private int count = 0;
    private String memory;
    private int first;
    private int second;

    public String[] sort(String[] input, Boolean ascending) {
        while (!sorted){
            for (int i = 0; i < input.length-1; i++) {
                if(ascending){
                    if (Integer.valueOf(input[i])>Integer.valueOf(input[i+1])){
                            input[i+1] = memory;
                            input[i+1] = input[i];
                            input[i] = memory;
                            count++;
                    }
                } else if (!ascending){
                    if (Integer.valueOf(input[i])<Integer.valueOf(input[i+1])){
                        if (i == input.length){
                            second = 0;
                        }
                        input[i+1] = memory;
                        input[i+1] = input[i];
                        input[i] = memory;
                        count++;
                    }
                }
            }
            if (count == lastCount){
                sorted = true;
            } else{
                lastCount = count;
            }
        }
        return input;
    }
}
