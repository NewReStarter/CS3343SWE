package piece;

import chess.ChessBoard;

public class Rook extends Piece{
	private ChessBoard chessboard=ChessBoard.getInstance();
	private boolean isFirst;
	private boolean isChange;
	public Rook(boolean color, String id){
		setColor(color);
		setId(id);
		isFirst = true;
		isChange = false;
	}
	public Rook(boolean color, String id, int x, int y,boolean change){
		setColor(color);
		setId(id);
		isFirst = true;
		isChange = change;
	}
	
	public boolean isFirst(){
		return isFirst;
	}

	public boolean ischange(){
		if(isChange)
			return true;
		else
			return false;
	}

	public boolean isValid(int x,int y,int target_x, int target_y){
		if(target_x == x && target_y != y||target_y == y && target_x != x)
			return true;
		else 
			return false;
	}
	public void move(int x,int y,int target_x, int target_y){
		
	}
	public String returnName(){
		return "Rook";
	}
	public void changeisFirst(){
		isFirst=false;
	}
}
