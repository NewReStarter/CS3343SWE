package piece;

public class Rook extends Piece{
	private int x;
	private int y;
	//private boolean isFirst;
	public Rook(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		setX(x);
		setY(y);
		//isFirst = true;
	}
	
	//addition part for special movement
		/*
		protected boolean isValidSp(int target_x, int target_y){
			if(isFirst&&Math.abs(x-target_x)==2)
				return true;
			else
				return false;
		
		*/
	
	@Override
	public boolean isValid(int target_x, int target_y){
		if(x == target_x && y != target_y)
			return true;
		else if(y == target_y && x!= target_x)
			return true;
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
