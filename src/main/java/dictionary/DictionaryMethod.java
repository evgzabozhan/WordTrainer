package dictionary;

public interface DictionaryMethod {
    public boolean loadDictionary(String path);
    public boolean writeWordToDictionary(String path);
    public boolean deleteWordFromDictionary(String path);
}
