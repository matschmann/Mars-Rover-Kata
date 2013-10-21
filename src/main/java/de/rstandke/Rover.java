package de.rstandke;

/**
 * @author rstandke
 * @version ${project.version}
 */
public class Rover {
    public Rover(int x, int y, Direction direction) {
        //check parameters
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("starting point must not be < 0");
        }


    }

    public void go(Command... commands) {

    }

    public Position getPositionOnGrid() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
