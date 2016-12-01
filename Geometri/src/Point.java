/**
 * Created by jimcollander on 17/11/16.
 */
import java.awt.*;

public class Point extends Shape {

    /**
     * construct a Point
     * @param x
     * @param y
     * @param c
     * @throws IllegalPositionException
     */
    public Point(int x, int y, Color c) throws IllegalPositionException {
        super(x, y, 0, 0, c);
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
    }

    /**
     * construct a Point using a GeometricalForm
     * @param f
     * @param c
     */
    public Point(GeometricalForm f, Color c) {
        super(f.getX(), f.getY(), 0, 0, c);
    }

    /** {@inheritDoc} */
    protected void calcArea() {
        area = 0;
    }

    /** {@inheritDoc} */
    protected void calcCircumference() {
        circumference = 0;
    }

    /** draws the point */
    public void fill(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, x, y);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point && super.equals(o)) {
            return true;
        }
        return false;
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return super.hashCode();
    }

}
