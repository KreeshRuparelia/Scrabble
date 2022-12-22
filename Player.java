public class Player {
    private int totalPoints;
    private Piece[] currentLetters;
    private Bag wordBag;
    private int consecutiveSkipsAndPasses;

    public Player() {

    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Piece[] getCurrentLetters() {
        return currentLetters;
    }

    public void setCurrentLetters(Piece[] currentLetters) {
        this.currentLetters = currentLetters;
    }

    public Bag getWordBag() {
        return wordBag;
    }

    public void setWordBag(Bag wordBag) {
        this.wordBag = wordBag;
    }

    public int getConsecutiveSkipsAndPasses() {
        return consecutiveSkipsAndPasses;
    }

    public void setConsecutiveSkipsAndPasses(int consecutiveSkipsAndPasses) {
        this.consecutiveSkipsAndPasses = consecutiveSkipsAndPasses;
    }
}
