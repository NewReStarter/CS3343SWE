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

- Main class
    + add Check class in Main Class to perform the above checking

- CmdMove class
    + add getInput() method to extract the method
