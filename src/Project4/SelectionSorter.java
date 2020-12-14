package Project4;

public class SelectionSorter implements Sorter {
    private String[] output;
    private double record;
    private int recordPos;
    public String[] sort(String[] input, Boolean ascending) {
        output = new String[input.length];
        for (int j = 0; j < input.length; j++) {
            for (int i = 0; i < input.length-1; i++) {
                if (input[i] != null && input[i+1] != null){
                    if (ascending) {
                        if (Double.valueOf(input[i]) > Double.valueOf(input[i+1])) {
                            record = Double.valueOf(input[i]);
                            recordPos = i;
                        }
                    } else if (!ascending) {
                        if (Double.valueOf(input[i]) < Double.valueOf(input[i+1])) {
                            record = Double.valueOf(input[i]);
                            recordPos = i;
                        }
                    }
                }
            }
            output[j] = input[recordPos];
            input[recordPos] = null;
        }
        return output;
    }
}
