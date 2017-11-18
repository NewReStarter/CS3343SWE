package run;

import chess.ChessBoard;
import piece.*;

public class Main 
{
	private static King blackKing;
	//.....
	private static ChessBoard chessBoard = ChessBoard.getInstance();
	//.....
	
	
    public static void main(String[] args)
    {
    	blackKing = new King(true, "1", 0, 5);
    	//.....
    	chessBoard.initialize(1,2,blackKing);
    	//.....
    }
}
