package piece;

public class Knight extends Piece{
	private int x;
	private int y;
	public Knight(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		setX(x);
		setY(y);
	}
	@Override
	protected boolean isValid(int target_x, int target_y){
		if(Math.abs(target_x-x) == 1){
			if(Math.abs(target_y-y) == 2)
				return true;
			else
				return false;
		}
		else if(Math.abs(target_x-x) == 2){
			if(Math.abs(target_y-y) == 1)
				return true;
			else
				return false;
		}
		else
			return false;
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
