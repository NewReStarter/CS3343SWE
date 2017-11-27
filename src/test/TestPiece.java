package test;

import piece.*;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPiece {

	@Test
	public void test_Bishop_isValid0() {
		Bishop bishop = new Bishop(true, "bishop");
		boolean result = bishop.isValid(5, 5, 1, 1);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Bishop_isValid1() {
		Bishop bishop = new Bishop(true, "bishop");
		boolean result = bishop.isValid(5, 5, 2, 1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Bishop_returnName() {
		Bishop bishop = new Bishop(true, "bishop");
		String result = bishop.returnName();
		assertEquals(result, "Bishop");
	}
	
	
	@Test
	public void test_King_isValid0() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 5, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid1() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 6, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_King_isValid2() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 4, 4);
		assertEquals(result, false);
	}
	
	@Test
	public void test_King_isValid3() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 4, 3);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid4() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 4, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid5() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 3, 4);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid6() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 5, 4);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid7() {
		King king = new King(true, "king");
		boolean result = king.isValid(4, 4, 5, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_King_isFirst() {
		King king = new King (true, "king");
		boolean result = king.isFirst();
		assertEquals(result, true);
	}
	
	@Test
	public void test_king_changeIsFirst() {
		King king = new King (true, "king");
		king.changeisFirst();
		boolean result = king.isFirst();
		assertEquals(result, false);
	}
	
	@Test
	public void test_king_returnName(){
		King king = new King(true, "king");
		String result = king.returnName();
		assertEquals(result, "King");
	}
	
	
	@Test
	public void test_Knight_isValid0() {
		Knight knight = new Knight(true, "knight");
		boolean result = knight.isValid(4, 4, 7, 7);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Knight_isValid1() {
		Knight knight = new Knight(true, "knight");
		boolean result = knight.isValid(4, 4, 3, 6);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Knight_isValid2() {
		Knight knight = new Knight(true, "knight");
		boolean result = knight.isValid(4, 4, 3, 7);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Knight_isValid3() {
		Knight knight = new Knight(true, "knight");
		boolean result = knight.isValid(4, 4, 2, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Knight_isValid4() {
		Knight knight = new Knight(true, "knight");
		boolean result = knight.isValid(4, 4, 2, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Knight_returnName() {
		Knight knight = new Knight(true, "knight");
		String result = knight.returnName();
		assertEquals(result, "Knight");
	}
	
	@Test
	public void test_Pawn_atBoundary0() {
		Pawn pawn = new Pawn(true, "1");
		boolean result = pawn.atBoundary(7, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_atBoundary1() {
		Pawn pawn = new Pawn(true, "1");
		boolean result = pawn.atBoundary(5, 5);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_atBoundary2() {
		Pawn pawn = new Pawn(false, "1");
		boolean result = pawn.atBoundary(0, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_atBoundary3() {
		Pawn pawn = new Pawn(false, "1");
		boolean result = pawn.atBoundary(5, 5);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_getIsPassant() {
		Pawn pawn = new Pawn(true, "1");
		boolean result = pawn.getIsPassant();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_changePassantToTrue() {
		Pawn pawn = new Pawn(true, "1");
		pawn.changePassantToTrue();
		boolean result = pawn.getIsPassant();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_changePassantToFalse() {
		Pawn pawn = new Pawn(true, "1");
		pawn.changePassantToTrue();
		pawn.changePassantToFalse();
		boolean result = pawn.getIsPassant();
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_getIfFirstMove() {
		Pawn pawn = new Pawn(true, "1");
		boolean result = pawn.getIfFirstMove();
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_returnName() {
		Pawn pawn = new Pawn(true, "1");
		String result = pawn.returnName();
		assertEquals(result, "Pawn");
	}
	
	@Test
	public void test_Queen_isValid0() {
		Queen queen = new Queen(true, "1");
		boolean result = queen.isValid(3, 3, 5, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Queen_isValid1() {
		Queen queen = new Queen(true, "1");
		boolean result = queen.isValid(3, 3, 3, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Queen_isValid2() {
		Queen queen = new Queen(true, "1");
		boolean result = queen.isValid(3, 3, 5, 3);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Queen_isValid3() {
		Queen queen = new Queen(true, "1");
		boolean result = queen.isValid(3, 3, 4, 6);
		assertEquals(result, false);
	}
	
	
	@Test
	public void test_Queen_returnName() {
		Queen queen = new Queen(true, "1");
		String result = queen.returnName();
		assertEquals(result, "Queen");
	}
	/*
	@Test
	public void test_Pawn_isValid0() {
		Pawn pawn = new Pawn(true, "pawn");
		boolean result = pawn.isValid(4, 4, 4, 6);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid1() {
		Pawn pawn = new Pawn(true, "pawn");
		boolean result = pawn.isValid(4, 4, 4, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid2() {
		Pawn pawn = new Pawn(true, "pawn");
		boolean result = pawn.isValid(4, 4, 4, 7);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_isValid3() {
		Pawn pawn = new Pawn(false, "pawn");
		boolean result = pawn.isValid(4, 4, 4, 3);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid4() {
		Pawn pawn = new Pawn(false, "pawn");
		boolean result = pawn.isValid(4, 4, 4, 2);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid5() {
		Pawn pawn = new Pawn(false, "pawn");
		boolean result = pawn.isValid(4, 4, 4, 1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_isValid6() {
		Pawn pawn = new Pawn(true, "pawn");
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 4, 4, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid7() {
		Pawn pawn = new Pawn(true, "pawn");
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 4, 4, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_isValid8() {
		Pawn pawn = new Pawn(false, "pawn");
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 4, 4, 3);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid9() {
		Pawn pawn = new Pawn(false, "pawn");
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 4, 4, 2);
		assertEquals(result, false);
	}
	*/
}
