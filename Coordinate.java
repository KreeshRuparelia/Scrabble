public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinate (String move) {
        if (!move.matches("[A-Oa-o][0-9][0-5]?")) {
            throw new IllegalArgumentException("Invalid Placement");
        }

        row = Integer.valueOf(move.substring(1)) - 1;
        col = "ABCDEFGHIJKLMNO".indexOf(move.substring(0, 1).toUpperCase());
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
