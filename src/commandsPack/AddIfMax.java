package commandsPack;

import elementsPack.*;
import exceptionsPack.*;
import parserPack.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Class storing method addIfMax
 */
public class AddIfMax extends RemoveHead implements commandInterfacePack.AddIfMax {
    protected AddIfMax() {}

    /**
     * This method adds a new element to collection if its oscarsCount field is the greatest
     */
    @Override
    public void addIfMax() {
        boolean operatorInfo;
        String movieName;
        float x;
        Double y;
        MovieGenre genre;
        MpaaRating mpaaRating;
        int oscarsCount;
        Person operator = null;
        reader.nextLine();
        while (true) {
            try {
                System.out.println("Enter movie name");
                movieName = StringParser.parse(reader.nextLine());
                break;
            } catch (EmptyStringException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter x coordinate");
                x = FloatParser.parse(reader.nextLine());
                break;
            } catch (NullFieldException e) {
                System.err.println(e.getMessage());
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
                System.err.println(e.getMessage());
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
            } catch (NullFieldException e) {
                System.err.println(e.getMessage());
            } catch (IncorrectInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter MPAA rating (optional)");
                mpaaRating = MpaaRatingParser.parse(reader.nextLine());
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
            } catch (NullFieldException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Wrong number format");
            } catch (NumberOutOfBoundsException e) {
                System.err.println("Number of Oscars should be greater than" + IntParser.LOWER_OSCAR_BOUND);
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
                    System.err.println("Name cannot be empty!");
                }
            }
            while (true) {
                try {
                    System.out.println("Enter birthday date (optional, yyyy-mm-dd format)");
                    String temp = reader.nextLine().replaceAll(" ", "");
                    if (temp.isEmpty()) {
                        birthday = null;
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
                        hairColor = null;
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
                        nationality = null;
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
        Movie movie = new Movie(collection.generateId(), movieName, new Coordinates(x, y), LocalDate.now(), oscarsCount,
                genre, mpaaRating, operator);
        if (collection.checkIfMax(movie)) {
            collection.addElement(movie);
            System.out.println("Movie successfully added!");
        }
        else {
            System.out.println("Movie is not max");
        }
    }
}
