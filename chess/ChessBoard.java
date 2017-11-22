package chess;

import piece.*;
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
	private static boolean castling = false;
	
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
	public void move(int x,int y,int target_x,int target_y){
		Check check;
		if(turn == true){
			check = checkBlack;
		}
		else
			check = checkWhite;
		if(check.checkmate())
			System.out.println("Your king is in danger");
		if(!inBoundary(x,y,target_x,target_y))
			return;
		
			
		Piece p = this.getFromPosition(x, y).getpiece();
		if(p==null){
			System.out.println("No piece at that position");
			return;
		}
			
		if(p.color!=turn){
			System.out.println("This is not your piece");
			return;
		}
		
		if(check.checkOccupyByUs(target_x, target_y)){
			System.out.println("It is already occupied by your piece");
			return;
		}
		
		Piece target = this.getFromPosition(target_x, target_y).getpiece();
		if(p instanceof Pawn){
			Pawn pawn = (Pawn)p;
			if(target_x-1!=0){
				if(check.checkEnpassant(x, y, target_x, target_y)){
					pawn.move(target_x, target_y);
					board[target_x][target_y]=board[x][y];
					board[x][y] = null;
					board[target_x][y] = null;
					
				}
				else if(check.checkOccupyByEn(target_x, target_y)){
					pawn.move(target_x, target_y);
					board[target_x][target_y]=board[x][y];
					board[x][y] = null;
				}
				else
					return;
			}
			else{
				pawn.move(target_x, target_y);
				board[target_x][target_y]=board[x][y];
				board[x][y] = null;
			}
			
			if(pawn.atBoundary()){
				System.out.println("You can change your pawn,to: ");
				//need some code
			}
		}
		if(p instanceof King){
			King king = (King)p;
			if(check.checkCastling(x, y, target_x))
			{
				//need some code
			}
		}
		else{
			p.move(target_x, target_y);
			board[target_x][target_y]=board[x][y];
			board[x][y] = null;
					
			
		}
	}
	
	
}
