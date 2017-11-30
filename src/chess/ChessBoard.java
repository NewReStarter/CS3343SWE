package chess;

import java.util.Scanner;

import piece.*;
import run.Command;

public class ChessBoard 
{
	private Piece[][] board;
	 
	private static ChessBoard theChessBoard = new ChessBoard();
	private static boolean turn = true;
	private static boolean castling = false;
	private int king_x,king_y;
	public ChessBoard()
	{
		board = new Piece[8][8];
		for(int i=0;i<8;i++){
			for(int k=0;k<8;k++){
				board[i][k]=null;
			}
		}
	}

	public void changeTurn(){
		findKing();
		turn = !turn;
	}
	public void clearChessBoard() {
		turn =true;
		//board = new Piece[8][8];
		for(int i=0;i<8;i++){
			for(int k=0;k<8;k++){
				board[i][k]=null;
			}
		}
	}
	
	public void initialize(int x, int y, Piece p)
	{
		board[x][y] = p;
	}
	
	public void initializeEntireBoard() {
		clearChessBoard();
		this.initialize(0,0,new Rook(true, "1"));
    	this.initialize(0,1,new Knight(true, "1"));
    	this.initialize(0,2,new Bishop(true, "1"));
    	this.initialize(0,3,new Queen(true, "1"));
    	this.initialize(0,4,new King(true, "1"));
    	this.initialize(0,5,new Bishop(true, "1"));
    	this.initialize(0,6,new Knight(true, "1"));
    	this.initialize(0,7,new Rook(true, "1"));
    	this.initialize(1,0,new Pawn(true, "1"));
    	this.initialize(1,1,new Pawn(true, "1"));
    	this.initialize(1,2,new Pawn(true, "1"));
    	this.initialize(1,3,new Pawn(true, "1"));
    	this.initialize(1,4,new Pawn(true, "1"));
    	this.initialize(1,5,new Pawn(true, "1"));
    	this.initialize(1,6,new Pawn(true, "1"));
    	this.initialize(1,7,new Pawn(true, "1"));
    	
    	this.initialize(7,0,new Rook(false, "2"));
    	this.initialize(7,1,new Knight(false, "2"));
    	this.initialize(7,2,new Bishop(false, "2"));
    	this.initialize(7,3,new Queen(false, "2"));
    	this.initialize(7,4,new King(false, "2"));
    	this.initialize(7,5,new Bishop(false, "2"));
    	this.initialize(7,6,new Knight(false, "2"));
    	this.initialize(7,7,new Rook(false, "2"));
    	this.initialize(6,0,new Pawn(false, "2"));
    	this.initialize(6,1,new Pawn(false, "2"));
    	this.initialize(6,2,new Pawn(false, "2"));
    	this.initialize(6,3,new Pawn(false, "2"));
    	this.initialize(6,4,new Pawn(false, "2"));
    	this.initialize(6,5,new Pawn(false, "2"));
    	this.initialize(6,6,new Pawn(false, "2"));
    	this.initialize(6,7,new Pawn(false, "2"));
	}

	public static ChessBoard getInstance() {
		
		return theChessBoard;
	}
	//addition function
	public Piece getPiece(int x,int y){
		return board[x][y];
	}
	
	public boolean checkLongCastling(){
		if(turn){
			Piece rook= board[0][0];
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).getIsChange())
				return false;
			King king= (King) board[king_x][king_y];
			if((!((Rook) rook).getIsFirst())&&(!king.isFirst()))
				return false;
			for(int x=1;x<4;x++){
				Piece piece=board[0][x];
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
			Piece rook= board[7][0];
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).getIsChange())
				return false;
			King king= (King) board[king_x][king_y];
			if((!((Rook) rook).getIsFirst())&&(!king.isFirst()))
				return false;
			for(int x=1;x<4;x++){
				Piece piece=board[7][x];
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

		if(this.turn){
			Piece rook= board[0][7];
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).getIsChange())
				return false;
			King king= (King) board[king_x][king_y];
			if((!((Rook) rook).getIsFirst())&&(!king.isFirst()))
				return false;
			for(int x=5;x<7;x++){
				Piece piece=board[0][x];
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
			Piece rook= board[7][7];
			if(rook==null||rook instanceof Rook)
				return false;
			if(((Rook) rook).getIsChange())
				return false;
			King king= (King) board[king_x][king_y];
			if((!((Rook) rook).getIsFirst())&&(!king.isFirst()))
				return false;
			for(int x=5;x<7;x++){
				Piece piece=board[7][x];
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
	public boolean inBoundary(int x,int y,int target_x,int target_y){
		if(x>7 || y>7 || x<0 || y<0){
			System.out.print(" Position out of board.");
			return false;
		}
		if(target_x >7 || target_y >7 || target_x <0 || target_y <0){
			System.out.print(" Target position out of board.");
			return false;
		}
		return true;
		
	}
	
	private void findKing(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(!(board[i][j]==null)){
				if(board[i][j] instanceof King && board[i][j].getColor()==turn){
					king_x=i;
					king_y=j;
				}
				}
			}
		}
	}
	private boolean checkRowAndCol(){//for rook and queen
		for(int i=king_x-1; i>-1;i--){
			Piece temp= board[i][king_y];
			if(temp!=null){
				if(temp.getColor()==turn)
					return false;
				else
					if(temp instanceof Rook||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		for(int i=king_x+1; i<8; i++){
			Piece temp= board[i][king_y];
			if(temp!=null){
				if(temp.getColor()==turn)
					return false;
				else
					if(temp instanceof Rook||temp instanceof Queen){
						return true;
					}
			}
			
		}
		for(int i=king_y-1; i>-1;i--){
			Piece temp= board[king_x][i];
			if(temp!=null){
				if(temp.getColor()==turn)
					return false;
				else
					if(temp instanceof Rook||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		for(int i=king_y+1; i<8;i++){
			Piece temp= board[king_x][i];
			if(temp!=null){
				if(temp.getColor()==turn)
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
		
		while(x<7 && y<7){//southeast
			x++;
			y++;
			Piece temp= board[x][y];
			if(temp!=null){
				if(temp.getColor()==turn)
					break;
				else
					if(temp instanceof Bishop||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		x = king_x;
		y = king_y;
		
		while(x>0 && y>0){ //northWest
			x--;
			y--;
			Piece temp= board[x][y];
			if(temp!=null){
				if(temp.getColor()==turn)
					break;
				else
					if(temp instanceof Bishop||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		x = king_x;
		y = king_y;
			
		while(x>0 && y<7){//northEast
			x--;
			y++;
			Piece temp= board[x][y];
			if(temp!=null){
				if(temp.getColor()==turn)
					break;
				else
					if(temp instanceof Bishop||temp instanceof Queen){
						return true;
					}
			}
			
		}
		
		x = king_x;
		y = king_y;
		
		while(x<7 && y>0){//southwest
			x++;
			y--;
			Piece temp= board[x][y];
			if(temp!=null){
				if(temp.getColor()==turn)
					break;
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
				temp = board[x+2][y+1];
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(y-1>-1){
				temp = board[x+2][y-1];
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
		}
		
		if(x-2>-1){
			if(y+1<8){
				temp = board[x-2][y+1];
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(y-1>-1){
				temp = board[x-2][y-1];
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
		}
		
		if(y-2>-1){
			if(x+1<8){
				temp = board[x+1][y-2];
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(x-1>-1){
				temp = board[x-1][y-2];
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
		}
		
		if(y+2<8){
			if(x+1<8){
				temp = board[x+1][y+2];
				if(temp!=null && temp instanceof Knight && temp.getColor()!=turn)
					return true;
			}
			if(x-1>-1){
				temp = board[x-1][y+2];
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
		if(turn){
			temp1 = board[x+1][y+1];
			temp2 = board[x+1][y-1];
			if((temp1!=null && temp1 instanceof Pawn && temp1.getColor()!=turn) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.getColor()!=turn))
				return true;
			else
				return false;
		}
			
		else{
			temp1 = board[x-1][y+1];
			temp2 = board[x-1][y-1];
			if((temp1!=null && temp1 instanceof Pawn && temp1.getColor()!=turn) ||
					(temp2!=null && temp2 instanceof Pawn && temp2.getColor()!=turn))
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
		if(board[x][y] !=null && board[x][y].getColor()==turn)
			return true;
		else
			return false;
	}
	
	public boolean checkOccupyByEn(int x,int y){
		if(board[x][y] !=null && board[x][y].getColor()==(!turn))
			return true;
		else
			return false;
	}public boolean checkBishipBlock(int x,int y,int target_x,int target_y){

		if(x>target_x){
			if(y>target_y){
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board[x-i][y-i];
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board[x-i][y+i];
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else{
			if(y>target_y){
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board[x+i][y-i];
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<Math.abs(x-target_x);i++){
					Piece piece=board[x+i][y+i];
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
						Piece piece=board[x-i][y-i];
						if(piece!=null)
							return false;
					}
					return true;
				}
				else{
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=board[x-i][y+i];
						if(piece!=null)
							return false;
					}
					return true;
				}
			}
			else{
				if(y>target_y){
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=board[x+i][y-i];
						if(piece!=null)
							return false;
					}
					return true;
				}
				else{
					for(int i=1;i<Math.abs(x-target_x);i++){
						Piece piece=board[x+i][y+i];
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
					Piece piece=board[x][y+i];
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<y-target_y;i++){
					Piece piece=board[x][y-i];
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else if(target_y == y && target_x != x){
			if(target_x>x){
				for(int i=1;i<target_x-x;i++){
					Piece piece=board[x+i][y];
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<x-target_x;i++){
					Piece piece=board[x-i][y];
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
					Piece piece=board[x][y+i];
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<y-target_y;i++){
					Piece piece=board[x][y-i];
					if(piece!=null)
						return false;
				}
				return true;
			}
		}
		else if(target_y == y && target_x != x){
			if(target_x>x){
				for(int i=1;i<target_x-x;i++){
					Piece piece=board[x+i][y];
					if(piece!=null)
						return false;
				}
				return true;
			}
			else{
				for(int i=1;i<x-target_x;i++){
					Piece piece=board[x-i][y];
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

		if(board[x][y].getColor()){
			if(x==4){
				if(target_x-x==1&&Math.abs(target_y-y)==1){
					Piece piece=board[x][target_y];
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
					Piece piece=board[x][target_y];
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
		if(board[x][y].getColor()){
			if(target_x-x==1&&Math.abs(target_y-y)==1){
				Piece piece=board[target_x][ target_y];
				if(piece!=null)
					return true;
			}
		}
		else
		{
			if(target_x-x==-1&&Math.abs(target_y-y)==1){
				Piece piece=board[target_x][target_y];
				if(piece!=null)
					return true;
			}
		}
		return false;
	}
	
	public boolean checkPawnNormalmove(int x,int y,int target_x,int target_y){
		Piece pawn=board[x][y];
		if(board[x][y].getColor()){
			if(((Pawn) pawn).getIfFirstMove()){
				if(target_x-x==1&&y==target_y){
					Piece piece=board[target_x][target_y];
					if(piece==null)
						return true;
				}
				else if(target_x-x==2&&y==target_y){
					Piece piece1=board[x+1][y];
					Piece piece2=board[target_x][target_y];
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else{
				if(target_x-x==1&&y==target_y){
					Piece piece=board[target_x][target_y];
					if(piece==null)
						return true;
				}
			}
		}
		else{
			if(((Pawn) pawn).getIfFirstMove()){
				if(target_x-x==-1&&y==target_y){
					Piece piece=board[target_x][target_y];
					if(piece==null)
						return true;
				}
				else if(target_x-x==-2&&y==target_y){
					Piece piece1=board[x-1][y];
					Piece piece2=board[target_x][target_y];
					if(piece1==null&&piece2==null)return true;
					else
						return false;
				}
				else
					return false;
			}
			else{
				if(target_x-x==-1&&y==target_y){
					Piece piece=board[target_x][target_y];
					if(piece==null)
						return true;
				}
			}
		}
		return false;
	}
	public boolean move(int x,int y,int target_x,int target_y){

		if(checkmate())
			System.out.println("Your king is in check!");
		
		if(!inBoundary(x,y,target_x,target_y))
			return false;
		
			
		Piece p = this.getPiece(x,y);

		if(p==null){
			System.out.println("No piece at that position");
			return false;
		}
			
		if(p.getColor()!=turn){
			System.out.println("This is not your piece");
			return false;
		}
		
		if(checkOccupyByUs(target_x, target_y)){
			System.out.println("It is already occupied by your piece");
			return false;
		}
		

		if(p instanceof Bishop) {
			
			if(p.isValid(x, y,target_x,target_y)&&checkBishipBlock(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			}
			else {
				System.out.println("Invalid Move");
				return false;
			}
				
		}
		else if(p instanceof King) {
			if(p.isValid(x,y,target_x,target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
				if(((King) p).isFirst()){
					((King) p).changeisFirst();
				}
			}
			else {
				System.out.println("Invalid Move");
				return false;
			}
		}
		else if (p instanceof Knight){
			if(p.isValid(x,y,target_x,target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			}
			else {
				System.out.println("Invalid Move");
				return false;
			}
		}
		else if(p instanceof Queen){
			if(p.isValid(x,y,target_x,target_y)&&checkQueenBlock(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y,theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			}
			else {
				System.out.println("Invalid Move");
				return false;
			}
		}
		else if(p instanceof Rook){
			if(p.isValid(x,y,target_x,target_y)&&checkRookBlock(x, y, target_x, target_y)){
				
				((Rook) p).changeIsFirst();
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
			}
			else {
				System.out.println("Invalid Move");
				return false;
			}
		}
		
		else if(p instanceof Pawn) {
			
			if(checkPawnNormalmove(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
				if(((Pawn) p).getIfFirstMove() && Math.abs(target_x-x)==2){
					((Pawn) p).changePassantToTrue();
				}
				if(((Pawn) p).getIfFirstMove()==false)
					((Pawn) p).changePassantToFalse();
				((Pawn) p).setIfFirstMoveToFalse();
				
				if (theChessBoard.getPiece(target_x, target_y).getColor()){
					if(target_x==7){
						Scanner in;
						String role;
						do {
							System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
							in = new Scanner(System.in);
							role = in.next();
						} while(!upgrade(role, x, y, target_x, target_y));
						in.close();
					}
				}
				else {
					if(target_x==0){
						Scanner in;
						String role;
						do {
							System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
							in = new Scanner(System.in);
							role = in.next();
						} while(!upgrade(role, x, y, target_x, target_y));
						in.close();
					}
				}
			}
			else if(checkPawnEat(x, y, target_x, target_y)){
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, y, null);
				((Pawn) p).changePassantToFalse();
				if(theChessBoard.getPiece(target_x, target_y).getColor()){
					if(target_x==7){
						Scanner in;
						String role;
						do {
							System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
							in = new Scanner(System.in);
							role = in.next();
						} while(!upgrade(role, x, y, target_x, target_y));
						in.close();
					}
				}
				else{
					if(target_x==0){
						Scanner in;
						String role;
						do {
							System.out.print("Please input the role number you want to change to(1.Knight 2.Bishop 3.Rook 4.Queen):");
							in = new Scanner(System.in);
							role = in.next();
						} while(!upgrade(role, x, y, target_x, target_y));
						in.close();
					}
				}
			}
			else if(checkPawnPassant(x,y,target_x,target_y)){
				theChessBoard.initialize(target_x, target_y, theChessBoard.getPiece(x, y));
				theChessBoard.initialize(x, target_y, null);
				theChessBoard.initialize(x, y, null);
			}
			else{
				System.out.println("Invalid move");
				return false;
			}
		
		}
		return true;
	}
	public void printChessBoard(){
		for (Piece[] p: board){
			for (Piece piece : p){
				if(piece!=null){
					if(piece.getColor()){
						System.out.printf("%-9s",piece.returnName()+"1");
					}
					else
						System.out.printf("%-9s",piece.returnName()+"2");
				}
					
				else
					System.out.print("XXXXXX   ");
			}
			System.out.println();
			System.out.println();
		}
	}

	public boolean getTurn(){
		return turn;
	}

	public boolean upgrade(String role, int x, int y, int target_x, int target_y) {
		switch (role){
		case "1":
			theChessBoard.initialize(target_x, target_y, new Knight(theChessBoard.getPiece(target_x, target_y).getColor(),"1"));
			return true;
		case "2":
			theChessBoard.initialize(target_x, target_y, new Bishop(theChessBoard.getPiece(target_x, target_y).getColor(),"1"));
			return true;
		case "3":
			theChessBoard.initialize(target_x, target_y, new Rook(theChessBoard.getPiece(target_x, target_y).getColor(),"1"));
			return true;
		case "4":
			theChessBoard.initialize(target_x, target_y, new Queen(theChessBoard.getPiece(target_x, target_y).getColor(),"1"));
			return true;
		default:
			return false;
		}
	}

}
