package chess;

import piece.Piece;
import run.Check;
import run.Command;

public class ChessBoard 
{
	private Cell[][] board;
	private static ChessBoard theChessBoard = new ChessBoard();
	private static Check checkBlack = new Check(true);
	private static Check checkWhite = new Check(false);
	private static boolean turn = true;
	
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
	
	
	private boolean inBoundary(int x,int y,int target_x,int target_y){
		if(x>7 || y>7 || x<0 || y<0){
			System.out.print(" Position out of board.");
			return false;
		}
		if(target_x >7 || target_y >7 || target_x <0 || target_y <0){
			System.out.print(" Target position out of board.");
			return false;
		}
		return true;
		
	}
	
	public void changeTurn(){
		turn = !turn;
	}
	
	
}
