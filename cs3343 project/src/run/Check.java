package run;

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
		findKing();
	}
	
	private void findKing(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(!(board.getPiece(i,j)==null)){
				if(board.getPiece(i,j) instanceof King && board.getPiece(i,j).color==color){
					king_x=i;
					king_y=j;
				}
				}
			}
		}
	}
	
	private boolean checkRowAndCol(){//for rook and queen
		for(int i=king_x-1; i>-1;i--){
			Piece temp= board.getPiece(i, king_y);
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
			Piece temp= board.getPiece(i, king_y);
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
			Piece temp= board.getPiece(king_x,i);
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
			Piece temp= board.getPiece(king_x,i);
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
			Piece temp= board.getPiece(x, y);
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
			Piece temp= board.getPiece(x, y);
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
			Piece temp= board.getPiece(x, y);
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
			Piece temp= board.getPiece(x, y);
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
				temp = board.getPiece(x+2, y+1);
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(y-1>-1){
				temp = board.getPiece(x+2, y-1);
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
		}
		
		if(x-2>-1){
			if(y+1<8){
				temp = board.getPiece(x+2, y+1);
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(y-1>-1){
				temp = board.getPiece(x+2, y-1);
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
		}
		
		if(y-2>-1){
			if(x+1<8){
				temp = board.getPiece(x+2, y+1);
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(x-1>-1){
				temp = board.getPiece(x+2, y-1);
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
		}
		
		if(y+2<8){
			if(x+1<8){
				temp = board.getPiece(x+2, y+1);
				if(temp!=null && temp instanceof Knight && temp.color!=color)
					return true;
			}
			if(x-1>-1){
				temp = board.getPiece(x+2, y-1);
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
			temp1 = board.getPiece(x+1, y+1);
			temp2 = board.getPiece(x+1, y-1);
			if((temp1!=null && temp1 instanceof Pawn && temp1.color!=color) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.color!=color))
				return true;
			else
				return false;
		}
			
		else{
			temp1 = board.getPiece(x-1, y+1);
			temp2 = board.getPiece(x-1, y-1);
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
	public boolean checkMate(){
		return checkRowAndCol() || checkDiagonal() || checkKnight() || checkPawn();
	}
	public boolean checkOccupyByUs(int x,int y){
		if(board.getPiece(x, y) !=null && board.getPiece(x, y).color==this.color)
			return true;
		else
			return false;
	}
	public boolean checkOccupyByEn(int x,int y){
		if(board.getPiece(x, y) !=null && board.getPiece(x, y).color==(!color))
			return true;
		else
			return false;
	}

	public boolean checkLongCastling(){
		if(this.color){
			Piece rook= board.getPiece(0, 0);
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).ischange())
				return false;
			King king= (King) board.getPiece(king_x, king_y);
			if((!((Rook) rook).isFirst())&&(!king.isFirst()))
				return false;
			for(int x=1;x<4;x++){
				Piece piece=board.getPiece(0, x);
				if(piece!=null)
					return false;
			}
			int copy_y=king_y;
			do{
				if(checkMate()){
					king_y=copy_y;
					return false;
				}
				king_y--;
			}while(king_y>=2);
			king_y=copy_y;
			return true;
		}
		else{
			Piece rook= board.getPiece(7, 0);
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).ischange())
				return false;
			King king= (King) board.getPiece(king_x, king_y);
			if((!((Rook) rook).isFirst())&&(!king.isFirst()))
				return false;
			for(int x=1;x<4;x++){
				Piece piece=board.getPiece(7, x);
				if(piece!=null)
					return false;
			}
			int copy_y=king_y;
			do{
				if(checkMate()){
					king_y=copy_y;
					return false;
				}
				king_y--;
			}while(king_y>=2);
			king_y=copy_y;
			return true;
		}
	}
	public boolean checkShortCastling(){

		if(this.color){
			Piece rook= board.getPiece(0, 7);
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).ischange())
				return false;
			King king= (King) board.getPiece(king_x, king_y);
			if((!((Rook) rook).isFirst())&&(!king.isFirst()))
				return false;
			for(int x=5;x<7;x++){
				Piece piece=board.getPiece(0, x);
				if(piece!=null)
					return false;
			}
			int copy_y=king_y;
			do{
				if(checkMate()){
					king_y=copy_y;
					return false;
				}
				king_y++;
			}while(king_y<=6);
			king_y=copy_y;
			return true;
		}
		else{
			Piece rook= board.getPiece(7, 7);
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).ischange())
				return false;
			King king= (King) board.getPiece(king_x, king_y);
			if((!((Rook) rook).isFirst())&&(!king.isFirst()))
				return false;
			for(int x=5;x<7;x++){
				Piece piece=board.getPiece(7, x);
				if(piece!=null)
					return false;
			}
			int copy_y=king_y;
			do{
				if(checkMate()){
					king_y=copy_y;
					return false;
				}
				king_y++;
			}while(king_y<=6);
			king_y=copy_y;
			return true;
		}

	}
		
	
}
