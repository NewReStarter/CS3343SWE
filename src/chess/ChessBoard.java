package chess;

import java.util.Scanner;

import piece.*;
import run.Check;
import run.Command;

public class ChessBoard 
{
	private Piece[][] board;
	private static ChessBoard theChessBoard = new ChessBoard();
	private static Check check ;
	private static boolean turn = true;
	private static boolean castling = false;
	
	public ChessBoard()
	{
		board = new Piece[8][8];
		for(int i=0;i<8;i++){
			for(int k=0;i<8;i++){
				board[i][k]=null;
			}
		}
	}
	
	public void initialize(int x, int y, Piece p)
	{
		board[x][y] = p;
	}

	public static ChessBoard getInstance() {
		return theChessBoard;
	}
	//addition function
	public Piece getPiece(int x,int y){
		return board[x][y];
	}
	
	
	public boolean inBoundary(int x,int y,int target_x,int target_y){
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
	public boolean move(int x,int y,int target_x,int target_y){
		check = Check.getInstance();

		if(check.checkmate())
			System.out.println("Your king is in check!");
		
		if(!inBoundary(x,y,target_x,target_y))
			return false;
		
			
		Piece p = this.getPiece(x,y);
		if(p==null){
			System.out.println("No piece at that position");
			return false;
		}
			
		if(p.getColor()!=turn){
			System.out.println("This is not your piece");
			return false;
		}
		
		if(check.checkOccupyByUs(target_x, target_y)){
			System.out.println("It is already occupied by your piece");
			return false;
		}
		
		if(p instanceof Bishop) {
			
			if(p.isValid(x, y,target_x,target_y)&&check.checkBishipBlock(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			}
			else
				System.out.println("Invalid Move");
		}
		else if(p instanceof King) {
			if(p.isValid(x,y,target_x,target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
				if(((King) p).isFirst()){
					((King) p).changeisFirst();
				}
			}
			else
				System.out.println("Invalid Move");
		}
		else if (p instanceof Knight){
			if(p.isValid(x,y,target_x,target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			}
			else{
				System.out.println("Invalid move");
			}
		}
		else if(p instanceof Queen){
			if(p.isValid(x,y,target_x,target_y)&&check.checkQueenBlock(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			}
			else
				System.out.println("Invalid move");
		}
		else if(p instanceof Rook){
			if(p.isValid(x,y,target_x,target_y)&&check.checkRookBlock(x, y, target_x, target_y)){
				
				((Rook) p).changeisFirst();
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			
		}
		else
			System.out.println("Invalid Move");
		}
		
		else if(p instanceof Pawn) {
			
			if(check.checkPawnNormalmove(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
				if(((Pawn) p).getIfFirstMove()&&Math.abs(target_x-x)==2){
					((Pawn) p).changePassantToTrue();
				}
				if(((Pawn) p).getIfFirstMove()==false)
					((Pawn) p).changePassantToFalse();
				((Pawn) p).changePassantToFalse();
				
				if(theChessBoard.getPiece(target_x, target_y).getColor()){
					if(target_x==7){
						System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
						Scanner in = new Scanner(System.in);
						int role=in.nextInt();
						in.close();
						switch (role){
						case 1:
							theChessBoard.initialize(target_x, target_y, new Knight(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 2:
							theChessBoard.initialize(target_x, target_y, new Bishop(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 3:
							theChessBoard.initialize(target_x, target_y, new Rook(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 4:
							theChessBoard.initialize(target_x, target_y, new Queen(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						}
					}
				}
				else{
					if(target_x==0){
						System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
						Scanner in = new Scanner(System.in);
						int role=in.nextInt();
						in.close();
						switch (role){
						case 1:
							theChessBoard.initialize(target_x, target_y, new Knight(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 2:
							theChessBoard.initialize(target_x, target_y, new Bishop(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 3:
							theChessBoard.initialize(target_x, target_y, new Rook(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 4:
							theChessBoard.initialize(target_x, target_y, new Queen(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						}
					}
				}
			}
			else if(check.checkPawnEat(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
				((Pawn) p).changePassantToFalse();
				if(theChessBoard.getPiece(target_x, target_y).getColor()){
					if(target_x==7){
						System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
						Scanner in = new Scanner(System.in);
						int role=in.nextInt();
						in.close();
						switch (role){
						case 1:
							theChessBoard.initialize(target_x, target_y, new Knight(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 2:
							theChessBoard.initialize(target_x, target_y, new Bishop(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 3:
							theChessBoard.initialize(target_x, target_y, new Rook(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 4:
							theChessBoard.initialize(target_x, target_y, new Queen(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						}
					}
				}
				else{
					if(target_x==0){
						System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
						Scanner in = new Scanner(System.in);
						int role=in.nextInt();
						in.close();
						switch (role){
						case 1:
							theChessBoard.initialize(target_x, target_y, new Knight(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 2:
							theChessBoard.initialize(target_x, target_y, new Bishop(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						case 3:
							theChessBoard.initialize(target_x, target_y, new Rook(theChessBoard.getPiece(x, y).getColor(),"1",target_x,target_y,true));
							break;
						case 4:
							theChessBoard.initialize(target_x, target_y, new Queen(theChessBoard.getPiece(x, y).getColor(),"1"));
							break;
						}
					}
				}
			}
			else if(check.checkPawnPassant(x,y,target_x,target_y)){
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, target_y, null);
				theChessBoard.initialize(x, y, null);
			}
			else{
				System.out.println("Invalid move");
				return false;
			}
		
		}
		return true;
	}
	public void printChessBoard(){
		for (Piece[] p: board){
			for (Piece piece : p){
				if(piece!=null)
					System.out.printf("%-8s",piece.returnName());
				else
					System.out.print("XXXXXX  ");
			}
			System.out.println();
			System.out.println();
		}
	}

	public boolean getTurn(){
		return turn;
	}
	
	
}
