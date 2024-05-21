package parserPack;

import elementsPack.Color;

public class ColorParser {
    /**
     * Parses the given input string and returns the corresponding Color value.
     *
     * @param  line  the input string to be parsed
     * @return       the Color value corresponding to the input string, or null if no match is found
     */
    public static Color parse(String line) {
        line = line.toLowerCase().replaceAll(" ", "");
        return line.equals("green") ? Color.GREEN
                : line.equals("orange") ? Color.ORANGE
                : line.equals("white") ? Color.WHITE
                : null;
    }
}
