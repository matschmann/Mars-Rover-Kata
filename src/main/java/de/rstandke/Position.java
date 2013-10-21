package de.rstandke;

import java.math.BigDecimal;

/**
 * @author rstandke
 * @version ${project.version}
 */
public class Position {
    private final int x, y;

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
}
