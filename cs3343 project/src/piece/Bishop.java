package piece;
import java.lang.Math;

import chess.ChessBoard;

public class Bishop extends Piece{
	private ChessBoard chessboard=ChessBoard.getInstance();
	public Bishop(boolean color, String id, int x, int y){
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
		else
			return false;
	}
	
	public void move(int x,int y,int target_x, int target_y){
		if(isValid(target_x,target_y)){
			chessboard.initialize(target_x, target_y,chessboard.getPiece(x, y));
			chessboard.initialize(x, y, null);
		}
		else
			System.out.println("Invalid Move");
	}

	public String returnName(){
		return "Bishop";
	}
}
