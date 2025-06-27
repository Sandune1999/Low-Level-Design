package TicTacToe;

import TicTacToe.Component.Player;
import TicTacToe.Component.PieceComponent.PlayingPiece;
import TicTacToe.Component.PieceComponent.PlayingPieceO;
import TicTacToe.Component.PieceComponent.PlayingPieceX;

public class Main {
    public static void main(String args[]) {

        PlayingPiece playingPiece1 = new PlayingPieceX();
        Player player1 = new Player("Sandip", playingPiece1);

        PlayingPiece playingPiece2 = new PlayingPieceO();
        Player player2 = new Player("Ritik", playingPiece2);

        TicTacToeGame.getInstance(3, player1, player2);

        String winner = TicTacToeGame.getInstance().startGame();

        if(winner.equals("Tie")) {
            System.out.println("No player won, Result is tie.");
        } else {
            System.out.println("Winner is " + winner);
        }
    }
}
