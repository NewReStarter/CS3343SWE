package piece;

import chess.ChessBoard;

public class Rook extends Piece{
	private ChessBoard chessBoard = ChessBoard.getInstance();
	private boolean isFirst;
	private boolean isChange;
	public Rook(boolean color, String id){
		setColor(color);
		setId(id);
		isFirst = true;
		isChange = false;
	}
	public Rook(boolean color, String id, boolean change){
		setColor(color);
		setId(id);
		isFirst = true;
		isChange = change;
	}
	
	public boolean getIsFirst(){
		return isFirst;
	}

	public boolean getIsChange(){
		return isChange;
	}

	public boolean isValid(int x,int y,int target_x, int target_y){
		if(target_x == x && target_y != y||target_y == y && target_x != x)
			return true;
		else 
			return false;
	}

	public String returnName(){
		return "Rook";
	}
	public void changeIsFirst(){
		isFirst=false;
	}
}
