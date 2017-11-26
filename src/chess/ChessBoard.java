package chess;

import java.util.Scanner;

import piece.*;
import run.Check;
import run.Command;

public class ChessBoard 
{
	private Piece[][] board;
	private static ChessBoard theChessBoard = new ChessBoard();
	private static Check check;
	
	public ChessBoard()
	{
		board = new Piece[8][8];
		for(int i=0;i<8;i++){
			for(int k=0;i<8;i++){
				board[i][k]=null;
			}
		}
    	set(0,0,new Rook(true, "a0"));
    	set(0,1,new Knight(true, "a1"));
    	set(0,2,new Bishop(true, "a2"));
    	set(0,3,new Queen(true, "a3"));
    	set(0,4,new King(true, "a4"));
    	set(0,5,new Bishop(true, "a5"));
    	set(0,6,new Knight(true, "a6"));
    	set(0,7,new Rook(true, "a7"));
    	set(1,0,new Pawn(true, "b0"));
    	set(1,1,new Pawn(true, "b1"));
    	set(1,2,new Pawn(true, "b2"));
    	set(1,3,new Pawn(true, "b3"));
    	set(1,4,new Pawn(true, "b4"));
    	set(1,5,new Pawn(true, "b5"));
    	set(1,6,new Pawn(true, "b6"));
    	set(1,7,new Pawn(true, "b7"));
    	
    	set(7,0,new Rook(false, "g0"));
    	set(7,1,new Knight(false, "g1"));
    	set(7,2,new Bishop(false, "g2"));
    	set(7,3,new Queen(false, "g3"));
    	set(7,4,new King(false, "g4"));
    	set(7,5,new Bishop(false, "g5"));
    	set(7,6,new Knight(false, "g6"));
    	set(7,7,new Rook(false, "g7"));
    	set(6,0,new Pawn(false, "f0"));
    	set(6,1,new Pawn(false, "f1"));
    	set(6,2,new Pawn(false, "f2"));
    	set(6,3,new Pawn(false, "f3"));
    	set(6,4,new Pawn(false, "f4"));
    	set(6,5,new Pawn(false, "f5"));
    	set(6,6,new Pawn(false, "f6"));
    	set(6,7,new Pawn(false, "f7"));
	}
	
	public void set(int x, int y, Piece p)
	{
		board[x][y] = p;
	}

	public static ChessBoard getInstance() 
	{
		return theChessBoard;
	}
	//addition function
	public Piece getPiece(int x,int y){
		return board[x][y];
	}
	
	
	public boolean inBoundary(int x,int y,int target_x,int target_y)
	{
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
	

	public boolean move(int x,int y,int target_x,int target_y)
	{
		Piece p = theChessBoard.getPiece(x,y);
		
		if(!inBoundary(x,y,target_x,target_y))
			return false;
		
		if(!check.checkTheMoveIsVaild(x, y, target_x, target_y))
			return false;
			
		theChessBoard.set(target_x, target_y,theChessBoard.getPiece(x, y));
		theChessBoard.set(x, y, null);
		
		
		if(p instanceof King) 
		{
			if(((King) p).isFirst())
				((King) p).changeisFirst();
			if(target_x - x == 2)
			{
				theChessBoard.set(target_x-1, target_y,theChessBoard.getPiece(7, y));
				theChessBoard.set(7, y, null);
			}
			if(target_x - x == -2)
			{
				theChessBoard.set(target_x+1, target_y,theChessBoard.getPiece(0, y));
				theChessBoard.set(0, y, null);
			}
		}
		else if(p instanceof Rook)
		{
			((Rook) p).changeisFirst();
		}
		else if(p instanceof Pawn) 
		{
			if(check.checkPawnNormalmove(x, y, target_x, target_y))
			{			
				if(((Pawn) p).getIfFirstMove())
				{
					((Pawn) p).setIfFirstMoveFalse();
					if(Math.abs(target_x-x)==2)
					{
						((Pawn) p).changePassantToTrue();
					}
				}
				else 
					((Pawn) p).changePassantToFalse();
			}
			
			else if(check.checkPawnEat(x, y, target_x, target_y))
			{
				((Pawn) p).changePassantToFalse();
				
			}
			else if(check.checkPawnPassant(x,y,target_x,target_y))
			{
				theChessBoard.set(x, target_y, null);
			}
			
			if (check.checkPawnToChange(target_x, target_y))
			{
				changePawn(target_x, target_y);
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
	
	public void changePawn(int target_x,int target_y)
	{
		System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
		Scanner in = new Scanner(System.in);
		int role=in.nextInt();
		in.close();
		switch (role){
		case 1:
			theChessBoard.set(target_x, target_y, new Knight(theChessBoard.getPiece(target_x, target_y).getColor(),"g2"));
			break;
		case 2:
			theChessBoard.set(target_x, target_y, new Bishop(theChessBoard.getPiece(target_x, target_y).getColor(),"g3"));
			break;
		case 3:
			theChessBoard.set(target_x, target_y, new Rook(theChessBoard.getPiece(target_x, target_y).getColor(),"g1",target_x,target_y,true));
			break;
		case 4:
			theChessBoard.set(target_x, target_y, new Queen(theChessBoard.getPiece(target_x, target_y).getColor(),"g4"));
			break;
		}
	}
}