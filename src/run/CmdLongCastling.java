package run;

import java.util.Scanner;

import Exception.ExOutOfBoard;
import chess.ChessBoard;
import piece.King;
import piece.Piece;
import piece.Rook;

public class CmdLongCastling extends Recordcommand{
	
	private ChessBoard chessboard = ChessBoard.getInstance();
	boolean turn = chessboard.getTurn();
	public boolean execute(){
		if(chessboard.getTurn()){
			chessboard.initialize(0, 2, chessboard.getPiece(0,4));
			chessboard.initialize(0, 3, chessboard.getPiece(0,0));
			chessboard.initialize(0, 0, null);
			chessboard.initialize(0, 4, null);
		}
		else{
			chessboard.initialize(7, 2, chessboard.getPiece(7,4));
			chessboard.initialize(7, 3, chessboard.getPiece(7,0));
			chessboard.initialize(7, 0, null);
			chessboard.initialize(7, 4, null);
		}
		addUndoCommand(this);
		clearRedoList();
		return true;
	}

	@Override
	public void undo() {
		if(turn){
			chessboard.initialize(0, 4, chessboard.getPiece(0,2));
			chessboard.initialize(0, 0, chessboard.getPiece(0,3));
			chessboard.initialize(0, 2, null);
			chessboard.initialize(0, 3, null);
		}
		else{
			chessboard.initialize(7, 4, chessboard.getPiece(0,2));
			chessboard.initialize(7, 0, chessboard.getPiece(0,3));
			chessboard.initialize(7, 2, null);
			chessboard.initialize(7, 3, null);
		}
		addRedoCommand(this);
	}

	@Override
	public void redo() {
		if(turn){
			chessboard.initialize(0, 2, chessboard.getPiece(0,4));
			chessboard.initialize(0, 3, chessboard.getPiece(0,0));
			chessboard.initialize(0, 0, null);
			chessboard.initialize(0, 4, null);
		}
		else{
			chessboard.initialize(7, 2, chessboard.getPiece(7,4));
			chessboard.initialize(7, 3, chessboard.getPiece(7,0));
			chessboard.initialize(7, 0, null);
			chessboard.initialize(7, 4, null);
		}
		addUndoCommand(this);
	}
}
