package parserPack;

import elementsPack.MovieGenre;
import exceptionsPack.NullFieldException;

public class GenreParser {
    /**
     * Parses the given string to a MovieGenre.
     *
     * @param  line  the string to be parsed
     * @return      the parsed MovieGenre
     */
    public static MovieGenre parse(String line) throws NullFieldException {
        line = line.toLowerCase().replaceAll(" ", "");
        if (line.isEmpty()) throw new NullFieldException();
        return line.equals("drama") ? MovieGenre.DRAMA
                : line.equals("fantasy") ? MovieGenre.FANTASY
                : line.equals("tragedy") ? MovieGenre.TRAGEDY
                : line.equals("western") ? MovieGenre.WESTERN
                : null;
    }
}
