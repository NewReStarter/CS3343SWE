package piece;
import java.lang.Math;

public class Queen extends Piece{
	private int x;
	private int y;
	public Queen(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		setX(x);
		setY(y);
	}
	@Override
	public boolean isValid(int target_x, int target_y){
		if(Math.abs(x-target_x) != Math.abs(y-target_y) || (target_x == x && target_y != y) || (target_y == y && target_x != x))
			return false;
		else
			return true;
	}
	public String move(int target_x, int target_y){
		if(isValid(target_x,target_y)){
			setX(target_x);
			setY(target_y);
			return "("+x+","+y+")";
		}
		else
			return "Invalid Move";
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}
}
