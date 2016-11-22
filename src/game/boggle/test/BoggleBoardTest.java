package game.boggle.test;

import game.boggle.BoggleWordFinder;
import game.boggle.exception.BoggleException;
//import junit.framework.TestCase;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 @author Azra Rabbani
 sazrai@hotmail.com
 5103619539
 */

public class BoggleBoardTest{//} extends  TestCase{
    private static final String DEFAULT_DICTIONARY_FILE_NAME = "C:"+ File.separator+"dictionary"+ File.separator+"dictionary.txt";

    public void testDefaultBoard() {
        try {
            BoggleWordFinder finder = new BoggleWordFinder(DEFAULT_DICTIONARY_FILE_NAME);
            Set<String> actualValidWords = getActualValidWordsForDefaultBoard();
            Set<String> words = finder.findAllWordsOnBoggleBoard();
            //assertTrue("Size of the returned word list doesn't match the expected word list size.", (words.size() == actualValidWords.size()));
            boolean found = true;
            StringBuilder missingWords = new StringBuilder();
            for (String word : words) {
                if (!actualValidWords.contains(word)) {
                    missingWords.append(word).append(",");
                }
            }
           // assertTrue("Some words [" + missingWords + "] are missing from the returned list of words", missingWords.length() == 0);
        } catch (BoggleException e) {
           // assertFalse("Error Occurred, " + e.getMessage(), true);
        }

    }

    public void testDefaultBoardMissingWords() {
        try{
            BoggleWordFinder finder = new BoggleWordFinder(DEFAULT_DICTIONARY_FILE_NAME);
            Set<String> actualValidWords = getMissingWordsForDefaultBoard();
            Set<String> words = finder.findAllWordsOnBoggleBoard();
            //assertTrue("Size of the returned word list doesn't match the expected word list size.", (words.size() > actualValidWords.size()));
            boolean found = true;
            StringBuilder missingWords = new StringBuilder();
            for (String word : words) {
                if(!actualValidWords.contains(word)) {
                    found &= false;
                }
            }
            //assertFalse("Some words should be missing from the returned list of words", found);
        } catch (BoggleException e) {
          //assertFalse("Error Occurred, "+e.getMessage(), true);
        }

    }


    private Set<String> getMissingWordsForDefaultBoard() {
        Set<String> validWords = new HashSet<>();
        validWords.add("ROSE");
        validWords.add("WE");
        validWords.add("FIT");
        validWords.add("FAN");
        validWords.add("PASTE");
        validWords.add("RIN");
        validWords.add("PAST");
        validWords.add("WORN");
        return validWords;
    }


    private Set<String> getActualValidWordsForDefaultBoard() {
        Set<String> validWords = new HashSet<>();
        validWords.add("WORD");
        validWords.add("SET");
        validWords.add("IN");
        validWords.add("POST");
        validWords.add("ANT");
        validWords.add("WET");
        validWords.add("SORT");
        validWords.add("SORE");
        validWords.add("ROSE");
        validWords.add("WE");
        validWords.add("FIT");
        validWords.add("FAN");
        validWords.add("PASTE");
        validWords.add("RIN");
        validWords.add("PAST");
        validWords.add("WORN");
        return validWords;
    }
}
