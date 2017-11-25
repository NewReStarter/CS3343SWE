package piece;

import java.util.Scanner;

import chess.ChessBoard;

public class Pawn extends Piece{

	private boolean ifFirstMove;
	private boolean isPassant;
	ChessBoard chessboard=ChessBoard.getInstance();
	
	public Pawn(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		ifFirstMove = true;
		isPassant = false;
	}
	
	public boolean atBoundary(int x,int y){
			if(this.color)
				if(x == 7)
					return true;
			else
				if(x == 0)
					return true;
			return false;	
		}
	public boolean passant(int x,int y,int target_x,int target_y){
		if(this.color){
			if(x==4){
				if(target_x-x==1&&Math.abs(target_y-y)==1){
					Piece piece=chessboard.getPiece(x,target_y);
					if(piece!=null)
						if(piece instanceof Pawn&&((Pawn) piece).bepassant()){
							return true;
					}
				}
			}
		}
		else{
			if(x==3){
				if(target_x-x==-1&&Math.abs(target_y-y)==1){
					Piece piece=chessboard.getPiece(x,target_y);
					if(piece!=null)
						if(piece instanceof Pawn&&((Pawn) piece).bepassant()){
							return true;
					}
				}
			}
		}
		return false;
	}
	public boolean eat(int x,int y,int target_x,int target_y){
		if(this.color){
			if(target_x-x==1&&Math.abs(target_y-y)==1){
				Piece piece=chessboard.getPiece(target_x, target_y);
				if(piece!=null)
					return true;
			}
		}
		else
		{
			if(target_x-x==-1&&Math.abs(target_y-y)==1){
				Piece piece=chessboard.getPiece(target_x, target_y);
				if(piece!=null)
					return true;
			}
		}
		return false;
	}
	public boolean normalmove(int x,int y,int target_x,int target_y){
		if(this.color){
			if(ifFirstMove){
				if(target_x-x==1&&y==target_y){
					Piece piece=chessboard.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
				else if(target_x-x==2&&y==target_y){
					Piece piece1=chessboard.getPiece(x+1, y);
					Piece piece2=chessboard.getPiece(target_x, target_y);
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else{
				if(target_x-x==1&&y==target_y){
					Piece piece=chessboard.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
			}
		}
		else{
			if(ifFirstMove){
				if(target_x-x==-1&&y==target_y){
					Piece piece=chessboard.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
				else if(target_x-x==-2&&y==target_y){
					Piece piece1=chessboard.getPiece(x-1, y);
					Piece piece2=chessboard.getPiece(target_x, target_y);
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else{
				if(target_x-x==-1&&y==target_y){
					Piece piece=chessboard.getPiece(target_x, target_y);
					if(piece==null)
						return true;
				}
			}
		}
		return false;
	}
	public boolean bepassant(){
		return isPassant;
	}
	public void move(int x,int y,int target_x,int target_y){
		if(normalmove(x,y,target_x,target_y)){
			chessboard.initialize(target_x, target_y, chessboard.getPiece(x, y));
			chessboard.initialize(x, y, null);
			if(ifFirstMove&&Math.abs(target_x-x)==2){
				isPassant=true;
			}
			if(ifFirstMove==false)
				isPassant=false;
			ifFirstMove=false;
			
			if(this.color){
				if(target_x==7){
					System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
					Scanner in = new Scanner(System.in);
					int role=in.nextInt();
					in.close();
					switch (role){
					case 1:
						chessboard.initialize(target_x, target_y, new Knight(this.color,"1",target_x,target_y));
						break;
					case 2:
						chessboard.initialize(target_x, target_y, new Bishop(this.color,"1",target_x,target_y));
						break;
					case 3:
						chessboard.initialize(target_x, target_y, new Rook(this.color,"1",target_x,target_y));
						break;
					case 4:
						chessboard.initialize(target_x, target_y, new Queen(this.color,"1",target_x,target_y));
						break;
					}
				}
			}
			else{
				if(target_x==0){
					System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
					Scanner in = new Scanner(System.in);
					int role=in.nextInt();
					in.close();
					switch (role){
					case 1:
						chessboard.initialize(target_x, target_y, new Knight(this.color,"1",target_x,target_y));
						break;
					case 2:
						chessboard.initialize(target_x, target_y, new Bishop(this.color,"1",target_x,target_y));
						break;
					case 3:
						chessboard.initialize(target_x, target_y, new Rook(this.color,"1",target_x,target_y));
						break;
					case 4:
						chessboard.initialize(target_x, target_y, new Queen(this.color,"1",target_x,target_y));
						break;
					}
				}
			}
		}
		else if(eat(x,y,target_x,target_y)){
			chessboard.initialize(target_x, target_y, chessboard.getPiece(x, y));
			chessboard.initialize(x, y, null);
			ifFirstMove=false;
			if(this.color){
				if(target_x==7){
					System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
					Scanner in = new Scanner(System.in);
					int role=in.nextInt();
					in.close();
					switch (role){
					case 1:
						chessboard.initialize(target_x, target_y, new Knight(this.color,"1",target_x,target_y));
						break;
					case 2:
						chessboard.initialize(target_x, target_y, new Bishop(this.color,"1",target_x,target_y));
						break;
					case 3:
						chessboard.initialize(target_x, target_y, new Rook(this.color,"1",target_x,target_y));
						break;
					case 4:
						chessboard.initialize(target_x, target_y, new Queen(this.color,"1",target_x,target_y));
						break;
					}
				}
			}
			else{
				if(target_x==0){
					System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
					Scanner in = new Scanner(System.in);
					int role=in.nextInt();
					in.close();
					switch (role){
					case 1:
						chessboard.initialize(target_x, target_y, new Knight(this.color,"1",target_x,target_y));
						break;
					case 2:
						chessboard.initialize(target_x, target_y, new Bishop(this.color,"1",target_x,target_y));
						break;
					case 3:
						chessboard.initialize(target_x, target_y, new Rook(this.color,"1",target_x,target_y,true));
						break;
					case 4:
						chessboard.initialize(target_x, target_y, new Queen(this.color,"1",target_x,target_y));
						break;
					}
				}
			}
		}
		else if(passant(x,y,target_x,target_y)){
			chessboard.initialize(target_x, target_y, chessboard.getPiece(x, y));
			chessboard.initialize(x, target_y, null);
			chessboard.initialize(x, y, null);
		}
		else{
			System.out.println("Invalid move");
		}
	}

	public String returnName(){
		return "Pawn";
	}

	
}
