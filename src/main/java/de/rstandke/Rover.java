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
        for (Command command : commands) {
            switch (command) {
                case FORWARD:
                    stepForward();
                    break;
                case BACKWARD:
                    stepBackward();
                    break;
            }
        }

    }

    private void stepBackward() {
        if (direction == Direction.EAST) {
            stepWest();
        } else if (direction == Direction.WEST) {
            stepEast();
        } else if (direction == Direction.NORTH) {
            stepSouth();
        }  else if (direction == Direction.SOUTH) {
            stepNorth();
        }
    }

    private void stepForward() {
        if (direction == Direction.EAST) {
            stepEast();
        } else if (direction == Direction.WEST) {
            stepWest();
        } else if (direction == Direction.NORTH) {
            stepNorth();
        }  else if (direction == Direction.SOUTH) {
            stepSouth();
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
