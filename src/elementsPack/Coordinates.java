package elementsPack;

/**
 * Class storing two numbers reflecting coordinates - x and y
 * <p>
 * x cannot be null
 * <p>
 * y cannot be null and should not be greater than 274
 */
public class Coordinates {
    public Coordinates(float x, double y) {
        this.x = x;
        this.y = y;
    }
    private Float x; //Поле не может быть null
    private Double y; //Максимальное значение поля: 274, Поле не может быть null

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
