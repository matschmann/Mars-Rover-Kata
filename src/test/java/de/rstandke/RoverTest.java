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

}
