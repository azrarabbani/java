package prog;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by arabbani on 11/13/16.
 @author  Azra Rabbani
 sazrai@hotmail.com
 5103619539
 */
public class BoggleBoardWordFinder {
    private game.boggle.BoggleBoard boggleBoard;
    private static int DEFAULT_SIZE = 4;
    private Set<String> dictionary;
    boolean[][] visitedPosition;

    public BoggleBoardWordFinder() {
        boggleBoard = new game.boggle.BoggleBoard(getDefaultBoggleBoardMatrix());
        dictionary = initDictionary();
        //initVisited(DEFAULT_SIZE);
    }

    private char[][] getDefaultBoggleBoardMatrix() {
        char[][] matrix = new char[DEFAULT_SIZE][DEFAULT_SIZE];

        matrix[0][0]= 'A';
        matrix[0][1]= 'N';
        matrix[0][2]= 'T';
        matrix[0][3]= 'O';
        matrix[1][0]= 'F';
        matrix[1][1]= 'I';
        matrix[1][2]= 'R';
        matrix[1][3]= 'D';
        matrix[2][0]= 'S';
        matrix[2][1]= 'O';
        matrix[2][2]= 'W';
        matrix[2][3]= 'E';
        matrix[3][0]= 'P';
        matrix[3][1]= 'A';
        matrix[3][2]= 'S';
        matrix[3][3]= 'T';
        return matrix;
    }


    /**
     * Finds all valid words which are adjoining in any direction without stepping over the same letter twice.
     * @return set of all valid words exist on the input boggle board.
     */
    public Set<String> findAllWordsOnBoggleBoard() {

        Set<String> words = new HashSet<>();
        int size = boggleBoard.getBoardSize();

        for(int indexRow = 0; indexRow < size; indexRow++) {
            for (int indexCol = 0; indexCol < size; indexCol++) {
                visitedPosition = new boolean[size][size];
                //findWordOnBoggleBoard(-1,-1, indexRow,indexCol ,"", words);
                //findWordOnBoggleBoard(indexRow,indexCol ,"", words);
//                findWordOnBoggleBoard(indexRow, indexCol-1, boggleBoard.getElement(indexRow,indexCol)+"", words) ;
//                findWordOnBoggleBoard(indexRow-1, indexCol, boggleBoard.getElement(indexRow,indexCol)+"", words) ;
//                findWordOnBoggleBoard(indexRow+1, indexCol, boggleBoard.getElement(indexRow,indexCol)+"", words) ;
//                findWordOnBoggleBoard(indexRow+1, indexCol-1, boggleBoard.getElement(indexRow,indexCol)+"", words) ;
//                findWordOnBoggleBoard(indexRow-1, indexCol+1, boggleBoard.getElement(indexRow,indexCol)+"", words) ;
//                findWordOnBoggleBoard(indexRow-1, indexCol-1, boggleBoard.getElement(indexRow,indexCol)+"", words) ;
//                findWordOnBoggleBoard(indexRow + 1, indexCol + 1, boggleBoard.getElement(indexRow,indexCol)+"", words);
            }
        }

        return words;

    }


//    private void findWordOnBoggleBoard(int indexRow, int indexCol,
//                                       int startingRow, int startingCol,
//                                       String prefix, Set<String> words,
//                                       List<BoggleBoard.Move> moves) {
//        if(indexRow == startingRow && indexCol == startingCol) {
//            return ;
//        }
//        if(indexRow == -1 ) indexRow = startingRow;
//        if(indexCol == -1 ) indexCol= startingCol;
//        if(indexCol >= boggleBoard.getBoardSize() || indexCol < 0  ||
//                indexRow < 0  || indexRow >= boggleBoard.getBoardSize() ||
//                visitedPosition[indexRow][indexCol]
//                ) {
//            return;
//        }
//
//
//        visitedPosition[indexRow][indexCol] = true;
//        prefix += boggleBoard.getElement(indexRow, indexCol);
//        if (isValidWord(prefix)) {
//            words.add(prefix);
//        }
//        moves = boggleBoard.getAllPossibleMoves(indexRow, indexCol, visitedPosition);
//        for (BoggleBoard.Move move : moves) {
//            findWordOnBoggleBoard(move.rowIdx, move.colIdx, startingRow, startingCol, moves, prefix, words);
//            visitedPosition[move.rowIdx][move.colIdx] = false;
//        }
//        visitedPosition[indexRow][indexCol] = false;
//        //findWordOnBoggleBoard(indexRow,indexCol, startingRow, startingCol, prefix, words);
//        //visitedPosition[indexRow][indexCol] = false;
//        findWordOnBoggleBoard(indexRow, indexCol-1, startingRow, startingCol, prefix, words) ;
//        visitedPosition[indexRow][indexCol-1] = false;
//        findWordOnBoggleBoard(indexRow-1, indexCol, startingRow, startingCol,prefix, words) ;
//        visitedPosition[indexRow-1][indexCol] = false;
//        findWordOnBoggleBoard(indexRow+1, indexCol, startingRow, startingCol, prefix, words) ;//boggleBoard.getElement(indexRow,indexCol)+""
//        visitedPosition[indexRow+1][indexCol] = false;
//        findWordOnBoggleBoard(indexRow+1, indexCol-1, startingRow, startingCol, prefix, words) ;
//        visitedPosition[indexRow+1][indexCol-1] = false;
//        findWordOnBoggleBoard(indexRow-1, indexCol+1, startingRow, startingCol,prefix, words) ;
//        visitedPosition[indexRow-1][indexCol+1] = false;
//        findWordOnBoggleBoard(indexRow-1, indexCol-1, indexRow, startingCol,prefix, words) ;
//        visitedPosition[indexRow-1][indexCol-1] = false;
//        findWordOnBoggleBoard(indexRow + 1, indexCol + 1, startingRow, startingCol, prefix, words);
//        visitedPosition[indexRow+1][indexCol+1] = false;
//    }
    /**
     * A N T D
     * F I R T
     * S O W E
     * P A S T
     *  int rowStartingIndex, int rowStartingIndex,
     */
    private String findWordOnBoggleBoard(int indexRow, int indexCol, String prefix, Set<String> words ) {
        if(indexCol >= boggleBoard.getBoardSize() || indexCol < 0  ||
                indexRow < 0  || indexRow >= boggleBoard.getBoardSize() ||
                visitedPosition[indexRow][indexCol]
                ) {

            return prefix;
        }
        visitedPosition[indexRow][indexCol] = true;
        prefix += boggleBoard.getElement(indexRow, indexCol);
        if (isValidWord(prefix)) {
            words.add(prefix);
        }
        prefix =  findWordOnBoggleBoard(indexRow, indexCol+1, prefix, words) ;
        return prefix;
    }


    private static Set<String> initDictionary () {
        Set<String> validWords = new HashSet<>();
        validWords.add("WORD");
        validWords.add("SET");
        validWords.add("IN");
        validWords.add("DO");
        validWords.add("POST");
        validWords.add("ANT");
        validWords.add("WET");
        validWords.add("SORT");
        validWords.add("SORE");
        validWords.add("ROSE");
        validWords.add("WE");
        validWords.add("FIT");
        validWords.add("SIT");
        validWords.add("FAN");
        validWords.add("PASTE");
        validWords.add("RIN");
        validWords.add("IT");
        validWords.add("IF");
        validWords.add("PAST");
        validWords.add("WORN");
        validWords.add("OWE");
        validWords.add("A");
        validWords.add("AN");
        validWords.add("AS");
        validWords.add("OR");
        validWords.add("SOAP");
        validWords.add("SIR");
        validWords.add("AIR");
        return validWords;
    }

    public game.boggle.BoggleBoard getBoggleBoard() {
        return  boggleBoard;
    }


    public int getBoardSize() {
        return  boggleBoard.getBoardSize();
    }

    private boolean isValidWord(String str) {
        return dictionary.contains(str);
    }

    public static void main(String[] args) {
        BoggleBoardWordFinder finder = new BoggleBoardWordFinder();
        System.out.println("Welcome to Boggle Word Finder Application");
        System.out.println("Boggle Board \n");
        long startTime = System.currentTimeMillis();
        Set<String> words = finder.findAllWordsOnBoggleBoard();
        System.out.println("Time spent in finding words "+ TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime));

        for(int i = 0; i < finder.getBoardSize(); i++) {
            for(int j=0; j < finder.getBoardSize(); j++) {
                System.out.print(finder.getBoggleBoard().getElement(i,j) +" ");
            }
            System.out.print("\n");
        }
        System.out.println("\n Following valid words found on the Boggle Board :\n");
        for (String word : words) {
            System.out.print(word +  " , ");
        }
    }
}

