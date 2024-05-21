package commandsPack;

import elementsPack.Movie;
import exceptionsPack.NullFieldException;
import parserPack.LongParser;

/**
 * Class storing method removeById
 */
public class RemoveById extends Update implements commandInterfacePack.RemoveById {
    protected RemoveById() {}

    /**
     * This method removes element with the same id if collection has any
     */
    @Override
    public void removeById() {
        long id;
        try {
            id = LongParser.parse(reader.next());
        } catch (NullFieldException e) {
            System.err.println("Id cannot be null");
            return;
        } catch (NumberFormatException e) {
            System.err.println("Wrong number format");
            return;
        }
        for (Movie movie : collection.getCollection()) {
            if (id == movie.getId()) {
                collection.removeElement(movie);
                System.out.println("Movie successfully deleted!");
                return;
            }
        }
        System.out.println("No movies with such id");
    }
}
