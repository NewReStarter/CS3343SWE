package test;

import piece.*;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPiece {

	@Test
	public void test_Bishop_isValid0() {
		Bishop bishop = new Bishop(true, "bishop", 5, 5);
		boolean result = bishop.isValid(1, 1);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Bishop_isValid1() {
		Bishop bishop = new Bishop(true, "bishop", 5, 5);
		boolean result = bishop.isValid(2, 1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Bishop_move0() {
		Bishop bishop = new Bishop(true, "bishop", 5, 5);
		String result = bishop.move(2, 1);
		assertEquals(result, "Invalid Move");
	}

	@Test
	public void test_Bishop_move1() {
		Bishop bishop = new Bishop(true, "bishop", 5, 5);
		String result = bishop.move(2, 2);
		assertEquals(result, "(" + 2 + "," + 2 + ")");
	}
	
	@Test
	public void test_King_isValid0() {
		King king = new King(true, "king", 4, 4);
		boolean result = king.isValid(5, 5);
		assertEquals(result, false);
	}
	
	@Test
	public void test_King_isValid1() {
		King king = new King(true, "king", 4, 4);
		boolean result = king.isValid(6, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_King_isValid2() {
		King king = new King(true, "king", 4, 4);
		boolean result = king.isValid(4, 4);
		assertEquals(result, false);
	}
	
	@Test
	public void test_King_isValid3() {
		King king = new King(true, "king", 4, 4);
		boolean result = king.isValid(4, 3);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid4() {
		King king = new King(true, "king", 4, 4);
		boolean result = king.isValid(4, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid5() {
		King king = new King(true, "king", 4, 4);
		boolean result = king.isValid(3, 4);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_isValid6() {
		King king = new King(true, "king", 4, 4);
		boolean result = king.isValid(5, 4);
		assertEquals(result, true);
	}
	
	@Test
	public void test_King_move0() {
		King king = new King(true, "king", 4, 4);
		String result = king.move(5, 4);
		assertEquals(result, "(" + 5 + "," + 4 + ")");
	}
	
	@Test
	public void test_King_move1() {
		King king = new King(true, "king", 4, 4);
		String result = king.move(4, 4);
		assertEquals(result, "Invalid Move");
	}
	
	@Test
	public void test_Knight_isValid0() {
		Knight knight = new Knight(true, "knight", 4, 4);
		boolean result = knight.isValid(7, 7);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Knight_isValid1() {
		Knight knight = new Knight(true, "knight", 4, 4);
		boolean result = knight.isValid(3, 6);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Knight_isValid2() {
		Knight knight = new Knight(true, "knight", 4, 4);
		boolean result = knight.isValid(3, 7);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Knight_isValid3() {
		Knight knight = new Knight(true, "knight", 4, 4);
		boolean result = knight.isValid(2, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Knight_isValid4() {
		Knight knight = new Knight(true, "knight", 4, 4);
		boolean result = knight.isValid(2, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Knight_move0() {
		Knight knight = new Knight(true, "knight", 4, 4);
		String result = knight.move(2, 6);
		assertEquals(result, "Invalid Move");
	}
	
	@Test
	public void test_Knight_move1() {
		Knight knight = new Knight(true, "knight", 4, 4);
		String result = knight.move(2, 5);
		assertEquals(result, "(" + 2 + "," + 5 +")");
	}
	
	@Test
	public void test_Pawn_isValid0() {
		Pawn pawn = new Pawn(true, "pawn", 4, 4);
		boolean result = pawn.isValid(4, 6);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid1() {
		Pawn pawn = new Pawn(true, "pawn", 4, 4);
		boolean result = pawn.isValid(4, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid2() {
		Pawn pawn = new Pawn(true, "pawn", 4, 4);
		boolean result = pawn.isValid(4, 7);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_isValid3() {
		Pawn pawn = new Pawn(false, "pawn", 4, 4);
		boolean result = pawn.isValid(4, 3);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid4() {
		Pawn pawn = new Pawn(false, "pawn", 4, 4);
		boolean result = pawn.isValid(4, 2);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid5() {
		Pawn pawn = new Pawn(false, "pawn", 4, 4);
		boolean result = pawn.isValid(4, 1);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_isValid6() {
		Pawn pawn = new Pawn(true, "pawn", 4, 4);
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 5);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid7() {
		Pawn pawn = new Pawn(true, "pawn", 4, 4);
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 6);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_isValid8() {
		Pawn pawn = new Pawn(false, "pawn", 4, 4);
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 3);
		assertEquals(result, true);
	}
	
	@Test
	public void test_Pawn_isValid9() {
		Pawn pawn = new Pawn(false, "pawn", 4, 4);
		pawn.setIfFirst(false);
		boolean result = pawn.isValid(4, 2);
		assertEquals(result, false);
	}
	
	@Test
	public void test_Pawn_move0() {
		Pawn pawn = new Pawn(false, "pawn", 4, 4);
		pawn.setIfFirst(false);
		String result = pawn.move(4, 3);
		assertEquals(result, "(4,3)");
	}
	
	@Test
	public void test_Pawn_move1() {
		Pawn pawn = new Pawn(false, "pawn", 4, 4);
		pawn.setIfFirst(false);
		String result = pawn.move(4, 2);
		assertEquals(result, "Invalid Move");
	}
}
