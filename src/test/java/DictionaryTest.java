import dictionary.Dictionary;
import org.junit.Assert;
import org.junit.Test;
import word.Word;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryTest {
    Dictionary dictionary = new Dictionary();



    @Test
    public void loadDictionaryTest() throws IOException {
        Dictionary.setPath("src/main/resources/TestDictionary.txt");

        List<Word> testList = new ArrayList<>();
        testList.add(new Word("Dog", "Собака"));
        testList.add(new Word("Cat", "Кошка"));
        testList.add(new Word("Home", "Дом"));

        List<Word> dictionaryList = dictionary.loadDictionary();

        assertFalse(dictionaryList.isEmpty());
        assertEquals(dictionaryList, testList);
    }

    @Test
    public void writeWordToDictionaryTest(){
        Dictionary.setPath("src/main/resources/TestDictionary.txt");
        assertTrue(dictionary.writeWordToDictionary(new Word("Time","Время")));
    }

    @Test
    public void removeWordFromDictionaryTest() throws IOException {
        Dictionary.setPath("src/main/resources/TestDictionary.txt");
        assertTrue(dictionary.removeWordFromDictionary(new Word("Time","Время")));
    }

    @Test
    public void checkWordFromDictionaryTest() throws IOException {
        Dictionary.setPath("src/main/resources/TestDictionary.txt");

        Assert.assertTrue(dictionary.checkWordFromDictionary(new Word("Cat","Кошка")));
    }

    @Test
    public void changeWordAtDictionaryTest() throws IOException {
        Dictionary.setPath("src/main/resources/TestDictionary.txt");

        Assert.assertTrue(dictionary.changeWordAtDictionary(new Word("Home","Дом")));

    }

}
