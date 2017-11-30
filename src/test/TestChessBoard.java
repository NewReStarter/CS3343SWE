package test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import chess.ChessBoard;
import piece.*;
import run.Check;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestChessBoard {
	@Test
	public void test_ChessBoard_00_inBoundary0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(8, 0, 0, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_01_inBoundary1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(0, 8, 0, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_02_nBoundary2() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(-1, 6, 6, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_03_inBoundary3() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, -1, 6, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_04_inBoundary4() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, 8, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_05_inBoundary5() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, 6, 8);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_06_inBoundary6() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, -1, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_07_inBoundary7() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(6, 6, 6, -1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_08_inBoundary8() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.inBoundary(4, 4, 5, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_09_initializeEntireBoard() {
		ChessBoard chessBoard = ChessBoard.getInstance();
    	chessBoard.initializeEntireBoard();
		Piece piece = chessBoard.getPiece(0, 4);
		String result = piece.returnName();
		assertEquals(result, "King");
	}
	
	@Test
	public void test_ChessBoard_10_getTurn() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.getTurn();
		// Turn == true;
		System.out.println("getTurn():" + result);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_11_changeTurn0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.changeTurn();
		// Turn == false;
		boolean result = chessBoard.getTurn();
		System.out.println("changeTurn0():" + result);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_12_changeTurn1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.changeTurn();
		chessBoard.changeTurn();
		// Turn == false;
		boolean result = chessBoard.getTurn();
		System.out.println("changeTurn1():" + result);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_13_move0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(1, 2, 8, 0);
		assertEquals(result, false);
	}
	
	
	@Test
	public void test_ChessBoard_14_move1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(2, 7, 1, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_15_move2() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.changeTurn();
		//Turn == true;
		boolean result = chessBoard.move(2, 7, 1, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_16_move3() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(7, 0, 6, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_17_move4() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(0, 0, 0, 1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_18_move5() {
		ChessBoard chessBoard = ChessBoard.getInstance();
//		System.out.println();
//		System.out.println();
//		System.out.println(chessBoard.getPiece(0, 2).returnName());
//		System.out.println(chessBoard.getPiece(0, 2).isValid(0, 2, 3, 1));
		boolean result = chessBoard.move(0, 2, 3, 1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_19_move6() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		Boolean result = chessBoard.move(0, 2, 1, 3);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_20_move7() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(0, 2, 2, 4);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_21_move8() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.move(1, 3, 2, 3);
		boolean result = chessBoard.move(0, 2, 2, 4);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_22_move9() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(0, 4, 3, 4);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_23_move10() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.move(1,  4,  3, 4);
		King king = (King)chessBoard.getPiece(0, 4);
		boolean result = king.isFirst();
		assertEquals(result, true);
		result = chessBoard.move(0, 4, 1, 4);
		assertEquals(result, true);
		king = (King)chessBoard.getPiece(1, 4);
		result = king.isFirst();
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_24_move11() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(1, 4, 2, 4);
		assertEquals(result, true);
		King king = (King)chessBoard.getPiece(2, 4);
		result = king.isFirst();
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_25_move12() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(0, 1, 5, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_26_move13() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(0, 1, 2, 2);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_27_move14() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(0, 3, 2, 6);
		assertEquals(result, false);
		
	}
	
	@Test
	public void test_ChessBoard_28_move15() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(0, 3, 2, 5);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_29_move16() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.move(1, 4, 2, 4);
		boolean result = chessBoard.move(0, 3, 2, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_30_move17() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		Piece p = chessBoard.getPiece(0,  0);
		boolean result = chessBoard.move(0, 0, 2, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_31_move18() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(0, 0, 2, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_32_move19() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.move(1, 0, 3, 0);
//		Check check = chessBoard.returnBlackCheck();
//		Piece p = chessBoard.getPiece(0, 0);
//		System.out.println(p.returnName());
//		System.out.println(p.isValid(0, 0, 2, 0));
//		System.out.println(check.checkRookBlock(0, 0, 2, 0));
		boolean result = chessBoard.move(0, 0, 2, 0);
		assertEquals(result, true);
	}
	
	
	//Pawn
	@Test
	public void test_ChessBoard_33_move20() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(1, 0, 4, 0);
		assertEquals(result, false);
	}
	
	
	@Test
	public void test_ChessBoard_34_move21() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		boolean result = chessBoard.move(1, 0, 3, 0);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_35_move22() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(1, 1, 2, 1);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_36_move23() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		boolean result = chessBoard.move(3, 0, 4, 0);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_37_move24() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		//Pawn pawn = (Pawn)chessBoard.getPiece(2,  1);
		//System.out.println(pawn.getIfFirstMove());
		boolean result = chessBoard.move(2, 1, 4, 1);
		assertEquals(result, false);
	}
	
	/*@Test
	public void test_ChessBoard_38_move25() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		for (int i = 0; i < 8; i++){
			chessBoard.initialize(1, i, null);
			chessBoard.initialize(6, i, null);
		}
		chessBoard.initialize(7, 0, null);
		Pawn pawn = new Pawn(true, "1");
		pawn.setIfFirstMoveToFalse();
		chessBoard.initialize(6, 0, pawn);
		//Scanner in = new Scanner(System.in);
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		//InputStream inputStream = System.in;
		//System.setIn(inputStream);
		System.out.println(chessBoard.getPiece(6, 0).returnName());
		boolean result = chessBoard.move(6, 0, 7, 0);
		assertEquals(result, true);
		Piece p = chessBoard.getPiece(7, 0);
		String chessResult = p.returnName();
		assertEquals(result, "Knight");
	}*/
	
	
	@Test
	public void test_ChessBoard_39_upgrade0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.clearChessBoard();
		Pawn pawn = new Pawn(true, "1");
		pawn.setIfFirstMoveToFalse();
		chessBoard.initialize(6, 0, pawn);
		boolean result = chessBoard.upgrade(1, 6, 0, 7, 0);
		Piece p = chessBoard.getPiece(7, 0);
		assertEquals(p.returnName(), "Knight");
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_40_upgrade1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.clearChessBoard();
		Pawn pawn = new Pawn(true, "1");
		pawn.setIfFirstMoveToFalse();
		chessBoard.initialize(6, 0, pawn);
		boolean result = chessBoard.upgrade(2, 6, 0, 7, 0);
		Piece p = chessBoard.getPiece(7, 0);
		assertEquals(p.returnName(), "Bishop");
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_41_upgrade2() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.clearChessBoard();
		Pawn pawn = new Pawn(true, "1");
		pawn.setIfFirstMoveToFalse();
		chessBoard.initialize(6, 0, pawn);
		boolean result = chessBoard.upgrade(3, 6, 0, 7, 0);
		Piece p = chessBoard.getPiece(7, 0);
		assertEquals(p.returnName(), "Rook");
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_42_upgrade3() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.clearChessBoard();
		Pawn pawn = new Pawn(true, "1");
		pawn.setIfFirstMoveToFalse();
		chessBoard.initialize(6, 0, pawn);
		boolean result = chessBoard.upgrade(4, 6, 0, 7, 0);
		Piece p = chessBoard.getPiece(7, 0);
		assertEquals(p.returnName(), "Queen");
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_43_upgrade4() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
		chessBoard.clearChessBoard();
		Pawn pawn = new Pawn(true, "1");
		pawn.setIfFirstMoveToFalse();
		chessBoard.initialize(6, 0, pawn);
		boolean result = chessBoard.upgrade(5, 6, 0, 7, 0);
		Piece p = chessBoard.getPiece(6, 0);
		assertEquals(p.returnName(), "Pawn");
		p = chessBoard.getPiece(6, 0);
		assertEquals(p.returnName(), "Pawn");
		assertEquals(result, false);
	}
}
