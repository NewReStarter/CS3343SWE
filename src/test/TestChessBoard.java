package test;

import piece.*;
import run.CmdLongCastling;
import run.CmdMove;
import run.CmdShortCastling;
import run.Command;
import run.Recordcommand;
import run.Main;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import chess.ChessBoard;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestChessBoard {

	//checkRowAndCol 1st for loop
	@Test
	public void test_Check_00_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 3, new Queen(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_01_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 3, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_02_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 3, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_03_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 3, new Queen(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	
	//checkRowAndCol 2nd for loop
	
	@Test
	public void test_Check_04_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 3, new Queen(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_05_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 3, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_06_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 3, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_07_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 3, new Queen(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	//checkRowAndCol 3rd for loop
	
	@Test
	public void test_Check_08_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 1, new Queen(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_09_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 1, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_10_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 1, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_11_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 1, new Queen(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	//checkRowAndCol 4th for loop
	
	@Test
	public void test_Check_12_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 5, new Queen(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_13_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 5, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_14_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_15_checkmate_checkRowAndCol() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(3, 5, new Queen(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkDiagonal 1st while loop
	@Test
	public void test_Check_16_checkmate_checkDiagonal() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Queen(false, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_17_checkmate_checkDiagonal() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Bishop(false, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_18_checkmate_checkDiagonal() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Bishop(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_19_checkmate_checkDiagonal() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Rook(false, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkDiagonal 2nd while loop
	@Test
	public void test_Check_20_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 1, new Queen(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_21_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 1, new Bishop(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_22_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 1, new Bishop(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_23_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 1, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkDiagonal 3rd while loop
	@Test
	public void test_Check_24_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 5, new Queen(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_25_checkmate_checkDiagonal() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 5, new Bishop(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_26_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 5, new Bishop(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_27_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 5, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkDiagonal 4th while loop
	@Test
	public void test_Check_28_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 1, new Queen(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_29_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 1, new Bishop(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_30_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 1, new Bishop(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_31_checkmate_checkDiagonal() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 1, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkKnight case 1 x<8
	@Test
	public void test_Check_32_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 4, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_33_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_34_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 4, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_35_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 4, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_36_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 6, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_37_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 6, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 1, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_38_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 2, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_39_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 2, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkKnight case 2 x>-1
	@Test
	public void test_Check_40_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 4, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_41_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_42_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 4, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_43_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 4, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_44_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 6, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_45_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 6, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 1, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_46_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 2, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_47_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(1, 2, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkKnight case 3 y>-1
	@Test
	public void test_Check_48_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(4, 1, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_49_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_50_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(4, 1, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_51_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(4, 1, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_52_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 6, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(2, 4, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_53_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 6, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 1, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_54_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(2, 1, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_55_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(2, 1, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	// checkKnight case 4 y<8
	@Test
	public void test_Check_56_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(4, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_57_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(5, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_58_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(4, 5, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_59_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(4, 5, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_60_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(2, 5, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Check_61_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(7, 1, new Knight(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_62_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(2, 5, new Rook(false, "2"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Check_63_checkmate_checkKnight() {
		
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(3, 3, new King(true, "1"));
		chessBoard.initialize(7, 4, new King(false, "2"));
		chessBoard.initialize(2, 5, new Knight(true, "1"));
		boolean result = chessBoard.checkmate();
		assertEquals(result, false);
	}
	
	@Test
	public void test_checkPawn_1(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 4, new King(true,"1"));
		chessBoard.initialize(1, 3, new Pawn(false,"1"));
		boolean result = chessBoard.checkPawn();
		assertEquals(true,result);
	}
	@Test
	public void test_checkPawn_2(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 4, new King(true,"1"));
		chessBoard.initialize(1, 5, new Pawn(false,"1"));
		boolean result = chessBoard.checkPawn();
		assertEquals(true,result);
	}
	@Test
	public void test_checkPawn_3(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result = chessBoard.checkPawn();
		assertEquals(false,result);
	}
	@Test
	public void test_checkPawn_4(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 4, new King(true,"1"));
		chessBoard.initialize(1, 3, new Knight(false,"1"));
		boolean result = chessBoard.checkPawn();
		assertEquals(false,result);
	}
	@Test
	public void test_checkPawn_5(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 4, new King(true,"1"));
		chessBoard.initialize(1, 5, new Knight(false,"1"));
		boolean result = chessBoard.checkPawn();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWPawn_1(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 4, new King(false,"1"));
		chessBoard.initialize(6, 3, new Pawn(true,"1"));
		chessBoard.findKing();
		boolean result = chessBoard.checkPawn();
		assertEquals(true,result);
	}
	@Test
	public void test_checkWPawn_2(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 4, new King(false,"1"));
		chessBoard.initialize(6, 5, new Pawn(true,"1"));
		chessBoard.findKing();
		boolean result = chessBoard.checkPawn();
		assertEquals(true,result);
	}
	@Test
	public void test_checkWPawn_3(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 4, new King(false,"1"));
		chessBoard.findKing();
		boolean result = chessBoard.checkPawn();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWPawn_4(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 4, new King(false,"1"));
		chessBoard.initialize(6, 3, new Knight(true,"1"));
		chessBoard.findKing();
		boolean result = chessBoard.checkPawn();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWPawn_5(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 4, new King(false,"1"));
		chessBoard.initialize(6, 5, new Knight(true,"1"));
		chessBoard.findKing();
		boolean result = chessBoard.checkPawn();
		assertEquals(false,result);
	}

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
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		// Turn == false;
		boolean result = chessBoard.getTurn();
		System.out.println("changeTurn0():" + result);
		
		assertEquals(result, false);
	}
	
	@Test
	public void test_ChessBoard_12_changeTurn1() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		// Turn == false;
		chessBoard.changeTurn();
		boolean result = chessBoard.getTurn();
		System.out.println("changeTurn1():" + result);
		assertEquals(result, true);
	}
	
	@Test
	public void test_ChessBoard_13_move0() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.initializeEntireBoard();
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
		chessBoard.changeTurn();
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
		boolean result = chessBoard.upgrade("1", 5, 0, 6, 0);
		Piece p = chessBoard.getPiece(6, 0);
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
		boolean result = chessBoard.upgrade("2", 5, 0, 6, 0);
		Piece p = chessBoard.getPiece(6, 0);
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
		boolean result = chessBoard.upgrade("3", 5, 0, 6, 0);
		Piece p = chessBoard.getPiece(6, 0);
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
		boolean result = chessBoard.upgrade("4", 5, 0, 6, 0);
		Piece p = chessBoard.getPiece(6, 0);
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
		boolean result = chessBoard.upgrade("5", 6, 0, 7, 0);
		Piece p = chessBoard.getPiece(6, 0);
		assertEquals(p.returnName(), "Pawn");
		p = chessBoard.getPiece(6, 0);
		assertEquals(p.returnName(), "Pawn");
		assertEquals(result, false);
	}

	
	@Test
	public void test_ChessBoard_checkmate() {
		ChessBoard chessboard=ChessBoard.getInstance();
		chessboard.clearChessBoard();
		chessboard.initialize(0, 0, new King(true,"1"));
		chessboard.initialize(7, 0, new Queen(false,"1"));
		boolean result = chessboard.move(0, 0, 0, 1);
		assertEquals(true,result);
	}
	
	@Test
	public void test_ChessBoard_BlackPawnChange() {
		
		ChessBoard chessboard=ChessBoard.getInstance();
		chessboard.clearChessBoard();
		chessboard.initialize(6, 0, new Pawn(true,"1"));
		chessboard.initialize(0, 1, new King(true,"1"));
		String data = "4";
		InputStream stdin = System.in;
		
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		boolean check = chessboard.move(6, 0, 7, 0);
		
		Piece p = chessboard.getPiece(7, 0);
		String result = p.returnName();
		assertEquals(result, "Queen");
	}
	@Test
	public void test_ChessBoard_WhitePawnChange() {
		
		ChessBoard chessboard=ChessBoard.getInstance();
		chessboard.clearChessBoard();
		chessboard.changeTurn();
		chessboard.initialize(1, 0, new Pawn(false,"1"));
		chessboard.initialize(6, 1, new King(false,"1"));
		String data = "4";
		InputStream stdin = System.in;
		
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		boolean check = chessboard.move(1, 0, 0, 0);
		  
		Piece p = chessboard.getPiece(0, 0);
		String result = p.returnName();
		
		chessboard.changeTurn();
		assertEquals(result, "Queen");
	}
	@Test
	public void test_ChessBoard_BlackPawnEatChange() {
		
		ChessBoard chessboard=ChessBoard.getInstance();
		chessboard.clearChessBoard();
		chessboard.initialize(6, 0, new Pawn(true,"1"));
		chessboard.initialize(0, 1, new King(true,"1"));
		chessboard.initialize(7, 1, new Pawn(false,"2"));
		String data = "4";
		InputStream stdin = System.in;
		
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		boolean check = chessboard.move(6, 0, 7,1);
	  
		Piece p = chessboard.getPiece(7, 1);
		String result = p.returnName();
		assertEquals(result, "Queen");
	}
	@Test
	public void test_ChessBoard_WhitePawnEatChange() {
		
		ChessBoard chessboard=ChessBoard.getInstance();
		chessboard.clearChessBoard();
		chessboard.changeTurn();
		chessboard.initialize(1, 0, new Pawn(false,"2"));
		chessboard.initialize(7, 1, new King(false,"2"));
		chessboard.initialize(0, 1, new Pawn(true,"1"));
		String data = "4";
		InputStream stdin = System.in;
		
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			boolean check = chessboard.move(1,0,0,1);
		  
		Piece p = chessboard.getPiece(0, 1);
		String result = p.returnName();
		assertEquals(result, "Queen");
	}
	
	@Test
	public void test_OccupyByEn_1(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 0, new King(true,"1"));
		boolean result = chessBoard.checkOccupyByEn(0, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_OccupyByEn_2(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 0, new King(false,"1"));
		boolean result = chessBoard.checkOccupyByEn(0, 0);
		assertEquals(result,true);
	}
	@Test
	public void test_OccupyByEn_3(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		boolean result = chessBoard.checkOccupyByEn(0, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_BishipBlock_1(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 7, 7);
		assertEquals(result,true);
	}
	@Test
	public void test_BishipBlock_2(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 3, 3);
		assertEquals(result,true);
	}
	@Test
	public void test_BishipBlock_3(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 7, 3);
		assertEquals(result,true);
	}
	@Test
	public void test_BishipBlock_4(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 3, 7);
		assertEquals(result,true);
	}
	@Test
	public void test_BishipBlock_5(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		chessBoard.initialize(6, 6, new Pawn(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 7, 7);
		assertEquals(result,false);
	}
	@Test
	public void test_BishipBlock_6(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		chessBoard.initialize(4, 4, new Pawn(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 3, 3);
		assertEquals(result,false);
	}
	@Test
	public void test_BishipBlock_7(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		chessBoard.initialize(6, 4, new Pawn(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 7, 3);
		assertEquals(result,false);
	}
	@Test
	public void test_BishipBlock_8(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Bishop(true,"1"));
		chessBoard.initialize(4, 6, new Pawn(true,"1"));
		boolean result = chessBoard.checkBishipBlock(5, 5, 3, 7);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_1(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 7, 7);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_2(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 3, 3);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_3(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 7, 3);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_4(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 3, 7);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_5(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(6, 6, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 7, 7);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_6(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(4, 4, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 3, 3);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_7(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(6, 4, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 7, 3);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_8(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(4, 6, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 3, 7);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_9(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 5, 7);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_10(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(5, 6, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 5, 7);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_11(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 5, 3);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_12(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(5, 4, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 5, 3);
		assertEquals(result,false);
	}

	@Test
	public void test_QueenBlock_13(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 7, 5);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_14(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(6, 5, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 7, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_15(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 3, 5);
		assertEquals(result,true);
	}
	@Test
	public void test_QueenBlock_16(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(4, 5, new Pawn(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 3, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_QueenBlock_17(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkQueenBlock(5, 5, 1, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_RookBlock_9(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 5, 7);
		assertEquals(result,true);
	}
	@Test
	public void test_RookBlock_10(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(5, 6, new Pawn(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 5, 7);
		assertEquals(result,false);
	}
	@Test
	public void test_RookBlock_11(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 5, 3);
		assertEquals(result,true);
	}
	@Test
	public void test_RookBlock_12(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(5, 4, new Pawn(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 5, 3);
		assertEquals(result,false);
	}

	@Test
	public void test_RookBlock_13(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 7, 5);
		assertEquals(result,true);
	}
	@Test
	public void test_RookBlock_14(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(6, 5, new Pawn(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 7, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_RookBlock_15(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 3, 5);
		assertEquals(result,true);
	}
	@Test
	public void test_RookBlock_16(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		chessBoard.initialize(4, 5, new Pawn(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 3, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_RookBlock_17(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(5, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkRookBlock(5, 5, 1, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassant_1(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(4, 4, new Pawn(true,"1"));
		boolean result = chessBoard.checkPawnPassant(4, 4, 5, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassant_2(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(4, 4, new Pawn(true,"1"));
		chessBoard.initialize(4, 5, new Pawn(false,"1"));
		boolean result = chessBoard.checkPawnPassant(4, 4, 5, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassant_3(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(4, 4, new Pawn(true,"1"));
		chessBoard.initialize(4, 5, new Queen(false,"1"));
		boolean result = chessBoard.checkPawnPassant(4, 4, 5, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassant_4(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(4, 4, new Pawn(true,"1"));
		chessBoard.initialize(6, 5, new Pawn(false,"1"));
		chessBoard.initialize(7, 4, new King(false,"1"));
		chessBoard.changeTurn();
		chessBoard.move(6, 5, 4, 5);
		chessBoard.changeTurn();
		boolean result = chessBoard.checkPawnPassant(4, 4, 5, 5);
		assertEquals(result,true);
	}
	@Test
	public void test_PawnPassant_5(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(3, 4, new Pawn(false,"1"));
		boolean result = chessBoard.checkPawnPassant(3, 4, 2, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassant_6(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(3, 4, new Pawn(false,"1"));
		chessBoard.initialize(3, 5, new Pawn(true,"1"));
		boolean result = chessBoard.checkPawnPassant(3, 4, 2, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassant_7(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(3, 4, new Pawn(false,"1"));
		chessBoard.initialize(3, 5, new Queen(true,"1"));
		boolean result = chessBoard.checkPawnPassant(3, 4, 2, 5);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassant_8(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(3, 4, new Pawn(false,"1"));
		chessBoard.initialize(1, 5, new Pawn(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		chessBoard.changeTurn();
		chessBoard.move(1, 5, 3, 5);
		chessBoard.changeTurn();
		boolean result = chessBoard.checkPawnPassant(3, 4, 2, 5);
		assertEquals(result,true);
	}
	@Test
	public void test_PawnNormalmove(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 0, new Pawn(true,"1"));
		chessBoard.initialize(1, 0, new Pawn(true,"1"));
		chessBoard.initialize(2, 0, new Pawn(true,"1"));
		boolean result = chessBoard.checkPawnNormalmove(0, 0, 2, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnNormalmove_1(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 0, new Pawn(true,"1"));
		chessBoard.initialize(1, 0, new Pawn(true,"1"));
		chessBoard.initialize(2, 0, new Pawn(true,"1"));
		boolean result = chessBoard.checkPawnNormalmove(0, 0, 1, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnNormalmove_3(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(2, 0, new Pawn(false,"1"));
		chessBoard.initialize(1, 0, new Pawn(false,"1"));
		chessBoard.initialize(0, 0, new Pawn(false,"1"));
		boolean result = chessBoard.checkPawnNormalmove(2, 0, 0, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnNormalmove_4(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		Pawn pawn = new Pawn(false,"2");
		pawn.setIfFirstMoveToFalse();
		chessBoard.initialize(2, 0, pawn);
	
		boolean result = chessBoard.checkPawnNormalmove(2, 0, 1, 0);
		assertEquals(result,true);
	}
	@Test
	public void test_color(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initializeEntireBoard();
		chessBoard.changeTurn();
		boolean result = chessBoard.move(1, 0, 2, 0);
		assertEquals(result,false);
	}
	@Test
	public void test_PawnPassantMove_1(){
		ChessBoard chessBoard=ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 4, new King(true,"1"));
		chessBoard.initialize(4, 4, new Pawn(true,"1"));
		chessBoard.initialize(6, 5, new Pawn(false,"1"));
		chessBoard.initialize(7, 4, new King(false,"1"));
		chessBoard.changeTurn();
		chessBoard.move(6, 5, 4, 5);
		chessBoard.changeTurn();
		boolean result = chessBoard.move(4, 4, 5, 5);
		assertEquals(result,true);
	}
}
