package run;

import java.util.Scanner;

import Exception.ExOutOfBoard;
import chess.ChessBoard;
import piece.King;
import piece.Piece;
import piece.Rook;

public class CmdLongCastling extends Recordcommand{
	
	private ChessBoard chessboard = ChessBoard.getInstance();
	private Check check;
	boolean turn = check.getTurn();
	public boolean execute(){
		if(check.getTurn()){
			chessboard.set(0, 2, chessboard.getPiece(0,4));
			chessboard.set(0, 3, chessboard.getPiece(0,0));
			chessboard.set(0, 0, null);
			chessboard.set(0, 4, null);
		}
		else{
			chessboard.set(7, 2, chessboard.getPiece(7,4));
			chessboard.set(7, 3, chessboard.getPiece(7,0));
			chessboard.set(7, 0, null);
			chessboard.set(7, 4, null);
		}
		addUndoCommand(this);
		clearRedoList();
		return true;
	}

	@Override
	public void undo() {
		if(turn){
			chessboard.set(0, 4, chessboard.getPiece(0,2));
			chessboard.set(0, 0, chessboard.getPiece(0,3));
			chessboard.set(0, 2, null);
			chessboard.set(0, 3, null);
		}
		else{
			chessboard.set(7, 4, chessboard.getPiece(0,2));
			chessboard.set(7, 0, chessboard.getPiece(0,3));
			chessboard.set(7, 2, null);
			chessboard.set(7, 3, null);
		}
		addRedoCommand(this);
	}

	@Override
	public void redo() {
		if(turn){
			chessboard.set(0, 2, chessboard.getPiece(0,4));
			chessboard.set(0, 3, chessboard.getPiece(0,0));
			chessboard.set(0, 0, null);
			chessboard.set(0, 4, null);
		}
		else{
			chessboard.set(7, 2, chessboard.getPiece(7,4));
			chessboard.set(7, 3, chessboard.getPiece(7,0));
			chessboard.set(7, 0, null);
			chessboard.set(7, 4, null);
		}
		addUndoCommand(this);
	}
}
