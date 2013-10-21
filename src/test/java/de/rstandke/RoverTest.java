package de.rstandke;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RoverTest {

    @Test
    public void createRover_validDirections_createsRoverObj () throws Exception {
        // arrange

        // act
        Rover rover = new Rover(new Position(1,1),Direction.NORTH);

        // assert
        assertThat(rover).isNotNull();

    }

    @Test
    public void go_DirectionIsEastCommandsAreFBFFB_1() throws Exception {
        // arrange

        // act
        Rover rover = new Rover(new Position(0, 0), Direction.EAST);
        rover.go(Command.FORWARD, Command.BACKWARD, Command.FORWARD, Command.FORWARD, Command.BACKWARD);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getX()).isEqualTo(1);
    }

    @Test
    public void go_DirectionIsEastCommandsAreFBFFFBF_3() throws Exception {
        // arrange

        // act
        Rover rover = new Rover(new Position(0, 0), Direction.EAST);
        rover.go(Command.FORWARD, Command.BACKWARD, Command.FORWARD, Command.FORWARD, Command.FORWARD, Command.BACKWARD, Command.FORWARD);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getX()).isEqualTo(3);
    }


    @Test
    public void go_DirectionIsWestCommandsAreBFF_3() throws Exception {
        // arrange

        // act
        Rover rover = new Rover(new Position(5, 0), Direction.WEST);
        rover.go(Command.BACKWARD, Command.FORWARD, Command.FORWARD);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getX()).isEqualTo(4);
    }

    @Test
    public void go_DirectionIsSouthtCommandsAreBFF_3() throws Exception {
        // arrange

        // act
        Rover rover = new Rover(new Position(2, 2), Direction.SOUTH);
        rover.go(Command.BACKWARD, Command.FORWARD, Command.FORWARD);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getY()).isEqualTo(3);
    }

    @Test
    public void go_DirectionIsNorthCommandsAreBFF_3() throws Exception {
        // arrange

        // act
        Rover rover = new Rover(new Position(2, 2), Direction.NORTH);
        rover.go(Command.BACKWARD, Command.FORWARD, Command.FORWARD);

        // assert
        assertThat(rover).isNotNull();
        assertThat(rover.getPositionOnGrid().getY()).isEqualTo(1);
    }





}
