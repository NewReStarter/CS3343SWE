package piece;
import java.util.*;

public abstract class Piece implements Cloneable{
	private boolean color;
	private String id;

	public boolean isValid(int x,int y,int target_x, int target_y) {
		return false;
	}

	public Piece makeCopy() throws CloneNotSupportedException{
		return (Piece) this.clone();
	}

	public void setColor(boolean color){
		this.color = color;
	}

	public void setId(String id){
		this.id = id;
	}
	public abstract String returnName();
	public boolean getColor(){
		return color;
	}
} 