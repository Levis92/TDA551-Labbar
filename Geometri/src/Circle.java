/**
 * Created by jimcollander on 17/11/16.
 * class for circles
 */
import java.awt.*;
import java.lang.Math.*;

public class Circle extends Shape {

    /**
     * constructs a Circle
     * @param x
     * @param y
     * @param diameter
     * @param c
     * @throws IllegalPositionException
     */
    public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
        super(x, y, diameter/2, diameter/2, c);
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
    }

    /**
     * constructs a Circle using a GeometricalForm
     * @param f
     * @param diameter
     * @param c
     */
    public Circle(GeometricalForm f, int diameter, Color c) {
        super(f.getX(), f.getY(), diameter/2, diameter/2, c);
    }

    /** {@inheritDoc} */
    protected void calcArea() {
        area = (int) Math.round((height * height * Math.PI));
    }

    /** {@inheritDoc} */
    protected void calcCircumference() {
        circumference = (int) Math.round(height* 2 * Math.PI);
    }

    /** draws the circle */
    public void fill(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle && super.equals(o)) {
            return true;
        }
        return false;
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return super.hashCode();
    }

}
