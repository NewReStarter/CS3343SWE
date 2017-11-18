package piece;

public class Pawn extends Piece{
	private int x;
	private int y;
	private boolean ifFirst;
	//private boolean passant; 满足过路兵被吃的条件
	public Pawn(boolean color, String id, int x, int y){
		setColor(color);
		setId(id);
		setX(x);
		setY(y);
		ifFirst = true;
	}
	
	//addition part for special movement
		/*
		isPassant(){
			return passant;
		}
		
		
		protected boolean isValidSp(int target_x, int target_y){//过路兵-对方必须是起始走两步或 吃子
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
	protected boolean isValid(int target_x, int target_y){
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
}
