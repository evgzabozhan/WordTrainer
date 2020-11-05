import org.junit.Assert;
import org.junit.Test;
import text.TextFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileTest {

    String filePath = "src/main/resources/dictionary.txt";
    TextFile file = new TextFile();


    @Test
    public void addTest()  {
        Assert.assertTrue(file.add(filePath, "Dog/Собака"));
    }

    @Test
    public void removeTest() throws IOException {
        Assert.assertTrue(file.remove(filePath,"Привет"));
    }

    @Test
    public void writeTest(){
        List<String> dictionary = new ArrayList<>();
        dictionary.add("Word/Слово\n");
        dictionary.add("Good/Хорошо\n");
        dictionary.add("Implement/Реализовывать\n");
        file.write(filePath,dictionary);
    }

    @Test
    public void checkTest(){
        Assert.assertTrue(file.check(filePath,"Привет"));
    }

}
