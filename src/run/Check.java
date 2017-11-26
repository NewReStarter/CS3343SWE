package run;

import java.util.Scanner;

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
	private boolean turn = true;
	private boolean castling = false;
	
	public void changeTurn()
	{
		turn = !turn;
	}
	
	public boolean getTurn()
	{
		return turn;
	}
	
	public Check()
	{
		findKing(turn);
	}
	
	private void findKing(boolean color)
	{
		king_x = -1;
		king_y = -1;
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(!(board.getPiece(i,j)==null))
				{
					if(board.getPiece(i,j) instanceof King && board.getPiece(i,j).getColor()==color)
					{
						king_x=i;
						king_y=j;
					}
				}
			}
		}
	}
	
	public boolean ifCheckMate()
	{
		if(king_x == -1)
			return true;
		return false;
	}
	
	private boolean checkRowAndCol()
	{//for rook and queen
		for(int i=king_x-1; i>-1;i--)
		{
			Piece temp= board.getPiece(i, king_y);
			if(temp!=null)
			{
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Rook||temp instanceof Queen)
					{
						return true;
					}
				}
			}
		}
		
		for(int i=king_x+1; i<8; i++){
			Piece temp= board.getPiece(i, king_y);
			if(temp!=null){
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Rook||temp instanceof Queen)
					{
						return true;
					}
				}
			}
			
		}
		for(int i=king_y-1; i>-1;i--)
		{
			Piece temp= board.getPiece(king_x,i);
			if(temp!=null)
			{
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Rook||temp instanceof Queen)
					{
						return true;
					}
				}
			}
			
		}
		
		for(int i=king_y+1; i<8;i++)
		{
			Piece temp= board.getPiece(king_x,i);
			if(temp!=null)
			{
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Rook||temp instanceof Queen)
					{
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	private boolean checkDiagonal(){//for bishop and queen 
		int x = king_x;
		int y = king_y;
		
		while(x<7 && y<7)
		{//northEast
			x++;
			y++;
			Piece temp= board.getPiece(x, y);
			if(temp!=null){
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Bishop||temp instanceof Queen)
					{
						return true;
					}
				}
			}
		}
		
		while(x>0 && y>0){//southWest
			x--;
			y--;
			Piece temp= board.getPiece(x, y);
			if(temp!=null)
			{
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Bishop||temp instanceof Queen)
					{
						return true;
					}
				}
			}
		}
			
		while(x>0 && y<7)
		{//northWest
			x--;
			y++;
			Piece temp= board.getPiece(x, y);
			if(temp!=null){
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Bishop||temp instanceof Queen)
					{
						return true;
					}
				}
			}
		}
		
		while(x<7 && y>0)
		{//southEast
			x++;
			y--;
			Piece temp= board.getPiece(x, y);
			if(temp!=null)
			{
				if(temp.getColor()==turn)
					return false;
				else
				{
					if(temp instanceof Bishop||temp instanceof Queen)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean checkKnight(){
		int x = king_x;
		int y = king_y;
		Piece temp;
		if(x+2<8)
		{
			if(y+1<8)
			{
				temp = board.getPiece(x+2, y+1);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(y-1>-1)
			{
				temp = board.getPiece(x+2, y-1);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
		}
		
		if(x-2>-1)
		{
			if(y+1<8)
			{
				temp = board.getPiece(x-2, y+1);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(y-1>-1)
			{
				temp = board.getPiece(x-2, y-1);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
		}
		
		if(y-2>-1)
		{
			if(x+1<8)
			{
				temp = board.getPiece(x+1, y-2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(x-1>-1)
			{
				temp = board.getPiece(x-1, y-2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
		}
		
		if(y+2<8)
		{
			if(x+1<8)
			{
				temp = board.getPiece(x+1, y+2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(x-1>-1)
			{
				temp = board.getPiece(x-1, y-2);
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
		}
		return false;
	}
	
	private boolean checkPawn(){
		int x = king_x;
		int y = king_y;
		Piece temp1,temp2;
		
		if(turn)
		{
			temp1 = board.getPiece(x+1, y+1);
			temp2 = board.getPiece(x+1, y-1);
			if((temp1!=null && temp1 instanceof Pawn && temp1.getColor()!=turn) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.getColor()!=turn))
				return true;
			else
				return false;
		}
		else{
			temp1 = board.getPiece(x-1, y+1);
			temp2 = board.getPiece(x-1, y-1);
			if((temp1!=null && temp1 instanceof Pawn && temp1.getColor()!=turn) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.getColor()!=turn))
				return true;
			else
				return false;
		}
	}
	
	public boolean isCheck()
	{
		return checkRowAndCol() || checkDiagonal() || checkKnight() || checkPawn();
	}
	
	public boolean checkmate(){
		findKing(turn);
		return isCheck();
	}
	
	public boolean checkOccupyByUs(int x,int y)
	{
		if(board.getPiece(x, y) !=null && board.getPiece(x, y).getColor()==turn)
			return true;
		else
			return false;
	}
	
	public boolean checkOccupyByEn(int x,int y){
		if(board.getPiece(x, y) !=null && board.getPiece(x, y).getColor()==(!turn))
			return true;
		else
			return false;
	}

	public boolean checkLongCastling(){
		if(turn)
		{
			Piece rook= board.getPiece(0, 0);
			if(rook==null||!(rook instanceof Rook))
				return false;
			if(((Rook) rook).ischange())
				return false;
			King king= (King) board.getPiece(king_x, king_y);
			if((!((Rook) rook).isFirst())&&(!king.isFirst()))
				return false;
			for(int x=1;x<4;x++)
			{
				Piece piece=board.getPiece(0, x);
				if(piece!=null)
					return false;
			}
			int copy_y=king_y;
			do
			{
				if(isCheck())
				{
					king_y=copy_y;
					return false;
				}
				king_y--;
			} while(king_y>=2);
			king_y=copy_y;
			return true;
		}
		else
		{
			Piece rook= board.getPiece(7, 0);
			if(rook==null||(!(rook instanceof Rook)))
				return false;
			if(((Rook) rook).ischange())
				return false;
			King king= (King) board.getPiece(king_x, king_y);
			if((!((Rook) rook).isFirst())&&(!king.isFirst()))
				return false;
			for(int x=1;x<4;x++)
			{
				Piece piece=board.getPiece(7, x);
				if(piece!=null)
					return false;
			}
			int copy_y=king_y;
			do
			{
				if(isCheck())
				{
					king_y=copy_y;
					return false;
				}
				king_y--;
			} while(king_y>=2);
			king_y=copy_y;
			return true;
		}
	}
	
	public boolean checkShortCastling()
	{
		if(turn)
		{
			Piece rook= board.getPiece(0, 7);
			if(rook==null||(!(rook instanceof Rook)))
				return false;
			if(((Rook) rook).ischange())
				return false;
			King king= (King) board.getPiece(king_x, king_y);
			if((!((Rook) rook).isFirst())&&(!king.isFirst()))
				return false;
			for(int x=5;x<7;x++)
			{
				Piece piece=board.getPiece(0, x);
				if(piece!=null)
					return false;
			}
			int copy_y=king_y;
			do
			{
				if(isCheck()){
					king_y=copy_y;
					return false;
				}
				king_y++;
			} while(king_y<=6);
			king_y=copy_y;
			return true;
		}
		else{
			Piece rook= board.getPiece(7, 7);
			if(rook==null||(!(rook instanceof Rook)))
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
				if(isCheck()){
					king_y=copy_y;
					return false;
				}
				king_y++;
			}while(king_y<=6);
			king_y=copy_y;
			return true;
		}
	}
	
	public boolean checkBishipBlock(int x,int y,int target_x,int target_y)
	{
		if(x>target_x)
		{
			if(y>target_y)
			{
				for(int i=1;i<Math.abs(x-target_x);i++)
				{
					Piece piece=board.getPiece(x-i, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else
			{
				for(int i=1;i<Math.abs(x-target_x);i++)
				{
					Piece piece=board.getPiece(x-i, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else
		{
			if(y>target_y)
			{
				for(int i=1;i<Math.abs(x-target_x);i++)
				{
					Piece piece=board.getPiece(x+i, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else
			{
				for(int i=1;i<Math.abs(x-target_x);i++)
				{
					Piece piece=board.getPiece(x+i, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
	}
	
	public boolean checkRookBlock(int x,int y,int target_x,int target_y)
	{
		if(target_x == x && target_y != y)
		{
			if(target_y>y)
			{
				for(int i=1;i<target_y-y;i++)
				{
					Piece piece=board.getPiece(x, y+i);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else
			{
				for(int i=1;i<y-target_y;i++)
				{
					Piece piece=board.getPiece(x, y-i);
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else if(target_y == y && target_x != x)
		{
			if(target_x>x)
			{
				for(int i=1;i<target_x-x;i++)
				{
					Piece piece=board.getPiece(x+i, y);
					if(piece!=null)
						return false;
				}
				return true;
			}
			else
			{
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
	
	public boolean checkQueenBlock(int x,int y,int target_x,int target_y)
	{
		if(Math.abs(x-target_x) == Math.abs(y-target_y))
			return checkBishipBlock(x, y, target_x, target_y);
		else if((target_x == x && target_y != y) || (target_y == y && target_x != x))
			return checkRookBlock(x, y, target_x, target_y);
		else
			return false;
	}

	
	public boolean checkPawnPassant(int x,int y,int target_x,int target_y)
	{
		if(board.getPiece(target_x, target_y).getColor())
		{
			if(x==4)
			{
				if(target_x-x==1&&Math.abs(target_y-y)==1)
				{
					Piece piece=board.getPiece(x,target_y);
					if(piece!=null)
					{
						if(piece instanceof Pawn && ((Pawn) piece).getIsPassant())
							return true;
					}
				}
			}
		}
		else
		{
			if(x==3)
			{
				if(target_x-x==-1&&Math.abs(target_y-y)==1)
				{
					Piece piece=board.getPiece(x,target_y);
					if(piece!=null)
					{
						if(piece instanceof Pawn&&((Pawn) piece).getIsPassant())
							return true;
					}
				}
			}
		}
		return false;
	
	}
	public boolean checkPawnEat(int x,int y,int target_x,int target_y){
		if(board.getPiece(target_x, target_y).getColor())
		{
			if(target_x-x==1&&Math.abs(target_y-y)==1)
			{
				Piece piece=board.getPiece(target_x, target_y);
				if(piece!=null)
					return true;
			}
		}
		else
		{
			if(target_x-x==-1&&Math.abs(target_y-y)==1)
			{
				Piece piece=board.getPiece(target_x, target_y);
				if(piece!=null)
					return true;
			}
		}
		return false;
	}
	
	public boolean checkPawnToChange(int target_x, int target_y)
	{
		if(board.getPiece(target_x, target_y).getColor())
		{
			if(target_x==7)
				return true;
		}
		else
		{
			if(target_x==0)
				return true;
		}
		return false;
	}
	
	public boolean checkPawnNormalmove(int x,int y,int target_x,int target_y)
	{
		Piece pawn=board.getPiece(x, y);
		if(board.getPiece(x, y).getColor())
		{
			if(((Pawn) pawn).getIfFirstMove())
			{
				if(target_x-x==1&&y==target_y)
				{
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
				else if(target_x-x==2&&y==target_y)
				{
					Piece piece1=board.getPiece(x+1, y);
					Piece piece2=board.getPiece(target_x, target_y);
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else
			{
				if(target_x-x==1&&y==target_y){
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
			}
		}
		else
		{
			if(((Pawn) pawn).getIfFirstMove())
			{
				if(target_x-x==-1&&y==target_y)
				{
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
				else if(target_x-x==-2&&y==target_y)
				{
					Piece piece1=board.getPiece(x-1, y);
					Piece piece2=board.getPiece(target_x, target_y);
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else
			{
				if(target_x-x==-1&&y==target_y){
					Piece piece=board.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkTheMoveIsVaild(int x,int y,int target_x,int target_y)
	{
		if(checkmate())
		{
			System.out.println("Your king is in check!");
			return false;
		}
		
		Piece p = board.getPiece(x,y);
		
		if(p==null)
		{
			System.out.println("No piece at that position");
			return false;
		}
		if(p.getColor()!=turn){
			System.out.println("This is not your piece");
			return false;
		}
		
		if(checkOccupyByUs(target_x, target_y))
		{
			System.out.println("It is already occupied by your piece");
			return false;
		}
		
		if(p instanceof Bishop) 
		{
			if(p.isValid(x, y,target_x,target_y) && checkBishipBlock(x, y, target_x, target_y))
				return true;
			else
			{
				System.out.println("Invalid Move");
				return false;
			}
		}
		else if(p instanceof King) 
		{
			if(p.isValid(x,y,target_x,target_y))
				return true;
			else
			{
				System.out.println("Invalid Move");
				return false;
			}
		}
		else if (p instanceof Knight)
		{
			if(p.isValid(x,y,target_x,target_y))
				return true;
			else
			{
				System.out.println("Invalid move");
				return false;
			}
		}
		else if(p instanceof Queen)
		{
			if(p.isValid(x,y,target_x,target_y) && checkQueenBlock(x, y, target_x, target_y))
				return true;
			else
			{
				System.out.println("Invalid move");
				return false;
			}
		}
		else if(p instanceof Rook)
		{
			if(p.isValid(x,y,target_x,target_y) && checkRookBlock(x, y, target_x, target_y))
				return true;
			else
			{
				System.out.println("Invalid Move");	
				return false;
			}
		}
		else if(p instanceof Pawn) {
			if(checkPawnNormalmove(x, y, target_x, target_y))
				return true;
			else if(checkPawnEat(x, y, target_x, target_y))
				return true;
			else if(checkPawnPassant(x,y,target_x,target_y))
				return true;
			else
			{
				System.out.println("Invalid move");
				return false;
			}
		}
		return false;
	}

}
