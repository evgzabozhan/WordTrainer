package dictionary;

import word.Word;

import java.io.IOException;
import java.util.List;

public interface DictionaryMethod {
     List<Word> loadDictionary(String path) throws IOException;
     boolean writeWordToDictionary(String path,Word word);
     boolean removeWordFromDictionary(String path, Word word) throws IOException;
}
