package piece;

import chess.ChessBoard;

public class Knight extends Piece{
	private ChessBoard chessboard=ChessBoard.getInstance();
	public Knight(boolean color, String id, int x, int y){
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
	public void move(int x,int y,int target_x, int target_y){
		if(isValid(x,y,target_x,target_y)){
			chessboard.initialize(target_x, target_y,chessboard.getPiece(x, y));
			chessboard.initialize(x, y, null);
		}
		else{
			System.out.println("Invalid move");
		}
	
	}

	public String returnName(){
		return "Knight";
	}
}
