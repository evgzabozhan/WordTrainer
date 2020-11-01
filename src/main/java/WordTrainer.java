import text.TextFile;
import userinterface.UserInterface;

import java.io.IOException;

public class WordTrainer {
    public static String filePath = "src/main/resources/dictionary.txt";

    public static void main(String[] args) throws IOException {
        UserInterface userInterface = new UserInterface();
        userInterface.createUserInterface();
    }
}
