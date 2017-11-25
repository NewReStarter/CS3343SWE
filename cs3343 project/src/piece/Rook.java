package piece;

import chess.ChessBoard;

public class Rook extends Piece{
	private ChessBoard chessboard=ChessBoard.getInstance();
	private boolean isFirst;
	private boolean isChange;
	public Rook(boolean color, String id, int x, int y){
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
		if(target_x == x && target_y != y){
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
			
				isFirst = false;
				chessboard.initialize(target_x, target_y, chessboard.getPiece(x, y));
				chessboard.initialize(x, y, null);
			
		}
		else
			System.out.println("Invalid Move");
	}
	public String returnName(){
		return "Rook";
	}
}
