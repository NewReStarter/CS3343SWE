package run;

import java.util.Scanner;

import Exception.ExOutOfBoard;
import chess.ChessBoard;
import piece.*;

public class Main 
{
	
	
    public static void main(String[] args)
    {
    	ChessBoard chessBoard = ChessBoard.getInstance();

    	Check check = new Check(true);
    	
    	chessBoard.initialize(0,0,new Rook(true, "1"));
    	chessBoard.initialize(0,1,new Knight(true, "1"));
    	chessBoard.initialize(0,2,new Bishop(true, "1"));
    	chessBoard.initialize(0,3,new Queen(true, "1"));
    	chessBoard.initialize(0,4,new King(true, "1"));
    	chessBoard.initialize(0,5,new Bishop(true, "1"));
    	chessBoard.initialize(0,6,new Knight(true, "1"));
    	chessBoard.initialize(0,7,new Rook(true, "1"));
    	chessBoard.initialize(1,0,new Pawn(true, "1"));
    	chessBoard.initialize(1,1,new Pawn(true, "1"));
    	chessBoard.initialize(1,2,new Pawn(true, "1"));
    	chessBoard.initialize(1,3,new Pawn(true, "1"));
    	chessBoard.initialize(1,4,new Pawn(true, "1"));
    	chessBoard.initialize(1,5,new Pawn(true, "1"));
    	chessBoard.initialize(1,6,new Pawn(true, "1"));
    	chessBoard.initialize(1,7,new Pawn(true, "1"));
    	
    	chessBoard.initialize(7,0,new Rook(false, "2"));
    	chessBoard.initialize(7,1,new Knight(false, "2"));
    	chessBoard.initialize(7,2,new Bishop(false, "2"));
    	chessBoard.initialize(7,3,new Queen(false, "2"));
    	chessBoard.initialize(7,4,new King(false, "2"));
    	chessBoard.initialize(7,5,new Bishop(false, "2"));
    	chessBoard.initialize(7,6,new Knight(false, "2"));
    	chessBoard.initialize(7,7,new Rook(false, "2"));
    	chessBoard.initialize(6,0,new Pawn(false, "2"));
    	chessBoard.initialize(6,1,new Pawn(false, "2"));
    	chessBoard.initialize(6,2,new Pawn(false, "2"));
    	chessBoard.initialize(6,3,new Pawn(false, "2"));
    	chessBoard.initialize(6,4,new Pawn(false, "2"));
    	chessBoard.initialize(6,5,new Pawn(false, "2"));
    	chessBoard.initialize(6,6,new Pawn(false, "2"));
    	chessBoard.initialize(6,7,new Pawn(false, "2"));

    	
 
		Scanner in=new Scanner(System.in);
		boolean ifcontinue=true;
		
		while(ifcontinue){
			
			boolean validCmd = false;
			if(chessBoard.getTurn())
				System.out.println("Now it is Black's turn!");
			else
				System.out.println("Now it is White's turn!");
			chessBoard.printChessBoard();

			if(check.checkShortCastling()||check.checkLongCastling()){
				if(check.checkLongCastling())
					System.out.println("You can do Long casting!");
				if(check.checkShortCastling())
					System.out.println("You can do Short casting!");
				
				if(check.checkLongCastling()){
					if(check.checkShortCastling()){
						System.out.print("Input (1. move 2. exit 3. Long Castling 4. Short Casting):");
						int i=in.nextInt();
						switch (i){
						case 1:
							if((new CmdMove()).execute()){
								validCmd = true;
							}
								
							break;
						case 2:
							ifcontinue=false;
							break;
						case 3:
							(new CmdLongCastling()).execute();
							validCmd=true;
							break;
						case 4:
							(new CmdShortCastling()).execute();
							validCmd=true;
							break;
						}
					}
					else{
						System.out.print("Input (1. move 2. exit 3. Long Castling):");
						int i=in.nextInt();
						switch (i){
						case 1:
							if((new CmdMove()).execute()){
								validCmd = true;
							}
							break;
						case 2:
							ifcontinue=false;
							break;
						case 3:
							(new CmdLongCastling()).execute();
							validCmd=true;
							break;
						}
					}
				}
				else{
					if(check.checkShortCastling()){
						System.out.print("Input (1. move 2. exit 3. Short Casting):");
						int i=in.nextInt();
						switch (i){
						case 1:
							if((new CmdMove()).execute()){
								
								validCmd = true;
							}
							break;
						case 2:
							ifcontinue=false;
							break;
						case 3:
							(new CmdShortCastling()).execute();
							validCmd=true;
							break;
						}
					}
					else{
						System.out.print("Input (1. move 2. exit):");
						int i=in.nextInt();
						switch (i){
						case 1:
							if((new CmdMove()).execute()){
								
								validCmd = true;
							}
							break;
						case 2:
							ifcontinue=false;
							break;
						}

					}
				}
			}
			else{
				System.out.print("Input (1. move 2. exit):");
				int i=in.nextInt();
				switch (i){
				case 1:
					if((new CmdMove()).execute()){
	
						validCmd = true;
					}
					break;
				case 2:
					ifcontinue=false;
					break;
				}
			}
			
			
			if(validCmd){
				chessBoard.printChessBoard();
				System.out.print("Do you want to Undo?(y/n)");
				String x=in.next();
				if(x.equals("y")){
					Recordcommand.undoOneCommand();
				}
				else {
					if(check.checkmate()){
						System.out.println("You Lose!");
						ifcontinue=false;
					}
					chessBoard.changeTurn();
					check.changeTurn();
				}
			}
	
			
		}
		System.out.println("Game over!");
		chessBoard.printChessBoard();
		in.close();
    	
    }
}
