package lab_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaveLoad {
    public String loadFrom(String pathAndName) throws IOException {
        FileReader reader = new FileReader(pathAndName);
        StringBuilder builder = new StringBuilder();
        int c ;

        while ((c = reader.read()) != -1){
            builder.append((char)c);
        }
        reader.close();
        return  builder.toString();
    }
    public void saveFile(String pathAndName, String info) throws IOException {
        FileWriter writer = new FileWriter(pathAndName);
        writer.write(info);
        writer.flush();
        writer.close();
    }

}
