package prog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by arabbani on 11/13/16.
 */
public class BoggleBoard {

    char[][] boggleBoardMatrix;
    private int BOARD_SIZE ;


    public BoggleBoard(char[][] matrix) {
        boggleBoardMatrix = matrix;
        BOARD_SIZE = boggleBoardMatrix.length;
    }

    public char getElement(int indexRow, int indexCol) {
        return boggleBoardMatrix[indexRow][indexCol];
    }

    public List<BoggleBoard.Move> getAllPossibleMoves(int row, int col, boolean[][] visited) {
        List<BoggleBoard.Move> moves = new ArrayList<>();
        BoggleBoard.Move move = getRightElement(row, col, visited);
        if(move !=null) {
            moves.add(move);
        }
        move = getLeftElement(row, col, visited);
        if(move !=null) {
            moves.add(move);
        }
        move = getDiagonalUpRightElement(row, col, visited);
        if(move !=null) {
            moves.add(move);
        }
        move = getDiagonalUpLeftElement(row, col, visited);
        if(move !=null) {
            moves.add(move);
        }
        move = getUpElement(row,col, visited);
        if(move !=null) {
            moves.add(move);
        }
        move = getDownElement(row,col, visited);
        if(move !=null) {
            moves.add(move);
        }
        move = getDiagonalDownRight(row,col, visited);
        if(move !=null) {
            moves.add(move);
        }
        move = getDiagonalDownLeftElement(row,col, visited);
        if(move !=null) {
            moves.add(move);
        }
        return moves;

    }

    private BoggleBoard.Move getDiagonalUpRightElement(int row, int col, boolean[][] visited){
        int nextRow =  row-1;
        int nextCol = col+1;
        if(nextRow >= 0 && nextCol < BOARD_SIZE && !visited[nextRow][nextCol]) { return new BoggleBoard.Move(nextRow, nextCol) ;}
        return null;
    }

    private BoggleBoard.Move getDiagonalUpLeftElement(int row, int col, boolean[][] visited){
        int nextRow =  row-1;
        int nextCol = col -1;
        if(nextRow >= 0 && nextCol >= 0 && !visited[nextRow][nextCol]) { return new BoggleBoard.Move(nextRow, nextCol) ;}
        return null;
    }


    private BoggleBoard.Move getDiagonalDownLeftElement(int row, int col, boolean[][] visited){
        int nextRow =  row+1;
        int nextCol = col-1;
        if(nextRow < BOARD_SIZE && nextCol >= 0  && !visited[nextRow][nextCol]) { return new BoggleBoard.Move(nextRow, nextCol) ;}
        return null;
    }

    private BoggleBoard.Move getUpElement(int row, int col, boolean[][] visited){
        int nextRow =  row-1;
        if(nextRow >= 0  && !visited[nextRow][col] ) { return new BoggleBoard.Move(nextRow, col) ;}
        return null;
    }

    private BoggleBoard.Move getDownElement(int row, int col, boolean[][] visited){
        int nextRow =  row+1;
        if(nextRow < BOARD_SIZE   && !visited[nextRow][col]) { return new BoggleBoard.Move(nextRow, col) ;}
        return null;
    }


    private BoggleBoard.Move getLeftElement(int row, int col, boolean[][] visited){
        int nextCol = col -1;
        if(nextCol >= 0 && !visited[row][nextCol]) { return new BoggleBoard.Move(row, nextCol) ;}
        return null;
    }

    private BoggleBoard.Move getRightElement(int row, int col, boolean[][] visited){
        int nextCol = col +1;
        if(nextCol < BOARD_SIZE && !visited[row][nextCol]) { return new BoggleBoard.Move(row, nextCol) ;}
        return null;
    }

    private BoggleBoard.Move getDiagonalDownRight(int row, int col, boolean[][] visited){
        int nextRow =  row+1;
        int nextCol = col+1;
        if(nextRow < BOARD_SIZE && nextCol < BOARD_SIZE && !visited[nextRow][nextCol]) { return new BoggleBoard.Move(nextRow, nextCol) ;}
        return null;
    }
    /**
     * This class represents a move on the boggleBoard
     */
    public static class Move implements  Comparable<Move> {
        final int rowIdx;
        final int colIdx;

        public Move(int rowIdx , int colIdx) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
        }

        public boolean equals(Object obj) {
            if(obj == null ||  ! (obj instanceof  Move)) return false;
            Move objMove = (Move) obj;
            return this.rowIdx == objMove.rowIdx && this.colIdx == objMove.colIdx;
        }

        public int hashCode() {
            return Integer.hashCode(this.rowIdx) + Integer.hashCode(this.colIdx);
        }

        public int compareTo(Move obj) {
            return equals(obj) ? 0 : -1;
        }
    }

}
