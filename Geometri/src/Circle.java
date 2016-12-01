/**
 * Created by jimcollander on 17/11/16.
 * class for circles
 */
import java.awt.*;
import java.lang.Math.*;

public class Circle extends Shape {

    public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        this.color = c;
        width = diameter / 2;
        height = diameter / 2;
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
        calcArea();
        calcCircumference();
    }

    public Circle(GeometricalForm f, int diameter, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.color = c;
        width = diameter / 2;
        height = diameter / 2;
        calcArea();
        calcCircumference();
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
