import java.util.Scanner;

public class Scrabble {
    public static void main(String[] args) {
        Board g = new Board();
        g.generateBoard();
        System.out.println(g.toString());

        Scanner input = new Scanner(System.in);
        System.out.print("word: ");
        String word = input.nextLine();
        System.out.print("v or h: ");
        String orientation = input.nextLine();
        System.out.print("move: ");
        String move = input.nextLine();
        input.close();
        
        g.placeWord(word, orientation, move);
        
        System.out.println(g.toString());
    }   
}
