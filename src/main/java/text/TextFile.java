package text;

import java.io.*;

public class TextFile implements TextMethod {
    File file;

    public String read(String filePath) throws IOException {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))){
            while(br.ready()){
                data.append(br.readLine()).append("\n");
            }
        }
        return data.toString();
    }

    public void remove(String filePath,String word) throws IOException {

    }

    public void add(String filePath,String word) throws IOException {
        try(BufferedWriter writer =
                new BufferedWriter(new FileWriter(filePath,true))){
            writer.write(word + "\n");
        }
    }
}
