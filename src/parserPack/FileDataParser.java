package parserPack;

import elementsPack.Color;
import elementsPack.Country;
import exceptionsPack.IncorrectInputException;
import exceptionsPack.NullFieldException;
import exceptionsPack.NumberOutOfBoundsException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class FileDataParser {
    /**
     * Parses the given big line to extract specific fields and return the modified big line.
     *
     * @param  bigLine   the big line to be parsed
     * @return          the modified big line after parsing
     */
    public static String parse(String bigLine) {
        while (bigLine.contains("> ")) bigLine = bigLine.replaceAll("> ", ">");
        String[] allLines = bigLine.split("</movie><movie>");
        for (int i = 0; i < allLines.length; i++) {
            String line = allLines[i];
            try {
                if (line.contains("<id>")) LongParser.parse(line.substring(line.indexOf("<id>") + 4, line.indexOf("</id>")));
            } catch (NullFieldException | NumberFormatException e) {
                line = line.replaceAll("<id>.*</id>", "");
            }
            try {
                if (line.contains("<x>")) FloatParser.parse(line.substring(line.indexOf("<x>") + 3, line.indexOf("</x>")));
            } catch (NullFieldException | NumberFormatException e) {
                line = line.replaceAll("<x>.*</x>", "");
            }
            try {
                if (line.contains("<y>")) DoubleParser.parse(line.substring(line.indexOf("<y>") + 3, line.indexOf("</y>")));
            } catch (NumberOutOfBoundsException | NullFieldException | NumberFormatException e) {
                line = line.replaceAll("<y>.*</y>", "");
            }
            try {
                if (line.contains("<genre>")) GenreParser.parse(line.substring(line.indexOf("<genre>") + 7, line.indexOf("</genre>")));
            } catch (NullFieldException e) {
                line = line.replaceAll("<genre>.*</genre>", "");
            }
            try {
                if (line.contains("<creationDate>")) LocalDate.parse(line.substring(line.indexOf("<creationDate>") + 14, line.indexOf("</creationDate>")));
            } catch (DateTimeParseException e) {
                line = line.replaceAll("<creationDate>.*</creationDate>", "");
            }
            try {
                if (line.contains("<oscarsCount>")) IntParser.parse(line.substring(line.indexOf("<oscarsCount>") + 13, line.indexOf("</oscarsCount>")));
            } catch (NullFieldException | NumberFormatException e) {
                line = line.replaceAll("<oscarsCount>.*</oscarsCount>", "");
            }
            try {
                if (line.contains("<mpaaRating>")) MpaaRatingParser.parse(line.substring(line.indexOf("<mpaaRating>") + 12, line.indexOf("</mpaaRating>")));
            } catch (IncorrectInputException e) {
                line = line.replaceAll("<mpaaRating>.*</mpaaRating>", "");
            }
            try {
                if (line.contains("<birthday>")) LocalDateTime.parse(line.substring(line.indexOf("<birthday>") + 10, line.indexOf("</birthday>")));
            } catch (DateTimeParseException e) {
                line = line.replaceAll("<birthday>.*</birthday>", "");
            }
            if (line.contains("<hairColor>")) {
                Color color = ColorParser.parse(line.substring(line.indexOf("<hairColor>") + 11, line.indexOf("</hairColor>")));
                if (color == null) line = line.replaceAll("<hairColor>.*</hairColor>", "");
            }
            if (line.contains("<nationality>")) {
                Country country = CountryParser.parse(line.substring(line.indexOf("<nationality>") + 13, line.indexOf("</nationality>")));
                if (country == null) line = line.replaceAll("<nationality>.*</nationality>", "");
            }
            allLines[i] = line;
        }
        return String.join("</movie><movie>", allLines);
    }

}
