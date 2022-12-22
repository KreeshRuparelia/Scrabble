public class Tile {
    private Coordinate position;
    private String specialTileType;
    private boolean isOccupied = false;
    private Piece piece;

    public Tile(Coordinate position, String specialTileType, boolean isOccupied, Piece piece) {
        this.position = position;
        this.specialTileType = specialTileType;
        this.isOccupied = isOccupied;
        this.piece = piece;
    }

    public Tile(Coordinate position, String specialTileType, boolean isOccupied) {
        this.position = position;
        this.specialTileType = specialTileType;
        this.isOccupied = isOccupied;
    }

    public Tile(Coordinate position, boolean isOccupied) {
        this.position = position;
        this.specialTileType = "Normal";
        this.isOccupied = isOccupied;
    }

    public Tile clone(Tile other) {
        return new Tile(other.getPosition(), other.getSpecialTileType(), other.getIsOccupied(), other.getPiece());
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }
    
    public String getSpecialTileType() {
        return specialTileType;
    }
    
    public void setSpecialTileType(String specialTileType) {
        this.specialTileType = specialTileType;
    }
    
    public boolean getIsOccupied() {
        return isOccupied;
    }
    
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    @Override
    public String toString() {
        if (piece != null) {
            return piece.toString();
        }

        else if (specialTileType == null || specialTileType.equals("Normal")) {
            return " ";
        }

        else {
            return specialTileType;
        }
    }
}