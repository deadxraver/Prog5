package commandsPack;

import elementsPack.Movie;
import mainPack.MovieCollection;

/**
 * Class storing method info
 */
public class Info extends Help implements commandInterfacePack.Info {
    protected Info() {
        super();
    }

    /**
     * This method prints main info about current collection
     */
    @Override
    public void info() {
        int n = 0;
        System.out.println("Collection type: " + Movie.class.getSimpleName() +
                "\nDate of initialization: " + collection.getDateOfCreation() +
                "\nNumber of elements stored: " + collection.getNumberOfElements() +
                '\n');
    }
}
