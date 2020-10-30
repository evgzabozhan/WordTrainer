package text;

import java.io.IOException;

public interface TextMethod {

    public String read(String filePath) throws IOException;

    public void remove(String filePath,String word) throws IOException;

    public void add(String filePath,String word) throws IOException;

}
