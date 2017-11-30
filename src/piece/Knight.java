package piece;

import chess.ChessBoard;

public class Knight extends Piece{
	
	public Knight(boolean color, String id){
		setColor(color);
		setId(id);
	}
	public boolean isValid(int x,int y,int target_x, int target_y){
		if(Math.abs(target_x-x) == 1){
			if(Math.abs(target_y-y) == 2)
				return true;
			else
				return false;
		}
		else if(Math.abs(target_x-x) == 2){
			if(Math.abs(target_y-y) == 1)
				return true;
			else
				return false;
		}
		else
			return false;
	}


	public String returnName(){
		return "Knight";
	}
}
