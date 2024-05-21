package commandsPack;

import elementsPack.Movie;
import mainPack.MovieCollection;

/**
 * Class storing method show
 */
public class Show extends Info implements commandInterfacePack.Show {
    protected Show() {}

    /**
     * This method prints all the movies stored in the collection
     */
    @Override
    public void show() {
        for (Movie movie : collection.getCollection()) {
            System.out.println(movie);
        }
    }
}
