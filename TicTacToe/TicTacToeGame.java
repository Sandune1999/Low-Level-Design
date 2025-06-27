package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

import TicTacToe.Component.Board;
import TicTacToe.Component.Player;
import TicTacToe.Component.PieceComponent.PieceType;

public class TicTacToeGame {
    private static volatile TicTacToeGame instance = null;

    private final Deque<Player> players;
    private final Board board;

    private TicTacToeGame(int size, Player player1, Player player2) {

        //Initilising player
        players = new LinkedList<>();

        players.add(player1);
        players.add(player2);


        //Initilising board
        board = new Board(size);
    }

    public static TicTacToeGame getInstance(int size, Player player1, Player player2) {
        if(instance == null) {
            synchronized(TicTacToeGame.class) {
                if(instance == null) {
                    instance = new TicTacToeGame(size, player1, player2);
                }   
            }
        } 

        return instance;
    }

    public static TicTacToeGame getInstance() {
        if(instance == null) {
            System.out.println("instance is initilised.");
        }

        return instance;
    }

    @SuppressWarnings("resource")
    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            Player playerTurn = players.removeFirst();

            board.printBoard();
            List<SimpleEntry<Integer, Integer>> freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Player: " + playerTurn.getName() + " Enter row & column for putting the piece:- " + playerTurn.getPlayingPiece().getPieceType());
            
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = board.addPiece(inputRow, inputColumn, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect postion chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece().getPieceType());

            if(winner) {
                return playerTurn.getName();
            }
        }

        return "Tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean columnCheck = true;
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getBoard()[i][column] == null ||  board.getBoard()[i][column].getPieceType() != pieceType) {
                columnCheck = false;
                break;
            }
        }

        boolean rowCheck = true;
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getBoard()[row][i] == null || board.getBoard()[row][i].getPieceType() != pieceType) {
                rowCheck = false;
                break;
            }
        }

        boolean diagonalCheck = true;
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getBoard()[i][i] == null || board.getBoard()[i][i].getPieceType() != pieceType) {
                diagonalCheck = false;
                break;
            }
        }

        boolean antiDiagonalCheck = true;
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getBoard()[i][board.getSize() - i - 1] == null || board.getBoard()[i][board.getSize() - i - 1].getPieceType() != pieceType) {
                antiDiagonalCheck = false;
                break;
            }
        }

        return rowCheck || columnCheck || diagonalCheck || antiDiagonalCheck;
    }
}
