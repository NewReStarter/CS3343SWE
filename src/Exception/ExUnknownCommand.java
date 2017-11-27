package Exception;

public class ExUnknownCommand extends Exception{
	public ExUnknownCommand(){
		super("Unknown command - ignored!");
	}
	public ExUnknownCommand(String s){
		super(s);
	}
}
