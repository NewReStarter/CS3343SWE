# Bug Fix and refactor

### Bugs
- invalid input
    + empty cell
    + out of boundary

### Refactoring
- ChessBoard class
    + remove checkLongCastling() method
    + remove checkShortCastling() method
    + remove ifCheckMate() method
    + remove two check and use singleton of check instead
    + remove unreachable checking condition in the move method

- Main class
    + add Check class in Main Class to perform the above checking

- CmdMove class
    + add getInput() method to extract the method

- Check class
    + add singleton

### To-do
extract all the checking in the move() method of ChessBoard Class to check.
