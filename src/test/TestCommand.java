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
public class TestCommand {
	
	
	@Test
	public void test_checkSCastling_1(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 7, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(true,result);
	}
	
	@Test
	public void test_checkSCastling_2(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		//chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkSCastling_3(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 7, new Rook(true,"1",true));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkSCastling_4(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		Rook rook = new Rook(true,"1");
		rook.changeIsFirst();
		chessBoard.initialize(0, 7, rook);
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkSCastling_5(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 7, new Queen(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkSCastling_6(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		King king = new King(true,"1");
		king.changeisFirst();
		chessBoard.initialize(0, 7, new Rook(true,"1"));
		chessBoard.initialize(0, 4, king);
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkSCastling_7(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 5, new Queen(true,"1"));
		chessBoard.initialize(0, 7, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkSCastling_8(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(7, 4, new Queen(false,"2"));
		chessBoard.initialize(0, 7, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteSCastling_1(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 7, new Rook(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(true,result);
	}
	@Test
	public void test_checkWhiteSCastling_2(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		//chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteSCastling_3(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 7, new Rook(false,"2",true));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteSCastling_4(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		Rook rook = new Rook(false,"2");
		rook.changeIsFirst();
		chessBoard.initialize(7, 7, rook);
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteSCastling_5(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 7, new Queen(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteSCastling_6(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		King king = new King(false,"2");
		king.changeisFirst();
		chessBoard.initialize(7, 7, new Rook(false,"2"));
		chessBoard.initialize(7, 4, king);
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteSCastling_7(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 5, new Queen(false,"2"));
		chessBoard.initialize(7, 7, new Rook(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteSCastling_8(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(0, 4, new Queen(true,"1"));
		chessBoard.initialize(7, 7, new Rook(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkShortCastling();
		assertEquals(false,result);
	}
	
	@Test
	public void test_checkLongCastling_1(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(true,result);
	}
	
	@Test
	public void test_checkLongCastling_2(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		//chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkLongCastling_3(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 0, new Rook(true,"1",true));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkLongCastling_4(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		Rook rook = new Rook(true,"1");
		rook.changeIsFirst();
		chessBoard.initialize(0, 0, rook);
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkLongCastling_5(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 0, new Queen(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkLongCastling_6(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		King king = new King(true,"1");
		king.changeisFirst();
		chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(0, 4, king);
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkLongCastling_7(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(0, 3, new Queen(true,"1"));
		chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkLongCastling_8(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.initialize(7, 4, new Queen(false,"2"));
		chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(0, 4, new King(true,"1"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteLongCastling_1(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 0, new Rook(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(true,result);
	}
	@Test
	public void test_checkWhiteLongCastling_2(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		//chessBoard.initialize(0, 0, new Rook(true,"1"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteLongCastling_3(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 0, new Rook(false,"2",true));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteLongCastling_4(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		Rook rook = new Rook(false,"2");
		rook.changeIsFirst();
		chessBoard.initialize(7, 0, rook);
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteLongCastling_5(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 0, new Queen(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteLongCastling_6(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		King king = new King(false,"2");
		king.changeisFirst();
		chessBoard.initialize(7, 0, new Rook(false,"2"));
		chessBoard.initialize(7, 4, king);
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteLongCastling_7(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(7, 3, new Queen(false,"2"));
		chessBoard.initialize(7, 0, new Rook(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	@Test
	public void test_checkWhiteLongCastling_8(){
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.clearChessBoard();
		chessBoard.changeTurn();
		chessBoard.initialize(0, 4, new Queen(true,"1"));
		chessBoard.initialize(7, 0, new Rook(false,"2"));
		chessBoard.initialize(7, 4, new King(false,"2"));
		boolean result=chessBoard.checkLongCastling();
		assertEquals(false,result);
	}
	
	
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
		Piece p = ChessBoard.getInstance().getPiece(0,2);
		assertEquals(p, null);
	}
	
	@Test
	public void test_cmdLongCastling_01_undo() {
		CmdLongCastling longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		longCast.undo();
		
		Piece p = ChessBoard.getInstance().getPiece(7, 2);
		assertEquals(p, null);
	}
	
	@Test
	public void test_cmdShortCastling_00_undo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		shortCast.undo();
		Piece p = ChessBoard.getInstance().getPiece(0,6);
		assertEquals(p, null);
	}
	
	@Test
	public void test_cmdShortCastling_01_undo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		shortCast.undo();
		Piece p = ChessBoard.getInstance().getPiece(0,6);
		assertEquals(p, null);
	}

	@Test
	public void test_cmdShortCastling_00_redo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		shortCast.redo();
		Piece p = ChessBoard.getInstance().getPiece(0,4);
		assertEquals(p, null);
	}
	
	@Test
	public void test_cmdShortCastling_01_redo() {
		CmdShortCastling shortCast = new CmdShortCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		shortCast.redo();
		Piece p = ChessBoard.getInstance().getPiece(0,4);
		assertEquals(p, null);
	}
	
	@Test
	public void test_cmdLongCastling_00_redo() {
		CmdLongCastling longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(true);
		longCast.redo();
		Piece p = ChessBoard.getInstance().getPiece(0,0);
		assertEquals(p, null);
	}
	
	@Test
	public void test_cmdLongCastling_01_redo() {
		CmdLongCastling longCast = new CmdLongCastling();
		ChessBoard board = ChessBoard.getInstance();
		board.setTurn(false);
		longCast.redo();
		Piece p = ChessBoard.getInstance().getPiece(7, 0);
		assertEquals(p, null);
	}
		
	@Test
	public void test_cmdMove_00_execute() {
		ByteArrayInputStream in = new ByteArrayInputStream("9 9 9 9 4 4 4 4 1 1 3 1".getBytes());
		System.setIn(in);
		ChessBoard board = ChessBoard.getInstance();
		board.initializeEntireBoard();
		CmdMove move = new CmdMove();
		boolean result = move.execute();
		System.setIn(System.in);
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdMove_01_execute() {
		ByteArrayInputStream in = new ByteArrayInputStream("9 9 9 9 4 4 4 4 1 1 4 1".getBytes());
		System.setIn(in);
		ChessBoard board = ChessBoard.getInstance();
		board.initializeEntireBoard();
		CmdMove move = new CmdMove();
		boolean result = move.execute();
		System.setIn(System.in);
		assertEquals(result, false);
	}
	
	@Test
	public void test_cmdMove_00_undo() {
		ByteArrayInputStream in = new ByteArrayInputStream("1 1 3 1".getBytes());
		System.setIn(in);
		ChessBoard board = ChessBoard.getInstance();
		board.initializeEntireBoard();
		CmdMove move = new CmdMove();
		boolean result = move.execute();
		Recordcommand.undoOneCommand();
		System.setIn(System.in);
		assertEquals(result, true);
	}
	
	@Test
	public void test_cmdMove_00_redo() {
		ByteArrayInputStream in = new ByteArrayInputStream("1 1 3 1".getBytes());
		System.setIn(in);
		ChessBoard board = ChessBoard.getInstance();
		board.initializeEntireBoard();
		CmdMove move = new CmdMove();
		boolean result = move.execute();
		Recordcommand.undoOneCommand();
		Recordcommand.redoOneCommand();
		System.setIn(System.in);
		assertEquals(result, true);
	}
	@Test
	public void test_cmdMove_00() {
		ByteArrayInputStream in = new ByteArrayInputStream("1 1 3 1".getBytes());
		System.setIn(in);
		ChessBoard board = ChessBoard.getInstance();
		board.initializeEntireBoard();
		CmdMove move = new CmdMove();
		boolean result = move.execute();
		
		Recordcommand.undoOneCommand();
		Recordcommand.redoOneCommand();
		System.setIn(System.in);
	
		assertEquals(result, true);
	}
	
	
}
