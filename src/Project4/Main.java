package Project4;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        String[] data = new String[15];
        File out = new File("C:\\Users\\gman\\Desktop\\Out.csv");
        File in = new File("C:\\Users\\gman\\Desktop\\In.csv");
        Parser parser = new Parser(in);
        Writer writer = new Writer(out);
        writer.writeData(parser.copyData(),3);
    }
}
