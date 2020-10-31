package text;

import java.io.IOException;
import java.util.List;

public interface TextMethod {

    public String read(String filePath) throws IOException;

    public boolean remove(String filePath,String word) throws IOException;

    public boolean add(String filePath,String word) throws IOException;

    public boolean write(String filePath, List<String> dictionary);

}
