package parserPack;

import elementsPack.Country;

public class CountryParser {
    /**
     * Parses the input line to determine the corresponding Country enum value.
     *
     * @param  line  the input line to be parsed
     * @return      the corresponding Country enum value, or null if not found
     */
    public static Country parse(String line) {
        line = line.toLowerCase().replaceAll(" ", "");
        return line.equals("china") ? Country.CHINA
                : line.equals("germany") ? Country.GERMANY
                : line.equals("japan") ? Country.JAPAN
                : line.equals("spain") ? Country.SPAIN
                : line.equals("vatican") ? Country.VATICAN
                : null;
    }
}
