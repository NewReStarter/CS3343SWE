package chess;

import java.util.*;
import piece.Piece;

public class Cell 
{
	private Piece piece;
	private int x, y;
	
	public Cell(int x, int y, Piece p)
	{
		this.x = x;
		this.y = y;
		if(p != null)
		{
			setPiece(p);
		}
	}

	private void setPiece(Piece p) 
	{
		piece = p;
	}
	
	private void removePiece()
	{
		piece = null;
	}

	public Piece getpiece() 
	{
		return this.piece;
	}
	
}

