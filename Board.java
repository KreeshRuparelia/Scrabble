import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
    private Tile[][] gameBoard;

    public Board() {
        gameBoard = new Tile[15][15];
    }

    public Board(Tile[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Tile[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Tile[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void generateSpecialTiles() {
    }

    public void generateBoard() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                gameBoard[x][y] = new Tile(new Coordinate(x, y), false); 
            }
        }

        gameBoard[7][7].setSpecialTileType("\u2605");
    }

    public void placeWord(String word, String orientation, String move) {

        Validator userMove = new Validator(gameBoard, word, orientation, move);

        if (!userMove.isValid()) {
            throw new InvalidMoveException();
        }

        Coordinate moveCoordinate = new Coordinate(move);
        int row = moveCoordinate.getRow();
        int col = moveCoordinate.getCol();

        for (int i = 0; i < word.length(); i++) {
            gameBoard[row][col].setPiece(new Piece(word.substring(i, i + 1), 1));
            gameBoard[row][col].setIsOccupied(true);;

            if (orientation.toUpperCase().equals("V")) {
                row++; 
            }

            else if (orientation.toUpperCase().equals("H")) {
                col++;
            }
        }
    }

    public String toString() {
        String output = "";
        
        for (int i = 0; i < 15; i++) {
            output += "     ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n";
            output += String.format("%s", i + 1);
            
            if (i + 1 >= 10) {
                output += "  |";
            }

            else {
                output += "   |";
            }

            for (int x = 0; x < 15; x++) {
                output += String.format("  %s  |", gameBoard[i][x]);
            }
            
            output += "\n";
        }

        output += "     ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n";

        output += "       A     B     C     D     E     F     G     H     I     J     K     L     M     N     O   ";

        return output;

    }
}