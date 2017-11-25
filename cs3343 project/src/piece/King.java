package piece;

import chess.ChessBoard;
import run.Check;

public class King extends Piece{
	
	private boolean isFirst;
	private ChessBoard chessboard=ChessBoard.getInstance();
	public King(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		
		isFirst = true;
	}
	
	
	public boolean isValid(int x,int y,int target_x, int target_y) {
		Check check;
		if(this.color == true){
			check = chessboard.returnBlackCheck();
		}
			else
				check = chessboard.returnWhiteCheck();
		if(check.checkmate()){
			System.out.println("Your king is in danger");
			return false;
		}
		if (x == target_x && (y - target_y == 1 || y - target_y == -1))
			return true;
		if (y == target_y && (x - target_x == 1 || x - target_x == -1))
			return true;
		if(Math.abs(target_x-x)==1&&Math.abs(target_y-y)==1)
			return true;
		return false;
	}
	public void move(int x,int y,int target_x, int target_y){
		if(isValid(x,y,target_x,target_y)){
			chessboard.initialize(target_x, target_y,chessboard.getPiece(x, y));
			chessboard.initialize(x, y, null);
			if(isFirst){
				isFirst = false;
			}
		}
		else
			System.out.println("Invalid Move");
	}

	public boolean isFirst(){return isFirst;}

	public String returnName(){
		return "King";
	}

}
