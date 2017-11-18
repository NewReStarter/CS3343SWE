package chess;

import piece.Piece;
import run.Check;

public class ChessBoard 
{
	private Cell[][] board;
	private static ChessBoard theChessBoard = new ChessBoard();
	private static Check checkBlack = new Check(true);
	private static Check checkWhite = new Check(false);
	
	public ChessBoard()
	{
		board = new Cell[8][8];
	}
	
	public void initialize(int x, int y, Piece p)
	{
		Cell cell = new Cell(x, y, p);
		board[x][y] = cell;
	}

	public static ChessBoard getInstance() {
		return theChessBoard;
	}
	//addition function
	public Cell getFromPosition(int x,int y){
		return board[x][y];
	}
}
