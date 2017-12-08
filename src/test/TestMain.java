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
public class TestMain {
	@Test
	public void test_Main() {
		ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
		System.setIn(in);
		Main.main(null);
//		ByteArrayInputStream in2 = new ByteArrayInputStream("1".getBytes());
//		System.setIn(in2);
//		ChessBoard chessBoard = ChessBoard.getInstance();
//		Piece p = chessBoard.getPiece(3, 1);
//		String result = p.returnName();
//		System.setIn(System.in);
//		assertEquals(result, "Pawn");

	}
}
