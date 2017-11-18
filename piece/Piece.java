package piece;
import java.util.*;

public abstract class Piece implements Cloneable{
	public boolean color;
	private String id;

	protected boolean isValid(int target_x, int target_y) {
		return false;
	}
	public abstract String move(int target_x, int target_y);

	public Piece makeCopy() throws CloneNotSupportedException{
		return (Piece) this.clone();
	}

	public void setColor(boolean color){
		this.color = color;
	}

	public void setId(String id){
		this.id = id;
	}

} 