package Project4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer{
    private FileWriter writer;
    public Writer(File file){
        try {
            writer = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error 404: File not found");
        }
    }
   public void writeData(List<String> data, int rowLength) throws IOException {
       for (int i = 0; i < data.size(); i++) {
           if (i % rowLength == 0 && i != 0) {
               writer.write("\n");
           }
           writer.write(data.get(i) +",");
       }
       writer.close();
   }

}
