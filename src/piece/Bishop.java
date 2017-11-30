package piece;
import java.lang.Math;

import chess.ChessBoard;

public class Bishop extends Piece{
	
	public Bishop(boolean color, String id){
		setColor(color);
		setId(id);
		
	}

	public boolean isValid(int x,int y,int target_x, int target_y){
		if(Math.abs(x-target_x) == Math.abs(y-target_y)){
			return true;
		}
		else
			return false;
	}
	

	public String returnName(){
		return "Bishop";
	}
}
