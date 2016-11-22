package game.boggle;

import game.boggle.exception.BadDictionaryPath;
import game.boggle.exception.BoggleException;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 @author  Azra Rabbani
 */
public class BoggleWordFinder {
    private BoggleBoard boggleBoard;
    private static int DEFAULT_SIZE = 4;
    private Set<String> dictionary;
    boolean[][] visited;

    public BoggleWordFinder() throws BoggleException{
        boggleBoard = new BoggleBoard(getDefaultBoggleBoardMatrix());
        dictionary = getDefaultDictionary();
    }

    public BoggleWordFinder(String dictionaryFileName) throws BoggleException{
        boggleBoard = new BoggleBoard(getDefaultBoggleBoardMatrix());
        dictionary = initDictionary(dictionaryFileName);
    }

    public BoggleWordFinder(char[][] wordsMatrix, String dictionaryFileName) throws BoggleException{
        boggleBoard = new BoggleBoard(wordsMatrix);
        dictionary = initDictionary(dictionaryFileName);
    }


    /**
     * Finds all valid words which are adjoining in any direction without stepping over the same letter twice.
     * @return set of all valid words exist on the input boggle board.
     */
    public Set<String> findAllWordsOnBoggleBoard() {
        Set<String> words = new HashSet<>();
        int size = boggleBoard.getBoardSize();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visited = new boolean[size][size];
                findAllWordsOnBoggleBoard(i, j, "", words);
            }
        }
        return words;
    }
    /**
     * A N T D
     * F I R T
     * S O W E
     * P A S T
     *  int rowStartingIndex, int rowStartingIndex,
     */
    private void findAllWordsOnBoggleBoard(int indexRow, int indexCol,
                                           String prefix,
                                           //boolean[][] visited,
                                           Set<String> words) {
        if(visited[indexRow][indexCol]) {
            return;
        }
        visited[indexRow][indexCol] = true;
        prefix += boggleBoard.getElement(indexRow, indexCol);
        if (isValidWord(prefix)) {
            words.add(prefix);
        }
        List<BoggleBoard.Move> moves = boggleBoard.getAllPossibleMoves(indexRow, indexCol, visited);
        for (BoggleBoard.Move move : moves) {
            findAllWordsOnBoggleBoard(move.rowIdx, move.colIdx, prefix, words);
        }
        visited[indexRow][indexCol] = false;
    }

    private char[][] getDefaultBoggleBoardMatrix() {
        char[][] matrix = new char[DEFAULT_SIZE][DEFAULT_SIZE];
        matrix[0][0]= 'A';
        matrix[0][1]= 'N';
        matrix[0][2]= 'T';
        matrix[0][3]= 'D';
        matrix[1][0]= 'F';
        matrix[1][1]= 'I';
        matrix[1][2]= 'R';
        matrix[1][3]= 'T';
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

    private static Set<String> getDefaultDictionary () {
        Set<String> validWords = new HashSet<>();
        validWords.add("WORD");
        validWords.add("SET");
        validWords.add("TWO");
        validWords.add("IN");
        validWords.add("DO");
        validWords.add("POST");
        validWords.add("ANT");
        validWords.add("WET");
        validWords.add("SORT");
        validWords.add("SORE");
        validWords.add("ROSE");
        validWords.add("WE");
        validWords.add("WIN");
        validWords.add("FIT");
        validWords.add("SIT");
        validWords.add("FAN");
        validWords.add("PASTE");
        validWords.add("RIN");
        validWords.add("IT");
        validWords.add("IF");
        validWords.add("PAST");
        validWords.add("FIRE");
        validWords.add("TIRE");
        validWords.add("WIRE");
        validWords.add("WORN");
        validWords.add("OWE");
        validWords.add("A");
        validWords.add("AN");
        validWords.add("AS");
        validWords.add("OR");
        validWords.add("SOAP");
        validWords.add("SORT");
        validWords.add("SIR");
        validWords.add("SIN");
        validWords.add("TIN");
        validWords.add("AIR");
        validWords.add("RINA");
        validWords.add("FORD");
        validWords.add("ANTI");
        validWords.add("ANIS");
        validWords.add("PORT");
        validWords.add("DROP");
        validWords.add("SOFA");
        return validWords;
    }


    private static Set<String> initDictionary (String dictionaryFileName) throws BoggleException{
        Set<String> dictionary = new HashSet<>();
        String word;
        File dictionaryFile = new File(dictionaryFileName);
        if(!dictionaryFile.exists()) {
            throw new BadDictionaryPath(dictionaryFileName);
        }
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(dictionaryFile)))) {
            while((word = bf.readLine() )!= null  ) {
                dictionary.add(word.toUpperCase());
            }
        } catch(IOException e){
            throw new BoggleException();
        }
        return dictionary;
    }


    public BoggleBoard getBoggleBoard() {
        return  boggleBoard;
    }


    public int getBoardSize() {
        return  boggleBoard.getBoardSize();
    }

    private boolean isValidWord(String str) {
        return dictionary.contains(str);
    }


    public static void validateFilePath(String dictionaryFileName){
        //TODO: need to assert that path is correct and file exist
    }

    public static void main(String[] args) {
        BoggleWordFinder finder = null;
        System.out.println("Welcome to Boggle Word Finder Application");

        if(args.length > 0) {
            finder = initializeAndProcessBoggleBoardAsPerArgs(args[0], finder);
        } else {//no arguments passed, initialize with default values
            try{
                //initialized with default values
                long startTime = System.currentTimeMillis();
                finder = new BoggleWordFinder();
                System.out.println("Time spent in finding words "+ (System.currentTimeMillis() - startTime));

            } catch (Exception ex) {
                System.out.print("Error occurred, " + ex.getMessage());
            }
        }
        if(finder != null) {
            Set<String> words = finder.findAllWordsOnBoggleBoard();
            System.out.println("Boggle Board \n");
            for(int i = 0; i < finder.getBoardSize(); i++) {
                for(int j=0; j < finder.getBoardSize(); j++) {
                    System.out.print(finder.getBoggleBoard().getElement(i,j) +" ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
            System.out.println("Total number of words found :"+words.size());
            System.out.println("Following words found on the Boggle Board :\n");
            for (String word : words) {
                System.out.print(word +  ",");
            }
        }
    }

    private static BoggleWordFinder initializeAndProcessBoggleBoardAsPerArgs(String arg, BoggleWordFinder finder) {
        String dictionaryFileName = arg;//scanner.next();
        validateFilePath(dictionaryFileName);
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Do you want to input your Boggle Board? (Y/N) :");
            String input = scanner.next();
            if (input != null && "Y".equals(input.trim().toUpperCase())) {
                System.out.print("Enter size of your Matrix : ");
                int size = scanner.nextInt();
                char[][] matrix = new char[size][size];
                scanner.useDelimiter("\n");
                for (int i = 0; i < size; i++) {
                    System.out.println("Please enter characters for row " + (i + 1) + " of your matrix, without spaces :");
                    input = scanner.next();
                    if (input != null && input.length() > 0) {
                        //String[] row = input.split(" ");
                        if (input.length() != size) {
                            System.out.println("Your input doesn't match the size specified earlier.");
                            i -= 1;
                            continue;//continue from here
                        }
                        char c;
                        matrix[i] = input.toCharArray(); //Character.toUpperCase(c);
                    } else {
                        System.out.println("Input is not valid exiting now!");
                        System.exit(0);
                    }
                }
                finder = new BoggleWordFinder(matrix, dictionaryFileName);
            } else {
                //initialized with default values
                finder = new BoggleWordFinder(dictionaryFileName);
            }

        } catch (Exception ex) {
            System.out.print("Error occurred, " + ex.getMessage());
        }
        return finder;
    }
}
