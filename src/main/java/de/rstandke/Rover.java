package de.rstandke;

/**
 * @author rstandke
 * @version ${project.version}
 */
public class Rover {
    private final Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

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
            System.out.printf("moved to %s%n", position);
        }

    }

    private void turnRight() {
        switch (direction) {
            case EAST:this.direction = Direction.SOUTH;
            case WEST:this.direction = Direction.NORTH;
            case NORTH:this.direction = Direction.EAST;
            case SOUTH:this.direction = Direction.WEST;
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
        position.setY(position.getY() + 1);
    }

    private void stepNorth() {
        position.setY(position.getY() - 1);
    }

    private void stepWest() {
        position.setX(position.getX() - 1);
    }

    private void stepEast() {
        position.setX(position.getX() + 1);
    }

    public Position getPositionOnGrid() {
        return position;
    }
}
