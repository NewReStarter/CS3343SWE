package piece;

public class King extends Piece{
	private int x;
	private int y;
	private boolean isFirst;
	
	public King(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		setX(x);
		setY(y);
		isFirst = true;
	}
	
	
	protected boolean isValidSp(int target_x, int target_y){
		if(isFirst&&Math.abs(x-target_x)==2)
			return true;
		else
			return false;
	}
	
	
	@Override
	public boolean isValid(int target_x, int target_y) {
		if (x == target_x && (y - target_y == 1 || y - target_y == -1))
			return true;
		if (y == target_y && (x - target_x == 1 || x - target_x == -1))
			return true;
		return false;
	}
	public String move(int target_x, int target_y){
		if(isValid(target_x,target_y)||isValidSp(target_x,target_y)){
			setX(target_x);
			setY(target_y);
			if(isFirst){
				isFirst = false;
			}
			return "("+x+","+y+")";
		}
		else
			return "Invalid Move";
	}

	public boolean isFirst(){return isFirst;}
	
	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}
}
