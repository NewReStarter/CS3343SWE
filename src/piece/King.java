package piece;



public class King extends Piece{
	
	private boolean isFirst;
	public King(boolean color, String id){
		setColor(color);
		setId(id);
		
		isFirst = true;
	}
	
	
	public boolean isValid(int x,int y,int target_x, int target_y) {

		if (x == target_x && (y - target_y == 1 || y - target_y == -1))
			return true;
		if (y == target_y && (x - target_x == 1 || x - target_x == -1))
			return true;
		if(Math.abs(target_x-x) == 1 && Math.abs(target_y-y)==1)
			return true;
		return false;
	}
	

	public boolean isFirst(){return isFirst;}
	
	public void changeisFirst(){
		isFirst= false;
	}
	public String returnName(){
		return "King";
	}

}
