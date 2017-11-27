package run;

import java.util.Scanner;

import Exception.ExOutOfBoard;
import chess.ChessBoard;
import piece.King;
import piece.Piece;
import piece.Rook;

public class CmdShortCastling extends Recordcommand{
	
	private ChessBoard chessboard = ChessBoard.getInstance();
	boolean turn = chessboard.getTurn();
	public boolean execute(){
		if(chessboard.getTurn()){
			chessboard.initialize(0, 6, chessboard.getPiece(0,4));
			chessboard.initialize(0, 5, chessboard.getPiece(0,7));
			chessboard.initialize(0, 4, null);
			chessboard.initialize(0, 7, null);
		}
		else{
			chessboard.initialize(7, 6, chessboard.getPiece(7,4));
			chessboard.initialize(7, 5, chessboard.getPiece(7,7));
			chessboard.initialize(7, 4, null);
			chessboard.initialize(7, 7, null);
		}
		addUndoCommand(this);
		clearRedoList();
		return true;
	}

	@Override
	public void undo() {
		if(turn){
			chessboard.initialize(0, 4, chessboard.getPiece(0,6));
			chessboard.initialize(0, 7, chessboard.getPiece(0,5));
			chessboard.initialize(0, 6, null);
			chessboard.initialize(0, 5, null);
		}
		else{
			chessboard.initialize(7, 4, chessboard.getPiece(0,6));
			chessboard.initialize(7, 7, chessboard.getPiece(0,5));
			chessboard.initialize(7, 6, null);
			chessboard.initialize(7, 5, null);
		}
		addRedoCommand(this);
	}

	@Override
	public void redo() {
		if(turn){
			chessboard.initialize(0, 6, chessboard.getPiece(0,4));
			chessboard.initialize(0, 5, chessboard.getPiece(0,7));
			chessboard.initialize(0, 4, null);
			chessboard.initialize(0, 7, null);
		}
		else{
			chessboard.initialize(7, 6, chessboard.getPiece(7,4));
			chessboard.initialize(7, 5, chessboard.getPiece(7,7));
			chessboard.initialize(7, 4, null);
			chessboard.initialize(7, 7, null);
		}
		addUndoCommand(this);
	}
}
