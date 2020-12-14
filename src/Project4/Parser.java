package Project4;

import java.io.*;
import java.util.Scanner;

public class Parser {
    public Scanner scanner;
    private int i = 0;
    int numValues;
    String[] data;

    public Parser(File file,int numValues) {
       this.numValues = numValues;
        data = new String[numValues];
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("404: File Not Found");
            e.printStackTrace();
        }
    }
    public String[] copyData() throws IOException {
        while (scanner.hasNext()){
            i++;
            data[i] = scanner.next();
        }
        return data;
    }
}
