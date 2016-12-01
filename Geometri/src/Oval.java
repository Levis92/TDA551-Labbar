import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for ovals
 */
public class Oval extends Shape {

    /**
     * constructs an Oval
     * @param x
     * @param y
     * @param width
     * @param height
     * @param c
     * @throws IllegalPositionException
     */
    public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException {
        super(x, y, width, height, c);
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
    }

    /**
     * constructs and Oval using a GeometricalForm
     * @param f
     * @param width
     * @param height
     * @param c
     */
    public Oval(GeometricalForm f, int width, int height, Color c) {
        super(f.getX(), f.getY(), width, height, c);
    }

    /** {@inheritDoc} */
    protected void calcArea() {
        double a = (double) height/2;
        double b = (double) width/2;
        double c = Math.PI*(3*(a+b)-Math.sqrt((3*a+b)*(a+3*b)));
        area = (int) Math.round(c);
    }

    /** {@inheritDoc} */
    protected void calcCircumference() {
        circumference = (int) Math.round(height * 2 * Math.PI);
    }

    /** draws the oval */
    public void fill(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Oval && super.equals(o)) {
            return true;
        }
        return false;
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return super.hashCode();
    }

}
