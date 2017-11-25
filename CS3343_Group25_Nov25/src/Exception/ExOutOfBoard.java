package Exception;

public class ExOutOfBoard extends Exception{
	public ExOutOfBoard(){
		super("Position is out of board!");
	}
	
	public ExOutOfBoard(String s){
		super(s);
	}
}
