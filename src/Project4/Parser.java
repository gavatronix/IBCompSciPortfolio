package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
    private int sum;
    private int number = 0;
    public Scanner scanner;

    public Parser(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("404: File Not Found");
            e.printStackTrace();
        }
    }
    public List<String> copyData(){
        List<String> data = new ArrayList<String>();
        while (scanner.hasNext()){
            data.add(scanner.next());
        }
        return data;
    }
}
