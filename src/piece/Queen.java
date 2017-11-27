package piece;
import java.lang.Math;

import chess.ChessBoard;

public class Queen extends Piece{
	//ChessBoard chessboard=ChessBoard.getInstance();
	public Queen(boolean color, String id){
		setColor(color);
		setId(id);
	
	}

	public boolean isValid(int x,int y,int target_x, int target_y){
		if(Math.abs(x-target_x) == Math.abs(y-target_y)||target_x == x && target_y != y||target_y == y && target_x != x)
			return true;
		else
			return false;
	}

	public String returnName(){
		return "Queen";
	}
}
