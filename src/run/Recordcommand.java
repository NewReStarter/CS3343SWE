package run;

import java.util.ArrayList;

public abstract class Recordcommand implements Command{
	public abstract void undo();
	public abstract void redo();
	private static ArrayList<Recordcommand> undoList=new ArrayList<>();
	private static ArrayList<Recordcommand> redoList=new ArrayList<>();
	protected static void clearRedoList(){
		redoList.clear();
	}
	public static void undoOneCommand(){
   	 if(undoList.size()==0)
            System.out.println("Nothing to undo.");
        else
        undoList.remove(undoList.size()-1).undo();
   }
	public static void redoOneCommand(){
	    if(redoList.size()==0)
		       System.out.println("Nothing to redo.");
		else
		   redoList.remove(redoList.size()-1).redo();
	}
	public void addUndoCommand(Recordcommand x) {
        undoList.add(x);
    }
    public void addRedoCommand(Recordcommand x) {
        redoList.add(x);
    }
}
