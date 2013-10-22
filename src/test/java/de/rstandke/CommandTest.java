package de.rstandke;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author rstandke
 */
public class CommandTest {

    @Test
    public void parseString_validCommands_success() throws Exception {
        // arrange

        // act
        final Command[] commands = Command.parseString("fbBFlrLR");

        // assert
        assertThat(commands[0]).isEqualTo(Command.FORWARD);
        assertThat(commands[1]).isEqualTo(Command.BACKWARD);
        assertThat(commands[2]).isEqualTo(Command.BACKWARD);
        assertThat(commands[3]).isEqualTo(Command.FORWARD);
        assertThat(commands[4]).isEqualTo(Command.TURN_LEFT);
        assertThat(commands[5]).isEqualTo(Command.TURN_RIGHT);
        assertThat(commands[6]).isEqualTo(Command.TURN_LEFT);
        assertThat(commands[7]).isEqualTo(Command.TURN_RIGHT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseString_unknownCommand_throwsException() throws Exception {
        // act
        Command.parseString("weep");
    }
}
