package piece;
import java.lang.Math;

import chess.ChessBoard;

public class Queen extends Piece{
	ChessBoard chessboard=ChessBoard.getInstance();
	public Queen(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
	
	}

	public boolean isValid(int x,int y,int target_x, int target_y){
		if(Math.abs(x-target_x) == Math.abs(y-target_y)){
			if(x>target_x){
				if(y>target_y){
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=chessboard.getPiece(x-i, y-i);
						if(piece!=null)
							return false;
					}
					return true;
				}
				else{
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=chessboard.getPiece(x-i, y+i);
						if(piece!=null)
							return false;
					}
					return true;
				}
			}
			else{
				if(y>target_y){
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=chessboard.getPiece(x+i, y-i);
						if(piece!=null)
							return false;
					}
					return true;
				}
				else{
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=chessboard.getPiece(x+i, y+i);
						if(piece!=null)
							return false;
					}
					return true;
				}
				
			}
		
		}
		else if(target_x == x && target_y != y){
			if(target_y>y){
				for(int i=1;i<target_y-y;i++){
					Piece piece=chessboard.getPiece(x, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<y-target_y;i++){
					Piece piece=chessboard.getPiece(x, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else if(target_y == y && target_x != x){
			if(target_x>x){
				for(int i=1;i<target_x-x;i++){
					Piece piece=chessboard.getPiece(x+i, y);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<x-target_x;i++){
					Piece piece=chessboard.getPiece(x-i, y);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else
			return false;
	}
	public void move(int x,int y,int target_x, int target_y){
		if(isValid(x,y,target_x,target_y)){
			chessboard.initialize(target_x, target_y,chessboard.getPiece(x, y));
			chessboard.initialize(x, y, null);
		}
		else
			System.out.println("Invalid move");
	}

	public String returnName(){
		return "Queen";
	}
}
