package de.rstandke;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RoverTest {

    @Test
    public void createRover_validDirections_createsRoverObj () throws Exception {
        // arrange

        // act
        Rover rover = new Rover(1,1,Direction.NORTH);

        // assert
        assertThat(rover).isNotNull();

    }

    @Test(expected = IllegalArgumentException.class)
    public void createRover_invalidDirectionX_throwsException() throws Exception {
        // arrange

        // act
        new Rover(-1, 1, Direction.NORTH);

    }
    @Test(expected = IllegalArgumentException.class)
    public void createRover_invalidDirectionY_throwsException() throws Exception {
        // arrange

        // act
        new Rover(0, -42, Direction.NORTH);

    }



}
