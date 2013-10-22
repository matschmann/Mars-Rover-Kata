package de.rstandke;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rstandke
 */
public enum Command {
    BACKWARD, FORWARD, TURN_RIGHT, TURN_LEFT;

    /**
     * Takes a String with command letters an transforms it into a command array. Commands are
     * <ul>
     *     <li>'f' for Forward</li>
     *     <li>'b' for Backward</li>
     *     <li>'l' for turning left</li>
     *     <li>'r' for turning right</li>
     * </ul>
     * @param commandString command string
     * @return an array of commands
     * @throws IllegalArgumentException if command is unknown
     */
    public static Command[] parseString(String commandString) {
        List<Command> commandList = new ArrayList<>();
        for (char c : commandString.toCharArray()) {
            switch (c) {
                case 'b':
                case 'B':
                    commandList.add(BACKWARD);
                    break;
                case 'f':
                case 'F':
                    commandList.add(FORWARD);
                    break;
                case 'l':
                case 'L':
                    commandList.add(TURN_LEFT);
                    break;
                case 'r':
                case 'R':
                    commandList.add(TURN_RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException("command is " + c + " is not yet supported");

            }
        }
        return commandList.toArray(new Command[commandList.size()]);
    }
}
