import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for rectangles
 */
public class Rectangle extends Shape{

    public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        this.color = c;
        this.width = width;
        this.height = height;
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
        calcArea();
        calcCircumference();
    }

    public Rectangle(GeometricalForm f, int width, int height, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.color = c;
        this.width = width;
        this.height = height;
        calcArea();
        calcCircumference();
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
