package parserPack;

import exceptionsPack.NullFieldException;

public class IntParser {
    public static final int LOWER_OSCAR_BOUND = 0;
    /**
     * Parses the given string to an integer after removing underscores.
     *
     * @param  line  the string to be parsed
     * @return       the parsed integer value
     */
    public static int parse(String line) throws NumberFormatException, NullFieldException {
        if (line.isEmpty()) throw new NullFieldException();
        line = line.replaceAll("_", "");
        return Integer.parseInt(line);
    }
}
