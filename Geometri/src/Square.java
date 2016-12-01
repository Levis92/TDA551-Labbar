import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for squares
 */
public class Square extends Shape {

    /** constructs a Square
     *
     * @param x
     * @param y
     * @param size
     * @param c
     * @throws IllegalPositionException
     */
    public Square(int x, int y, int size, Color c) throws IllegalPositionException {
        super(x, y, size, size, c);
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
        calcArea();
        calcCircumference();
    }

    /**
     * constructs a Square using a GeometricalForm
     * @param f
     * @param size
     * @param c
     */
    public Square(GeometricalForm f, int size, Color c) {
        super(f.getX(), f.getY(), size, size, c);
    }

    /** {@inheritDoc} */
    protected void calcArea() {
        area = height * width;
    }

    /** {@inheritDoc} */
    protected void calcCircumference() {
        circumference = height * 2 + width * 2;
    }

    /** draws the square */
    public void fill(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Square && super.equals(o)) {
            return true;
        }
        return false;
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return super.hashCode();
    }

}
