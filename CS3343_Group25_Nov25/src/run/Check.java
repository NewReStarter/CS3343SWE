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
				if(board.getPiece(i,j) instanceof King && board.getPiece(i,j).getColor()==color){
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
				if(temp.getColor()==color)
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
				if(temp.getColor()==color)
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
				if(temp.getColor()==color)
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
				if(temp.getColor()==color)
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
				if(temp.getColor()==color)
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
				if(temp.getColor()==color)
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
				if(temp.getColor()==color)
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
				if(temp.getColor()==color)
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
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
					return true;
			}
			if(y-1>-1){
				temp = board.getPiece(x+2, y-1);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
					return true;
			}
		}
		
		if(x-2>-1){
			if(y+1<8){
				temp = board.getPiece(x-2, y+1);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
					return true;
			}
			if(y-1>-1){
				temp = board.getPiece(x-2, y-1);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
					return true;
			}
		}
		
		if(y-2>-1){
			if(x+1<8){
				temp = board.getPiece(x+1, y-2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
					return true;
			}
			if(x-1>-1){
				temp = board.getPiece(x-1, y-2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
					return true;
			}
		}
		
		if(y+2<8){
			if(x+1<8){
				temp = board.getPiece(x+1, y+2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
					return true;
			}
			if(x-1>-1){
				temp = board.getPiece(x-1, y-2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=color)
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
			if((temp1!=null && temp1 instanceof Pawn && temp1.getColor()!=color) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.getColor()!=color))
				return true;
			else
				return false;
		}
			
		else{
			temp1 = board.getPiece(x-1, y+1);
			temp2 = board.getPiece(x-1, y-1);
			if((temp1!=null && temp1 instanceof Pawn && temp1.getColor()!=color) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.getColor()!=color))
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
		if(board.getPiece(x, y) !=null && board.getPiece(x, y).getColor()==this.color)
			return true;
		else
			return false;
	}
	
	public boolean checkOccupyByEn(int x,int y){
		if(board.getPiece(x, y) !=null && board.getPiece(x, y).getColor()==(!color))
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
	
	public boolean checkBishipBlock(int x,int y,int target_x,int target_y){

		if(x>target_x){
			if(y>target_y){
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board.getPiece(x-i, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board.getPiece(x-i, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else{
			if(y>target_y){
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board.getPiece(x+i, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board.getPiece(x+i, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			
		}
	
	}
	public boolean checkQueenBlock(int x,int y,int target_x,int target_y){

		if(Math.abs(x-target_x) == Math.abs(y-target_y)){
			if(x>target_x){
				if(y>target_y){
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=board.getPiece(x-i, y-i);
						if(piece!=null)
							return false;
					}
					return true;
				}
				else{
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=board.getPiece(x-i, y+i);
						if(piece!=null)
							return false;
					}
					return true;
				}
			}
			else{
				if(y>target_y){
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=board.getPiece(x+i, y-i);
						if(piece!=null)
							return false;
					}
					return true;
				}
				else{
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=board.getPiece(x+i, y+i);
						if(piece!=null)
							return false;
					}
					return true;
				}
				
			}
		
		}
		else if(target_x == x && target_y != y){
			if(target_y>y){
				for(int i=1;i<target_y-y;i++){
					Piece piece=board.getPiece(x, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<y-target_y;i++){
					Piece piece=board.getPiece(x, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else if(target_y == y && target_x != x){
			if(target_x>x){
				for(int i=1;i<target_x-x;i++){
					Piece piece=board.getPiece(x+i, y);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<x-target_x;i++){
					Piece piece=board.getPiece(x-i, y);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else
			return false;
	
	}
	public boolean checkRookBlock(int x,int y,int target_x,int target_y){
		if(target_x == x && target_y != y){
			if(target_y>y){
				for(int i=1;i<target_y-y;i++){
					Piece piece=board.getPiece(x, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<y-target_y;i++){
					Piece piece=board.getPiece(x, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else if(target_y == y && target_x != x){
			if(target_x>x){
				for(int i=1;i<target_x-x;i++){
					Piece piece=board.getPiece(x+i, y);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<x-target_x;i++){
					Piece piece=board.getPiece(x-i, y);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else
			return false;
	
	}
	public boolean checkPawnPassant(int x,int y,int target_x,int target_y){

		if(board.getPiece(target_x, target_y).getColor()){
			if(x==4){
				if(target_x-x==1&&Math.abs(target_y-y)==1){
					Piece piece=board.getPiece(x,target_y);
					if(piece!=null)
						if(piece instanceof Pawn&&((Pawn) piece).getIsPassant()){
							return true;
					}
				}
			}
		}
		else{
			if(x==3){
				if(target_x-x==-1&&Math.abs(target_y-y)==1){
					Piece piece=board.getPiece(x,target_y);
					if(piece!=null)
						if(piece instanceof Pawn&&((Pawn) piece).getIsPassant()){
							return true;
					}
				}
			}
		}
		return false;
	
	}
	public boolean checkPawnEat(int x,int y,int target_x,int target_y){
		if(board.getPiece(target_x, target_y).getColor()){
			if(target_x-x==1&&Math.abs(target_y-y)==1){
				Piece piece=board.getPiece(target_x, target_y);
				if(piece!=null)
					return true;
			}
		}
		else
		{
			if(target_x-x==-1&&Math.abs(target_y-y)==1){
				Piece piece=board.getPiece(target_x, target_y);
				if(piece!=null)
					return true;
			}
		}
		return false;
	}
	
	public boolean checkPawnNormalmove(int x,int y,int target_x,int target_y){
		Piece pawn=board.getPiece(x, y);
		if(board.getPiece(x, y).getColor()){
			if(((Pawn) pawn).getIfFirstMove()){
				if(target_x-x==1&&y==target_y){
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
				else if(target_x-x==2&&y==target_y){
					Piece piece1=board.getPiece(x+1, y);
					Piece piece2=board.getPiece(target_x, target_y);
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else{
				if(target_x-x==1&&y==target_y){
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
			}
		}
		else{
			if(((Pawn) pawn).getIfFirstMove()){
				if(target_x-x==-1&&y==target_y){
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
				else if(target_x-x==-2&&y==target_y){
					Piece piece1=board.getPiece(x-1, y);
					Piece piece2=board.getPiece(target_x, target_y);
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else{
				if(target_x-x==-1&&y==target_y){
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
			}
		}
		return false;
	}
}
