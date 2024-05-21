package commandsPack;

import elementsPack.Movie;
import exceptionsPack.NullFieldException;
import parserPack.IntParser;

/**
 * Class storing method removeAllByOscarsCount
 */
public class RemoveAllByOscarsCount extends RemoveLower implements commandInterfacePack.RemoveAllByOscarsCount {
    protected RemoveAllByOscarsCount() {}

    /**
     * This method removes all the elements having the same oscarsCount field as entered
     */
    @Override
    public void removeAllByOscarsCount() {
        int oscarsCount;
        try {
            oscarsCount = IntParser.parse(reader.next());
        } catch (NullFieldException e) {
            System.err.println("Field cannot be null");
            return;
        } catch (NumberFormatException e) {
            System.err.println("Wrong number format");
            return;
        }
        boolean t = false;
        for (Movie movie : collection.getCollection()) {
            if (movie.getOscarsCount() == oscarsCount) {
                collection.removeElement(movie);
                t = true;
            }
        }
        if (t) System.out.println("Movie(-s) removed successfully");
        else System.out.println("No such elements in the collection");
    }
}
