package run;

import java.util.Scanner;

import Exception.ExOutOfBoard;
import chess.ChessBoard;
import piece.King;
import piece.Piece;
import piece.Rook;

public class CmdShortCastling extends Recordcommand{
	
	private ChessBoard chessboard = ChessBoard.getInstance();
	private Check check;
	boolean turn = check.getTurn();
	public boolean execute(){
		if(check.getTurn()){
			chessboard.set(0, 6, chessboard.getPiece(0,4));
			chessboard.set(0, 5, chessboard.getPiece(0,7));
			chessboard.set(0, 4, null);
			chessboard.set(0, 7, null);
		}
		else{
			chessboard.set(7, 6, chessboard.getPiece(7,4));
			chessboard.set(7, 5, chessboard.getPiece(7,7));
			chessboard.set(7, 4, null);
			chessboard.set(7, 7, null);
		}
		addUndoCommand(this);
		clearRedoList();
		return true;
	}

	@Override
	public void undo() {
		if(turn){
			chessboard.set(0, 4, chessboard.getPiece(0,6));
			chessboard.set(0, 7, chessboard.getPiece(0,5));
			chessboard.set(0, 6, null);
			chessboard.set(0, 5, null);
		}
		else{
			chessboard.set(7, 4, chessboard.getPiece(0,6));
			chessboard.set(7, 7, chessboard.getPiece(0,5));
			chessboard.set(7, 6, null);
			chessboard.set(7, 5, null);
		}
		addRedoCommand(this);
	}

	@Override
	public void redo() {
		if(turn){
			chessboard.set(0, 6, chessboard.getPiece(0,4));
			chessboard.set(0, 5, chessboard.getPiece(0,7));
			chessboard.set(0, 4, null);
			chessboard.set(0, 7, null);
		}
		else{
			chessboard.set(7, 6, chessboard.getPiece(7,4));
			chessboard.set(7, 5, chessboard.getPiece(7,7));
			chessboard.set(7, 4, null);
			chessboard.set(7, 7, null);
		}
		addUndoCommand(this);
	}
}
