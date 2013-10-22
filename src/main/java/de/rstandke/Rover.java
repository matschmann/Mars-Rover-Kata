package de.rstandke;

/**
 * A rover is a vehicle that can be moved on a grid. The grid is a coordinate from (0,0) to (MAX_INT, MAX_INT).
 * If the Rover steps over the edge of the grid, it wraps around and the rover will be at position 0.
 * @author rstandke
 */
public class Rover {
    private final Position position;
    private Direction direction;

    /**
     * Creates a new Rover.
     * @param position initial position
     * @param direction initial direction
     */
    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    /**
     * Moves the rover around.
     * @param commands moving commands
     * @throws IllegalArgumentException if command is unknown
     */
    public void go(Command... commands) {
        for (Command command : commands) {
            switch (command) {
                case FORWARD: stepForward(); break;
                case BACKWARD: stepBackward(); break;
                case TURN_RIGHT: turnRight(); break;
                case TURN_LEFT: turnRight(); turnRight(); turnRight(); break;
                default:
                    throw new IllegalArgumentException("command is " + command + " is not yet supported");
            }
            System.out.printf("moved to %s, direction is %s %n", position, direction);
        }
    }

    /**
     * Moves the rover around. Commands are
     * <ul>
     *     <li>'f' for forward</li>
     *     <li>'b' for backward</li>
     *     <li>'l' for turning left</li>
     *     <li>'r' for turning right</li>
     * </ul>
     * @param commands
     * @throws IllegalArgumentException if command is unknown
     */
    public void go(String commands) {
        go(Command.parseString(commands));
    }

    /**
     * @return the current position of the rover on the grid.
     */
    public Position getPositionOnGrid() {
        return position;
    }

    private void turnRight() {
        switch (direction) {
            case EAST:this.direction = Direction.SOUTH; break;
            case SOUTH:this.direction = Direction.WEST; break;
            case WEST:this.direction = Direction.NORTH; break;
            case NORTH:this.direction = Direction.EAST; break;
        }
    }

    private void stepBackward() {
        switch (direction) {
            case EAST:stepWest(); break;
            case WEST:stepEast(); break;
            case NORTH:stepSouth(); break;
            case SOUTH:stepNorth(); break;
            default:
                throw new IllegalArgumentException("direction is " + direction + " is not yet supported");

        }
    }

    private void stepForward() {
        switch (direction) {
            case EAST:stepEast(); break;
            case WEST:stepWest(); break;
            case NORTH:stepNorth(); break;
            case SOUTH:stepSouth(); break;
            default:
                throw new IllegalArgumentException("direction is " + direction + " is not yet supported");
        }
    }


    private void stepSouth() {
        if (position.getY() == Integer.MAX_VALUE) {
            position.setY(0);
        } else {
            position.setY(position.getY() + 1);
        }
    }

    private void stepNorth() {
        if (position.getY() == 0) {
            position.setY(Integer.MAX_VALUE);
        } else {
            position.setY(position.getY() - 1);
        }
    }

    private void stepWest() {
        if (position.getX() == 0) {
            position.setX(Integer.MAX_VALUE);
        } else {
            position.setX(position.getX() - 1);
        }
    }

    private void stepEast() {
        if (position.getX() == Integer.MAX_VALUE) {
            position.setX(0);
        } else {
            position.setX(position.getX() + 1);
        }
    }

}
