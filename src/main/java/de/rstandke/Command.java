package de.rstandke;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rstandke
 */
public enum Command {
    BACKWARD, FORWARD, TURN_RIGHT, TURN_LEFT;

    public static Command[] parseString(String s) {
        List<Command> commandList = new ArrayList<>();
        for (char c : s.toCharArray()) {
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
        return commandList.toArray(new Command[]{});
    }
}
