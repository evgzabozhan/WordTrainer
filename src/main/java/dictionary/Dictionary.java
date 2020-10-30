package dictionary;

import word.Word;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dictionary implements DictionaryMethod {
    List<Word> Dictionary = new ArrayList<Word>();

    public boolean loadDictionary(String path) {
        File dictionary = new File(path);

        return false;
    }

    public boolean writeWordToDictionary(String path) {
        return false;
    }

    public boolean deleteWordFromDictionary(String path) {
        return false;
    }
}
