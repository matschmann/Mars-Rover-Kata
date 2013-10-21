package de.rstandke;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

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
        for (Command command : commands) {
            switch (command) {
                case FORWARD:
                    position.setX(position.getX() + 1);
                    break;
                case BACKWARD:
                    position.setX(position.getX() - 1);
                    break;
            }
        }

    }

    public Position getPositionOnGrid() {
        return position;
    }
}
