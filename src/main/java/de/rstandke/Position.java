package de.rstandke;

import java.math.BigDecimal;

/**
 * @author rstandke
 * @version ${project.version}
 */
public class Position {
    private int x, y;

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
}
