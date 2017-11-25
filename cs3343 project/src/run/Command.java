package run;

import Exception.ExOutOfBoard;

public interface Command {
	void execute() throws ExOutOfBoard;
}
