package TicTacToe.Component;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import TicTacToe.Component.PieceComponent.PlayingPiece;

public class Board {
    private final int size;
    private final PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if(board[row][column] != null) {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    System.out.print("   ");
                } else {
                    System.out.print(board[i][j].getPieceType().name() + "  ");
                }
                if(j != size - 1) System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public List<SimpleEntry<Integer, Integer>> getFreeCells() {
        List<SimpleEntry<Integer, Integer>> freeSpace = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    freeSpace.add(new SimpleEntry<>(i, j));
                }
            }
        }

        return freeSpace;
    }
}
