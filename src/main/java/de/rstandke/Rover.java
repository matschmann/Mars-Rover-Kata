package de.rstandke;

/**
 * @author rstandke
 * @version ${project.version}
 */
public class Rover {
    private final Position position;
    private final Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void go(Command... commands) {

    }

    public Position getPositionOnGrid() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
