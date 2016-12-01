import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for rectangles
 */
public class Rectangle extends Shape{

    /**
     * construct a rectangle
     * @param x
     * @param y
     * @param width
     * @param height
     * @param c
     * @throws IllegalPositionException
     */
    public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
        super(x, y, width, height, c);
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
    }

    /**
     * construct a Rectangle using a GeometricalForm
     * @param f
     * @param width
     * @param height
     * @param c
     */
    public Rectangle(GeometricalForm f, int width, int height, Color c) {
        super(f.getX(), f.getY(), width, height, c);
    }

    /** {@inheritDoc} */
    protected void calcArea() {
        area = height * width;
    }

    /** {@inheritDoc} */
    protected void calcCircumference() {
        circumference = height * 2 + width * 2;
    }

    /** draws the rectangle */
    public void fill(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle && super.equals(o)) {
            return true;
        }
        return false;
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return super.hashCode();
    }

}
