package commandsPack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import elementsPack.*;
import mainPack.MovieCollection;
import parserPack.CollectionParser;
import parserPack.FileDataParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class storing all commands
 */
public final class AllCommands extends PrintFieldAscendingOperator {
    public AllCommands() {
        xStream = new XStream();
        xStream.ignoreUnknownElements();
        declareClasses();
        this.collection = loadFromFile();
        this.reader = new Scanner(System.in);
    }

    /**
     * @return loads data from xml document
     */
    private MovieCollection loadFromFile() {

        String fileContent = "";
        try {
            Scanner scanner = new Scanner(new FileReader(System.getenv("VAR")));
            while (scanner.hasNext()) {
                fileContent += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("No file declared in environment");
            System.exit(-1);
        }
        return fileContent.isEmpty() ? new MovieCollection() :
                CollectionParser.parse((MovieCollection) xStream.fromXML(FileDataParser.parse(fileContent)));
    }

    /**
     * Method which makes XStream understand non-primitive fields
     */
    private void declareClasses() {
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.alias("movieCollection", MovieCollection.class);
        xStream.alias("collection", LinkedList.class);
        xStream.alias("dateOfCreation", LocalDateTime.class);
        xStream.alias("movie", Movie.class);
        xStream.alias("coordinates", Coordinates.class);
        xStream.alias("creationDate", LocalDate.class);
        xStream.alias("genre", MovieGenre.class);
        xStream.alias("mpaaRating", MpaaRating.class);
        xStream.alias("name", String.class);
        xStream.alias("operator", Person.class);
        xStream.alias("x", Float.class);
        xStream.alias("y", Double.class);
        xStream.alias("birthday", LocalDateTime.class);
        xStream.alias("hairColor", Color.class);
        xStream.alias("nationality", Country.class);
    }
}
