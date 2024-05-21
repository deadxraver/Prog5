package exceptionsPack;

public class NumberOutOfBoundsException extends Exception{
    @Override
    public String getMessage() {
        return "Number does not fit the requirements";
    }
}
