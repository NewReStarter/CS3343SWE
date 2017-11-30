package test;

import static org.junit.Assert.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.Test;

import run.*;
import chess.ChessBoard;
import piece.*;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestCommand {

	@Test
	public void test_cmdShortCastling_00_execute() {
		Command shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		boolean result = shortCast.execute();
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdShortCastling_01_execute() {
		Command shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		boolean result = shortCast.execute();
		assertEquals(result, true);
	}
	
	
	@Test
	public void test_cmdLongCastling_00_execute() {
		Command longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		boolean result = longCast.execute();
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdLongCastling_01_execute() {
		Command longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		boolean result = longCast.execute();
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdLongCastling_00_undo() {
		CmdLongCastling longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		longCast.undo();
		boolean result = ChessBoard.getInstance().getPiece(0,2) == null ? true : false;
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdLongCastling_01_undo() {
		CmdLongCastling longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		longCast.undo();
		boolean result = ChessBoard.getInstance().getPiece(7,2) == null ;
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdShortCastling_00_undo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		shortCast.undo();
		boolean result = ChessBoard.getInstance().getPiece(0,6) == null ? true : false;
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdShortCastling_01_undo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		shortCast.undo();
		boolean result = ChessBoard.getInstance().getPiece(0,6) == null ? true : false;
		assertEquals(result, true);
	}

	@Test
	public void test_cmdShortCastling_00_redo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		shortCast.redo();
		boolean result = ChessBoard.getInstance().getPiece(0,4) == null ? true : false;
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdShortCastling_01_redo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		shortCast.redo();
		boolean result = ChessBoard.getInstance().getPiece(0,4) == null ? true : false;
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdLongCastling_00_redo() {
		CmdLongCastling longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		longCast.redo();
		boolean result = ChessBoard.getInstance().getPiece(0,0) == null ? true : false;
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdLongCastling_01_redo() {
		CmdLongCastling longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		longCast.redo();
		boolean result = ChessBoard.getInstance().getPiece(7,0) == null ? true : false;
		assertEquals(result, true);
	}
}
