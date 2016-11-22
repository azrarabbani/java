package game.boggle.exception;

import game.boggle.BoggleBoard;

/**
 @author Azra Rabbani
 sazrai@hotmail.com
 5103619539
 */
public class BadDictionaryPath extends BoggleException {
    private String dictionaryPath;

    public BadDictionaryPath(String dictionaryPath) {
        this.dictionaryPath = dictionaryPath;
    }

    @Override
    public String getMessage() {
        return "File "+dictionaryPath+" doesn't exists!";
    }

}
