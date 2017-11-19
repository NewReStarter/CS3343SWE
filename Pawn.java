package piece;

public class Pawn extends Piece{
	private int x;
	private int y;
	private boolean ifFirst;
	//private boolean passant; 
	
	public Pawn(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		setX(x);
		setY(y);
		ifFirst = true;
		//passant = false;
		
	}
	
	//addition part for special movement
	
		/*
		 * 
		public boolean atBoundary(){
			if(this.color)
				if(y == 7)
					return true;
			else
				if(y == 0)
					return true;
			return false;	
		}
		
		public boolean isPassant(){
			return passant;
		}
		
		public void changePassant(){
			passant = !passant;
		}
		
		
		protected boolean isValidSp(int target_x, int target_y) {
			if(this.color){
				if(target_y - y == 1 && Math.abs(target_x - x) == 1)
					return true;
				else
					return false;
			}
			else
				if(target_y - y == -1 || Math.abs(target_x - x) == 1)
					return true;
				else
					return false;
		}
		
		*/
	
	@Override
	public boolean isValid(int target_x, int target_y){
		if(ifFirst){
			if(this.color){
				if(target_y - y == 2 || target_y - y == 1)
					return true;
				else
					return false;
			}
			else
				if(target_y - y == -2 || target_y - y == -1)
					return true;
				else
					return false;
		}
		else{
			if(this.color){
				if(target_y - y == 1)
					return true;
				else
					return false;
			}
			else{
				if(target_y - y == -1)
					return true;
				else
					return false;
			}
		}

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
	
	public void setIfFirst(boolean ifFirst) {
		this.ifFirst = ifFirst;
	}
}
