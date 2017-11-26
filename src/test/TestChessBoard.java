package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess.ChessBoard;
import piece.*;
import run.Check;

public class TestChessBoard {
	/*@Test
	public void test_ChessBoard_inBoundary0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(8, 0, 0, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(0, 8, 0, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary2() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(-1, 6, 6, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary3() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, -1, 6, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary4() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, 8, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary5() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, 6, 8);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary6() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, -1, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary7() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, 6, -1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_inBoundary8() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(4, 4, 5, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_initialize() {
		King king =  new King(true, "1");
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initialize(3, 5, king);
		Piece piece = chessBoard.getPiece(3, 5);
		String result = piece.returnName();
		assertEquals(result, "King");
	}*/
	
	/*@Test
	public void test_ChessBoard_getTurn() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.getTurn();
		System.out.println("getTurn():" + result);
		assertEquals(result, true);
	}*/
	
	@Test
	public void test_ChessBoard_changeTurn0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.changeTurn();
		boolean result = chessBoard.getTurn();
		System.out.println("changeTurn0():" + result);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_changeTurn1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.changeTurn();
		chessBoard.changeTurn();
		boolean result = chessBoard.getTurn();
		System.out.println("changeTurn1():" + result);
		assertEquals(result, false);
	}
	
	/*@Test
	public void test_ChessBoard_move0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		Boolean result = chessBoard.move(1, 2, 8, 0);
		assertEquals(result, false);
	}*/
	
	
	/*@Test
	public void test_ChessBoard_move1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		Boolean result = chessBoard.move(1, 2, 1, 0);
		assertEquals(result, false);
	}*/
	
	public void test_ChessBoard_checkLongCastling() {
		
	}
	
	
	
}
