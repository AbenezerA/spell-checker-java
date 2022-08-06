/* Abenezer Amanuel
 * ata2152
 * 4/18/2022
 * This class implements a spell-checker using a hash table
*/

import java.util.*;
import java.io.*;

public class SpellChecker implements SpellCheckerInterface {

    private HashSet<String> wordset;

    //constructor takes in the file address of the dictionary and insert its
    //words into a hashset
    public SpellChecker(String filename) {

        wordset = new HashSet<>();
        File dictionaryFile = null;       
        Scanner scan1 = null; 

        try {
            dictionaryFile = new File(filename); 
            scan1 = new Scanner(dictionaryFile);

        } catch(FileNotFoundException e) {
            System.err.println("Dictionary file not found!");
            System.exit(-1);
        } catch(Exception e) {
            System.err.println("Incorrect file input!");
            System.exit(-1);
        }

        //remove punctuation and white space and add to hashset
        while(scan1.hasNextLine()) {
                String word = scan1.nextLine();

                //source: https://stackoverflow.com/questions/7552253/how-to-remove-special-characters-from-a-string
                word = word.replaceAll("[^A-Za-z0-9]", "");               
                wordset.add((word.toLowerCase()).trim());

        }
        scan1.close();

    }

    //accepts an input file and returns a list of all words that don't match 
    //any from our dictionary
    public List<String> getIncorrectWords(String filename) {

        List<String> incorrectWords = new ArrayList<>();
        File inputFile = null;
        Scanner scan2 = null;

        try {
            inputFile = new File(filename);
            scan2 = new Scanner(inputFile);

        } catch(FileNotFoundException e) {
            System.err.println("Input file not found!");
            System.exit(-1);
        } catch(Exception e) {
            System.err.println("Incorrect file input!");
            System.exit(-1);
        }

        //add the non-matching words to the created array list
        while(scan2.hasNextLine()) {
            String[] line = (scan2.nextLine()).split(" ");

            for(String s : line) {
                //source: see above
                s = s.replaceAll("[^A-Za-z0-9]", "");
                s = (s.toLowerCase()).trim();

                if(s != null && !(s.equals("")) && !(wordset.contains(s)))
                    incorrectWords.add(s);
            }
                
        }
        scan2.close(); 

        return incorrectWords;
    }

    //takes in a word and returns a set of all possible suggestions based on
    //our dictionary
    public Set<String> getSuggestions(String word) {

        if(word == null || word.equals("") || wordset.contains(word)) {
            Set<String> set1 = new HashSet<>();
            return set1;
        } else {
            
            Set<String> set2 = new HashSet<>();
            char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l',
                                'm','n','o','p','q','r','s','t','u','v','w',
                                'x','y','z'};

            //looks for suggestions after adding one character
            for(int i = 0; i <= word.length(); i++) {
                for(char c : letters) {
                    StringBuilder sb1 = new StringBuilder(word);
                    sb1.insert(i, c);
                    if(wordset.contains(sb1.toString()))
                        set2.add(sb1.toString());

                }              
            }

            //looks for suggestions by removing one character
            for(int i = 0; i < word.length(); i++) {
                StringBuilder sb2 = new StringBuilder(word);
                sb2.deleteCharAt(i);
                if(wordset.contains(sb2.toString()))
                    set2.add(sb2.toString());

            }

            //looks for suggestions by swapping adjacent characters
            for(int i = 0; i < word.length()-1; i++) {
                StringBuilder sb3 = new StringBuilder(word);
                char temp = sb3.charAt(i);
                sb3.setCharAt(i, sb3.charAt(i+1));
                sb3.setCharAt(i+1, temp);
                if(wordset.contains(sb3.toString()))
                    set2.add(sb3.toString());

            }

            return set2;
        }
    }

}