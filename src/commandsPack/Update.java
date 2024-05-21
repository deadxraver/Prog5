package commandsPack;

import elementsPack.*;
import exceptionsPack.*;
import parserPack.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Class storing method update
 */
public class Update extends Add implements commandInterfacePack.Update {
    protected Update() {}
    /**
     * This method updates the existing element by its id
     */
    @Override
    public void update() {
        long id;
        while (true) {
            try {
                id = LongParser.parse(reader.next());
                break;
            } catch (NullFieldException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Wrong number format");
            }
        }
        reader.nextLine();
        Movie oldMovie = null;
        for (Movie movie : collection.getCollection()) {
            if (id == movie.getId()) {
                oldMovie = movie;
                break;
            }
        }
        if (oldMovie == null) {
            System.out.println("No movie with such id");
            return;
        }
        LocalDate creationDate = oldMovie.getCreationDate();
        boolean operatorInfo;
        String movieName;
        Float x;
        Double y;
        MovieGenre genre;
        MpaaRating mpaaRating;
        int oscarsCount;
        Person operator = oldMovie.getOperator();
        try {
            System.out.println("Enter movie name");
            movieName = StringParser.parse(reader.nextLine());
        } catch (EmptyStringException ignored) {
            movieName = oldMovie.getName();
        }
        while (true) {
            try {
                System.out.println("Enter x coordinate");
                x = FloatParser.parse(reader.nextLine());
                break;
            } catch (NullFieldException ignored) {
                x = oldMovie.getCoordinates().getX();
                break;
            } catch (NumberFormatException e) {
                System.err.println("Wrong number format");
            }
        }
        while (true) {
            try {
                System.out.println("Enter y coordinate (max - 274)");
                y = DoubleParser.parse(reader.nextLine());
                break;
            } catch (NumberOutOfBoundsException e) {
                System.err.println(e.getMessage());
                System.err.println("Max number is " + DoubleParser.UPPER_BOUND);
            } catch (NullFieldException e) {
                y = oldMovie.getCoordinates().getY();
                break;
            } catch (NumberFormatException e) {
                System.err.println("Wrong number format");
            }
        }
        while (true) {
            try {
                System.out.println("Enter movie genre (e.g. drama, fantasy, etc.)");
                genre = GenreParser.parse(reader.nextLine());
                if (genre == null) throw new IncorrectInputException();
                break;
            } catch (NullFieldException ignored) {
                genre = oldMovie.getGenre();
                break;
            } catch (IncorrectInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter MPAA rating");
                mpaaRating = MpaaRatingParser.parse(reader.nextLine());
                if (mpaaRating == null) mpaaRating = oldMovie.getMpaaRating();
                break;
            } catch (IncorrectInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter number of Oscars");
                oscarsCount = IntParser.parse(reader.nextLine());
                if (oscarsCount <= IntParser.LOWER_OSCAR_BOUND) throw new NumberOutOfBoundsException();
                break;
            } catch (NullFieldException ignored) {
                oscarsCount = oldMovie.getOscarsCount();
                break;
            } catch (NumberFormatException e) {
                System.err.println("Wrong number format");
            } catch (NumberOutOfBoundsException e) {
                System.err.println("Number of Oscars should be greater than " + IntParser.LOWER_OSCAR_BOUND);
            }
        }
        while (true) {
            try {
                System.out.println("Do you want to fill in the information about operator (yes/no)?");
                String line = StringParser.parse(reader.nextLine());
                if (!line.equals("yes") && !line.equals("no")) throw new IncorrectInputException();
                operatorInfo = line.equals("yes");
                break;
            } catch (Exception e) {
                System.err.println("Line should be either 'yes' or 'no'");
            }
        }
        if (operatorInfo) {
            String operatorName;
            LocalDateTime birthday;
            Color hairColor;
            Country nationality;
            while (true) {
                try {
                    System.out.println("Enter operator name");
                    operatorName = StringParser.parse(reader.nextLine());
                    break;
                } catch (EmptyStringException e) {
                    if (oldMovie.getOperator() == null) {
                        System.err.println("Name cannot be empty!");
                    }
                    else {
                        operatorName = oldMovie.getOperator().getName();
                        break;
                    }
                }
            }
            while (true) {
                try {
                    System.out.println("Enter birthday date (optional, yyyy-mm-dd format)");
                    String temp = reader.nextLine().replaceAll(" ", "");
                    if (temp.isEmpty()) {
                        if (oldMovie.getOperator() == null) {
                            birthday = null;
                        }
                        else {
                            birthday = oldMovie.getOperator().getBirthday();
                        }
                        break;
                    }
                    birthday = DateTimeParser.parse(temp);
                    break;
                }
                catch (DateTimeParseException | DateIsNotReachedException e) {
                    System.err.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    System.out.println("Enter hair color (optional)");
                    String temp = reader.nextLine();
                    if (temp.replaceAll(" ", "").isEmpty()) {
                        if (oldMovie.getOperator() == null) {
                            hairColor = null;
                        }
                        else {
                            hairColor = oldMovie.getOperator().getHairColor();
                        }
                        break;
                    }
                    hairColor = ColorParser.parse(temp);
                    if (hairColor == null) throw new NoSuchColorException();
                    break;
                } catch (NoSuchColorException e) {
                    System.err.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    System.out.println("Enter nationality (optional)");
                    String temp = reader.nextLine();
                    if (temp.replaceAll(" ", "").isEmpty()) {
                        if (oldMovie.getOperator() == null) {
                            nationality = null;
                        }
                        else {
                            nationality = oldMovie.getOperator().getNationality();
                        }
                        break;
                    }
                    nationality = CountryParser.parse(temp);
                    if (nationality == null) throw new NoSuchCountryException();
                    break;
                } catch (NoSuchCountryException e) {
                    System.err.println(e.getMessage());
                }
            }
            operator = new Person(operatorName, birthday, hairColor, nationality);
        }
        collection.removeElement(oldMovie);
        Movie movie = new Movie(id, movieName, new Coordinates(x, y), creationDate, oscarsCount,
                genre, mpaaRating, operator);
        collection.addElement(movie);
        System.out.println("Movie successfully updated!");
    }
}
