import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Validator {
    Board gameBoard;
    String userWord;
    String orientation;
    String move;

    public Validator(Tile[][] gameBoard, String userWord, String orientation, String move) {
        this.gameBoard = new Board(gameBoard);
        this.userWord = userWord;
        this.orientation = orientation;
        this.move = move;
    }   

    private boolean validTilePlacement() {
        try {
            gameBoard.placeWord(userWord, orientation, move); 
            return true;
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean validWord() {
        File wordList = new File("words.txt");
    
        try {
            Scanner scanner = new Scanner(wordList);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                if (userWord.toLowerCase().equals(nextLine)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("file 'words.txt' not found. change name to 'words.txt' if word list is in folder.");
        }
        return false;
    }

    private boolean validStart() {
        if (gameBoard.getGameBoard()[7][7].getIsOccupied()) {
            return true;
        }

        else {
            Coordinate moveCoordinate = new Coordinate(move);
            int row = moveCoordinate.getRow();
            int col = moveCoordinate.getCol();

            for (int i = 0; i < userWord.length(); i++) {

                if (row == 7 && col == 7) {
                    return true;
                }

                else if (orientation.toUpperCase().equals("V")) {                    
                    row++;
                }

                else if (orientation.toUpperCase().equals("H")) {
                    col++;
                }
            }
            return false;
        }
    }

    private boolean adjacent(int row, int col) {
        if (orientation.equals("V")) {
            for (int i = -1; i < 2; i += 2) {
                if (gameBoard.getGameBoard()[row][col + i].getIsOccupied()) {
                    return true;
                }
            }
        }

        else if (orientation.equals("H")) {
            for (int i = -1; i < 2; i += 2) {
                if (gameBoard.getGameBoard()[row + i][col].getIsOccupied()) {
                    return true;
                }
            }
        }

        return false;
    } 

    private boolean validPiecePlacement() {
        
        Coordinate moveCoordinate = new Coordinate(move); 
        int row = moveCoordinate.getRow();
        int col = moveCoordinate.getCol();

        for (int i = 0; i < userWord.length(); i++) {
            try {
                if (gameBoard.getGameBoard()[row][col].getIsOccupied()) {
                    if (!gameBoard.getGameBoard()[row][col].getPiece().toString().equals(userWord.substring(i, i + 1))) {
                        return false;
                    }
                }

                else {
                    if (adjacent(row, col)) {
                        return true;
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("array out of bounds");
            }

            if (orientation.equals("V")) {
                row++;
            }

            else if (orientation.equals("H")) {
                col++;
            }
            
        }
        return false;
    }
    
    public boolean isValid() {
        if (validWord() && validPiecePlacement()) {
            return true;
        }

        return false;
    }
}
