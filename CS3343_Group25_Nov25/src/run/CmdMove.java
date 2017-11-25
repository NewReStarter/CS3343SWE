package run;

import java.util.Scanner;

import Exception.ExOutOfBoard;
import chess.ChessBoard;
import piece.Piece;

public class CmdMove extends Recordcommand{
	
	private ChessBoard chessboard = ChessBoard.getInstance();
	private int x,y,x_target,y_target;
	private Piece piece;
	public boolean execute(){
		Scanner in = new Scanner(System.in);
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
		piece = chessboard.getPiece(x_target, y_target);
		if(chessboard.move(x,y,x_target,y_target)){
			addUndoCommand(this);
			clearRedoList();
			return true;
		}
		return false;
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
