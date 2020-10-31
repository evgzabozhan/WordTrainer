package text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFile implements TextMethod {

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

    public boolean add(String filePath,String word) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            writer.write(word + "\n");
            return true;
        } catch (IOException e){
            return false;
        }
    }

    public boolean remove(String filePath,String word) throws IOException {
        String[] words = read(filePath).split("\n");
        List<String> dictionary = new ArrayList<>();
        try {
            for (int i = 0; i < words.length - 1; i++) {
                if (!words[i].toLowerCase().contains(word.toLowerCase()))
                    dictionary.add(words[i] + "\n");
            }
            return write(filePath, dictionary);
        } catch (Exception e){
            return false;
        }
    }

    public boolean write(String filePath,List<String> dictionary) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(String word : dictionary){
                writer.write(word);
            }
            return true;
        } catch (IOException e){
            return false;
        }
    }
}
