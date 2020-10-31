package word;

import java.util.Objects;

public class Word {

    private String language1;
    private String language2;

    public Word(String language1, String language2) {
        this.language1 = language1;
        this.language2 = language2;
    }

    public String getLanguage1() {
        return language1;
    }

    public void setLanguage1(String language1) {
        this.language1 = language1;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return language1.equals(word.language1) &&
                language2.equals(word.language2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language1, language2);
    }
}
