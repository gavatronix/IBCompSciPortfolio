package Project4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer{
    private FileWriter writer;
    private int rowLength;
    public Writer(File file){
        try {
            writer = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error 404: File not found");
        }
    }
   public void writeData(String[] data) throws IOException {
       for (int i = 0; i < data.length; i++) {
           writer.write(data[i]);
       }
       writer.close();
   }

}
