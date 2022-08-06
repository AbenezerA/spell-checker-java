import java.io.FileNotFoundException;

public class SPTest {

    public static void main(String[] args) throws FileNotFoundException {

        SpellChecker sc = new SpellChecker("words.txt");
        System.out.println("Incorrect Words: " + sc.getIncorrectWords("test.txt"));

        for(String s : sc.getIncorrectWords("test.txt")) {

            System.out.println("Word suggestion/s for " + s + ": " + sc.getSuggestions(s));

        }
        
        

    }

}