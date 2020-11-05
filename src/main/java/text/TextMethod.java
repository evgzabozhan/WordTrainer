package text;

import java.io.IOException;
import java.util.List;

public interface TextMethod {

    String read(String filePath) throws IOException;

    boolean remove(String filePath,String word) throws IOException;

    boolean add(String filePath,String word) throws IOException;

    boolean write(String filePath, List<String> dictionary);

}
