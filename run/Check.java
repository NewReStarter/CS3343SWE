package run;

import chess.Cell;
import chess.ChessBoard;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class Check 
{
	private ChessBoard board = ChessBoard.getInstance();
	private int king_x,king_y;
	private boolean color;
	
	public Check(boolean color){
		this.color = color;
	}
	
	private void findKing(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board.getFromPosition(i, j).getpiece() instanceof King && board.getFromPosition(i, j).getpiece().color==color){
					king_x=i;
					king_y=j;
				}
					
				
			}
		}
	}
	
	private boolean checkRowAndCol(){//for rook and queen
		for(int i=king_x-1; i>-1;i--){
			Piece temp= board.getFromPosition(i, king_y).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Rook||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		for(int i=king_x+1; i<8; i++){
			Piece temp= board.getFromPosition(i, king_y).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Rook||temp instanceof Queen){
						return true;
					}
			}
			
		}
		for(int i=king_y-1; i>-1;i--){
			Piece temp= board.getFromPosition(king_x,i).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Rook||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		for(int i=king_y+1; i<8;i++){
			Piece temp= board.getFromPosition(king_x,i).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Rook||temp instanceof Queen){
						return true;
					}
			}
			
		}
		return false;
	}
	
	private boolean checkDiagonal(){//for bishop and queen 
		int x = king_x;
		int y = king_y;
		
		while(x<7 && y<7){//northEast
			x++;
			y++;
			Piece temp= board.getFromPosition(x, y).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Bishop||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		while(x>0 && y>0){//southWest
			x--;
			y--;
			Piece temp= board.getFromPosition(x, y).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Bishop||temp instanceof Queen){
						return true;
					}
			}
			
		}
			
		while(x>0 && y<7){//northWest
			x--;
			y++;
			Piece temp= board.getFromPosition(x, y).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Bishop||temp instanceof Queen){
						return true;
					}
			}
			
		}
		while(x<7 && y>0){//southEast
			x++;
			y--;
			Piece temp= board.getFromPosition(x, y).getpiece();
			if(temp!=null){
				if(temp.color==color)
					return false;
				else
					if(temp instanceof Bishop||temp instanceof Queen){
						return true;
					}
			}
			
		}
		return false;
	}
	
	private boolean checkKnight(){
		int x = king_x;
		int y = king_y;
		Piece temp;
		if(x+2<8){
			if(y+1<8){
				temp = board.getFromPosition(x+2, y+1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(y-1>-1){
				temp = board.getFromPosition(x+2, y-1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
		}
		
		if(x-2>-1){
			if(y+1<8){
				temp = board.getFromPosition(x+2, y+1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(y-1>-1){
				temp = board.getFromPosition(x+2, y-1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
		}
		
		if(y-2>-1){
			if(x+1<8){
				temp = board.getFromPosition(x+2, y+1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(x-1>-1){
				temp = board.getFromPosition(x+2, y-1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
		}
		
		if(y+2<8){
			if(x+1<8){
				temp = board.getFromPosition(x+2, y+1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(x-1>-1){
				temp = board.getFromPosition(x+2, y-1).getpiece();
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
		}
		return false;
	}
	
	private boolean checkPawn(){
		int x = king_x;
		int y = king_y;
		Piece temp1,temp2;
		if(color){
			temp1 = board.getFromPosition(x+1, y+1).getpiece();
			temp2 = board.getFromPosition(x-1, y+1).getpiece();
			if((temp1!=null && temp1 instanceof Pawn && temp1.color!=color) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.color!=color))
				return true;
			else
				return false;
		}
			
		else{
			temp1 = board.getFromPosition(x+1, y-1).getpiece();
			temp2 = board.getFromPosition(x-1, y-1).getpiece();
			if((temp1!=null && temp1 instanceof Pawn && temp1.color!=color) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.color!=color))
				return true;
			else
				return false;
		}
	}
	
	public boolean checkmate(){
		findKing();
		return checkRowAndCol() || checkDiagonal() || checkKnight() || checkPawn();
	}
	
}
