package run;

import java.util.Scanner;

import Exception.ExOutOfBoard;
import chess.ChessBoard;
import piece.Piece;

public class CmdMove extends Recordcommand{
	
	private ChessBoard chessboard = ChessBoard.getInstance();
	private int x,y,x_target,y_target;
	private Piece piece;
	private Scanner in = new Scanner(System.in);
	public boolean execute(){
		getInput();
		//check empty
		while(x>7 || y>7 || x<0 || y<0){
			System.out.println("The input position is out of the chessboard. Input again");
			getInput();
		}
		while(chessboard.getPiece(x, y) == null){
			System.out.println("The input position does not have a piece. Input again");
			getInput();
		}
		piece = chessboard.getPiece(x_target, y_target);
		if(chessboard.move(x,y,x_target,y_target)){
			addUndoCommand(this);
			clearRedoList();
			return true;
		}
		return false;
	}

	private void getInput(){
		System.out.println("Please input position information of the piece you want to move");
		System.out.print("x:");
		x = in.nextInt();
		System.out.print("y:");
		y = in.nextInt();
		System.out.println("Please input position information of the destination");
		System.out.print("x_target:");
		x_target = in.nextInt();
		System.out.print("y_target:");
		y_target = in.nextInt();
	}

	@Override
	public void undo() {
		chessboard.initialize(x, y, chessboard.getPiece(x_target, y_target));
		chessboard.initialize(x_target, y_target, piece);
		addRedoCommand(this);
	}

	@Override
	public void redo() {
		chessboard.move(x,y,x_target,y_target);
		addUndoCommand(this);
	}
}
