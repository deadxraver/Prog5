package exceptionsPack;

public class NoSuchColorException extends Exception {
    @Override
    public String getMessage() {
        return "No such color";
    }
}
