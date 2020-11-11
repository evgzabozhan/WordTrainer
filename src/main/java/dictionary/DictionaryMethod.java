package dictionary;

import word.Word;

import java.io.IOException;
import java.util.List;

public interface DictionaryMethod {
     List<Word> loadDictionary() throws IOException;

     boolean writeWordToDictionary(Word word);

     boolean removeWordFromDictionary( Word word) throws IOException;

     boolean checkWordFromDictionary(Word word) throws IOException;

     boolean changeWordAtDictionary(Word word) throws IOException;
}
