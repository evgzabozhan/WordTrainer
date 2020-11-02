package dictionary;

import text.TextFile;
import word.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary implements DictionaryMethod {
    private static String path = "src/main/resources/Dictionary.txt";

    public static void setPath(String path) {
        Dictionary.path = path;
    }

    TextFile file = new TextFile();

    public List<Word> loadDictionary() throws IOException {
        List<Word> dictionary = new ArrayList<Word>();
            String[] words = file.read(path).split("\n");
            for (String word : words) {
                String[] values = word.split("/");
                dictionary.add(new Word(values[0], values[1]));
            }
            return dictionary;
    }

    public boolean writeWordToDictionary(Word word) {
        String wordString = word.getLanguage1() + "/" + word.getLanguage2();
        return file.add(path,wordString);
    }

    public boolean removeWordFromDictionary( Word word) throws IOException {
        String value = "";
        if (word.getLanguage1() != null) {
            value = word.getLanguage1();
        } else if (word.getLanguage2() != null) {
            value = word.getLanguage2();
        }
        return file.remove(path, value);
    }

    @Override
    public boolean checkWordFromDictionary(Word word) throws IOException {
        List<Word> dictionary = loadDictionary();
        for(Word wordFromDictionary : dictionary){
            if (wordFromDictionary.getLanguage1().equals(word.getLanguage1())
                    && wordFromDictionary.getLanguage2().equals(word.getLanguage2())){
                return true;
            }
        }
        return false;
    }
}
