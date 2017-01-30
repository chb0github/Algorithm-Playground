package org.bongiorno.games.tictactoe;


public class Square implements Comparable<Square> {
    private Integer x;
    private Integer y;
    private Character mark;

    public Square(Character mark, int x, int y) {
        this.x = x;
        this.y = y;
        this.mark = mark;
    }

    public boolean isAdjacent(Square other) {
        return sameRow(other) || sameColumn(other) || isDiagonalTo(other);
    }

    public  Boolean isDiagonalTo(Square other) {
        return Math.abs(getX() - other.getX()) == 1 && Math.abs(getY() - other.getY()) == 1;
    }

    public boolean sameRow(Square other) {
        return this.x.equals(other.x);
    }

    public boolean sameColumn(Square other) {
        return this.y.equals(other.y);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Character getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (!x.equals(square.x)) return false;
        return y.equals(square.y);

    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }

    public int compareTo(Square o) {
        int result = mark.compareTo(o.mark);
        if(result == 0) {
            result = this.x.compareTo(o.x);
            if(result == 0)
                result = this.y.compareTo(o.y);
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s:%d:%d",mark,x,y);
    }
}

