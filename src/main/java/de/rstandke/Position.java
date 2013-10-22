package de.rstandke;


/**
 * 2-D Position on a grid.
 * @author rstandke
 */
public class Position {
    private int x, y;

    /**
     * Creates a new Position. Values must be positive.
     * @param x horizontal value
     * @param y vertical value
     * @throws IllegalArgumentException if at least one value is negative
     */
    public Position(int x, int y) {
        //check parameters
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("starting point must not be < 0");
        }
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;

        return x == position.x && y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
