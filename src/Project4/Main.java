package Project4;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File out = new File("C:\\Users\\gman\\Desktop\\Out.csv");
        File in = new File("C:\\Users\\gman\\Desktop\\In.csv");
        SelectionSorter sorter = new SelectionSorter();
        Parser parser = new Parser(in,11);
        Writer writer = new Writer(out);
        writer.writeData(parser.copyData());
    }
}
