/**
 * Created by jimcollander on 17/11/16.
 */
import java.awt.*;

public class Point extends Shape {

    public Point(int x, int y, Color c) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        this.color = c;
        width = 0;
        height = 0;
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
        calcArea();
        calcCircumference();
    }

    public Point(GeometricalForm f, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.color = c;
        width = 0;
        height = 0;
        calcArea();
        calcCircumference();
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
