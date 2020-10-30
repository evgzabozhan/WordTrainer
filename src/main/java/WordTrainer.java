import text.TextFile;

import java.io.IOException;

public class WordTrainer {
    public static String filePath = "src/main/resources/dictionary.txt";
    public static void main(String[] args) throws IOException {
        TextFile textFile = new TextFile();
        String value = textFile.read(filePath);
        System.out.println(value);
        textFile.add(filePath,"Chicken/Курица");
        textFile.add(filePath,"Good/Хорошо");
        textFile.add(filePath,"Home/Дом");
        value = textFile.read(filePath);
        System.out.println(value);
    }
}
