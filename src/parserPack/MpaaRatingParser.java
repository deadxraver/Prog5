package parserPack;

import elementsPack.MpaaRating;
import exceptionsPack.IncorrectInputException;

public class MpaaRatingParser {
    /**
     * A method to parse the given string and return the corresponding MpaaRating.
     *
     * @param  line  the string to be parsed
     * @return       the corresponding MpaaRating, or null if the string is empty
     */
    public static MpaaRating parse(String line) throws IncorrectInputException {
        if (line.replaceAll(" ", "").isEmpty()) return null;
        line = line.toUpperCase().replaceAll("-", "_").replaceAll(" ", "");
        MpaaRating mpaaRating = line.equals("NC_17") ? MpaaRating.NC_17
                : line.equals("PG") ? MpaaRating.PG
                : line.equals("R") ? MpaaRating.R
                : null;
        if (mpaaRating == null) throw new IncorrectInputException();
        return mpaaRating;
    }
}
