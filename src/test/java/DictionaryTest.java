import dictionary.Dictionary;
import org.junit.Test;
import word.Word;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryTest {
    String filePath = "src/main/resources/TestDictionary.txt";
    Dictionary dictionary = new Dictionary();

    @Test
    public void loadDictionaryTest() throws IOException {

        List<Word> testList = new ArrayList<>();
        testList.add(new Word("Dog", "Собака"));
        testList.add(new Word("Cat", "Кошка"));
        testList.add(new Word("Home", "Дом"));

        List<Word> dictionaryList = dictionary.loadDictionary(filePath);

        assertFalse(dictionaryList.isEmpty());
        assertEquals(dictionaryList, testList);
    }

    @Test
    public void writeWordToDictionaryTest(){
        assertTrue(dictionary.writeWordToDictionary(filePath,new Word("Time","Время")));
    }

    @Test
    public void removeWordFromDictionaryTest() throws IOException {
        //need fix bug with remove last word.
        assertTrue(dictionary.removeWordFromDictionary(filePath,new Word("Time","Время")));
    }

}
