package mainPack;

import elementsPack.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Class having a collection of movies and having some basic methods to easily manipulate them
 */
public class MovieCollection {
    public MovieCollection() {
        this.dateOfCreation = LocalDateTime.now();
    }
    public MovieCollection(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    private final LocalDateTime dateOfCreation;
    private final LinkedList<Movie> collection = new LinkedList<>();

    /**
     * Adds a new movie by given parameters
     * @param coordinates coordinates of action, 2-dimensional
     * @param genre movie genre (drama, fantasy, tragedy and western)
     * @param mpaaRating rating showing who can watch the movie according to the law (NC-17, PG, R)
     * @param name movie name, cannot be null
     * @param operator operator
     * @param oscarsCount number of oscars
     */
    public void addElement(Coordinates coordinates, MovieGenre genre,
                           MpaaRating mpaaRating, String name, Person operator, int oscarsCount) {
        long id;
        do {
            id = generateId();
        } while (!validateId(id));
        LocalDate creationDate = LocalDate.now();
        collection.add(new Movie(id, name, coordinates, creationDate, oscarsCount, genre, mpaaRating, operator));
    }

    /**
     * Directly adds a new movie
     * @param movie element already having its id and date of creation
     */
    public void addElement(Movie movie) {
        collection.add(movie);
    }

    /**
     * Generates a unique ID using Math.random() and validates it until a valid ID is found.
     *
     * @return         	the generated unique ID
     */
    public long generateId() {
        long id;
        while (true) {
            id = (long) (Math.random() * Long.MAX_VALUE);
            if (validateId(id)) return id;
        }
    }

    /**
     * Checks whether current id is valid (greater than 0 and not taken by other elements)
     * @param id long field to be taken by a movie element
     * @return true / false depending on the result of validation
     */
    private boolean validateId(long id) {
        if (id <= 0) return false;
        for (Movie movie : collection) {
            if (movie.getId() == id) return false;
        }
        return true;
    }

    public int getNumberOfElements() {
        return collection.size();
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public LinkedList<Movie> getCollection() {
        return collection;
    }

    /**
     * Check whether current movie is greater than all the movies from collection
     * @param movie movie to be checked
     * @return true / false depending on the result
     */
    public boolean checkIfMax(Movie movie) {
        for (Movie movie1 : collection) {
            if (movie.getOscarsCount() <= movie1.getOscarsCount()) return false;
        }
        return true;
    }

    /**
     * Returns the movie with the highest MPAA rating from the collection.
     *
     * @return         	the movie with the highest MPAA rating, or null if the collection is empty
     */
    public Movie getMaxMpaaRatingElement() {
        for (Movie movie : collection) {
            if (movie.getMpaaRating().equals(MpaaRating.PG)) return movie;
        }
        for (Movie movie : collection) {
            if (movie.getMpaaRating().equals(MpaaRating.R)) return movie;
        }
        for (Movie movie : collection) {
            if (movie.getMpaaRating().equals(MpaaRating.NC_17)) return movie;
        }
        return null;
    }

    /**
     * Retrieves and returns a sorted list of operators from the collection of movies.
     *
     * @return         	the sorted list of operators
     */
    public LinkedList<Person> getOperatorsSorted() {
        LinkedList<Person> personLinkedList = new LinkedList<>();
        for (Movie movie : collection) {
            Person operator = movie.getOperator();
            if (operator != null) personLinkedList.add(operator);
        }
        Collections.sort(personLinkedList);
        return personLinkedList;
    }

    /**
     * Removes the specified movie from the collection.
     *
     * @param  movie   the movie to be removed
     */
    public void removeElement(Movie movie) {
        collection.remove(movie);
    }

    @Override
    public String toString() {
        return "MovieCollection{" +
                "dateOfCreation=" + dateOfCreation +
                ", collection=" + collection +
                '}';
    }
}
