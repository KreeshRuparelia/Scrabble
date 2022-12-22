public class Piece {
    private String letter;
    private int pointValue;

    public Piece(String letter, int pointValue) {
        this.letter = letter;
        this.pointValue = pointValue;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    @Override
    public String toString() {
        return letter;
    }
}
