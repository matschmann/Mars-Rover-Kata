package de.rstandke;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author rstandke
 * @version ${project.version}
 */
public class PositionTest {

    @Test
    public void createPosition_validValues_positionObj() throws Exception {
        // arrange
        final int expectedX = 1;
        final int expectedY = 1;

        // act
        Position position = new Position(expectedX, expectedY);

        // assert

        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedX);
        assertThat(position.getY()).isEqualTo(expectedY);

    }

    @Test(expected = IllegalArgumentException.class)
    public void createPosition_invalidValueX_throwsException() throws Exception {
        // arrange

        // act
        new Position(-1, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createPosition_invalidValueY_throwsException() throws Exception {
        // arrange

        // act
        new Position(1, -1);
    }
}
