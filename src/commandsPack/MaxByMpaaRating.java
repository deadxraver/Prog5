package commandsPack;

import elementsPack.Movie;

/**
 * Class storing method maxByMpaaRating method
 */
public class MaxByMpaaRating extends RemoveAllByOscarsCount implements commandInterfacePack.MaxByMpaaRating {
    protected MaxByMpaaRating() {}

    /**
     * This method prints element with max mpaaRating field
     */
    @Override
    public void maxByMpaaRating() {
        Movie movie = collection.getMaxMpaaRatingElement();
        if (movie == null) System.out.println("Collection is empty");
        else System.out.println(movie);
    }
}
