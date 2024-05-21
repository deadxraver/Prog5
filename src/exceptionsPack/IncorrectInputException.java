package exceptionsPack;

public class IncorrectInputException extends Exception {
    @Override
    public String getMessage() {
        return "Incorrect input";
    }
}
