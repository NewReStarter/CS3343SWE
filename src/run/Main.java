package run;

import java.util.Scanner;

import chess.ChessBoard;
import piece.*;

public class Main 
{
	
	
    public static void main(String[] args)
    {
    	ChessBoard chessBoard = ChessBoard.getInstance();
    	
    	chessBoard.initializeEntireBoard();
    	
 
		Scanner in=new Scanner(System.in);
		boolean ifcontinue=true;
		
		while(ifcontinue){
			
			boolean validCmd = false;
			if(chessBoard.getTurn())
				System.out.println("Now it is Black's turn!");
			else
				System.out.println("Now it is White's turn!");
			chessBoard.printChessBoard();

			if(chessBoard.checkShortCastling()||chessBoard.checkLongCastling()){
				if(chessBoard.checkLongCastling())
					System.out.println("You can do Long casting!");
				if(chessBoard.checkShortCastling())
					System.out.println("You can do Short casting!");
				
				if(chessBoard.checkLongCastling()){
					if(chessBoard.checkShortCastling()){
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
					if(chessBoard.checkShortCastling()){
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
					if(chessBoard.checkmate()){
						System.out.println("You Lose!");
						ifcontinue=false;
					}
					chessBoard.changeTurn();
					
				}
			}
	
			
		}
		System.out.println("Game over!");
		chessBoard.printChessBoard();
		in.close();
    	
    }
}
