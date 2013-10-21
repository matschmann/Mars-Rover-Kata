package de.rstandke;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RoverTest {

    @Test
    public void createRover_validDirections_createsRoverObj () throws Exception {
        // arrange
        final Position position = new Position(1, 1);
        final Direction direction = Direction.NORTH;

        // act
        Rover rover = new Rover(position, direction);

        // assert
        assertThat(rover).isNotNull();

    }

    @Test
    public void go_DirectionIsEastCommandsAreFBFFB_1() throws Exception {
        // arrange
        final Position position = new Position(0, 0);
        final Direction direction = Direction.EAST;
        final Command[] commands = {Command.FORWARD, Command.BACKWARD, Command.FORWARD, Command.FORWARD, Command.BACKWARD};

        // act
        Rover rover = new Rover(position, direction);
        rover.go(commands);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getX()).isEqualTo(1);
    }

    @Test
    public void go_DirectionIsEastCommandsAreFBFFFBF_3() throws Exception {
        // arrange
        final Position position = new Position(0, 0);
        final Direction direction = Direction.EAST;
        final Command[] commands = {Command.FORWARD, Command.BACKWARD, Command.FORWARD, Command.FORWARD,
                Command.FORWARD, Command.BACKWARD, Command.FORWARD};

        // act
        Rover rover = new Rover(position, direction);
        rover.go(commands);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getX()).isEqualTo(3);
    }


    @Test
    public void go_DirectionIsWestCommandsAreBFF_3() throws Exception {
        // arrange
        final Position position = new Position(5, 0);
        final Direction direction = Direction.WEST;
        final Command[] commands = {Command.BACKWARD, Command.FORWARD, Command.FORWARD};

        // act
        Rover rover = new Rover(position, direction);
        rover.go(commands);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getX()).isEqualTo(4);
    }

    @Test
    public void go_DirectionIsSouthtCommandsAreBFF_3() throws Exception {
        // arrange
        final Position position = new Position(2, 2);
        final Direction direction = Direction.SOUTH;
        final Command[] commands = {Command.BACKWARD, Command.FORWARD, Command.FORWARD};

        // act
        Rover rover = new Rover(position, direction);
        rover.go(commands);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getY()).isEqualTo(3);
    }

    @Test
    public void go_DirectionIsNorthCommandsAreBFF_3() throws Exception {
        // arrange
        final Position position = new Position(2, 2);
        final Direction direction = Direction.NORTH;
        final Command[] commands = {Command.BACKWARD, Command.FORWARD, Command.FORWARD};

        // act
        Rover rover = new Rover(position, direction);
        rover.go(commands);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getY()).isEqualTo(1);
    }

    @Test
    public void go_aRightCircle_shouldArriveAtStartPosition() throws Exception {
        // arrange
        final Position startPosition = new Position(10, 10);
        final Command[] commands = {Command.TURN_RIGHT, Command.FORWARD, Command.TURN_RIGHT, Command.FORWARD, Command.TURN_RIGHT, Command.FORWARD, Command.TURN_RIGHT, Command.FORWARD};
        final Direction direction = Direction.EAST;

        // act
        Rover rover = new Rover(startPosition, direction);
        rover.go(commands);


        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid()).isEqualTo(startPosition);

    }

    @Test
    public void go_aLeftCircle_shouldArriveAtStartPosition() throws Exception {
        // arrange
        final Position startPosition = new Position(10, 10);
        final Direction direction = Direction.EAST;
        final Command[] commands = {Command.TURN_LEFT, Command.FORWARD, Command.TURN_LEFT, Command.FORWARD, Command.TURN_LEFT, Command.FORWARD, Command.TURN_LEFT, Command.FORWARD};

        // act
        Rover rover = new Rover(startPosition, direction);
        rover.go(commands);


        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid()).isEqualTo(startPosition);
    }

    @Test
    public void promenade() throws Exception {
        // arrange
        Position startPos = new Position(3, 4);
        Direction startDirection = Direction.EAST;
        Command[] commands = new Command[]{Command.FORWARD, Command.FORWARD, Command.TURN_LEFT, Command.BACKWARD,
                Command.TURN_LEFT, Command.FORWARD, Command.FORWARD, Command.FORWARD, Command.TURN_RIGHT,
                Command.FORWARD, Command.FORWARD, Command.FORWARD, Command.TURN_LEFT, Command.FORWARD,
                Command.TURN_RIGHT, Command.FORWARD};

        // act
        Rover rover = new Rover(startPos, startDirection);
        rover.go(commands);

        // assert
        assertThat(rover.getPositionOnGrid()).isEqualTo(new Position(1, 1));
    }

}
