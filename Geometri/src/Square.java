import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for squares
 */
public class Square extends Shape {

    public Square(int x, int y, int size, Color c) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        this.color = c;
        this.width = size;
        this.height = size;
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
        calcArea();
        calcCircumference();
    }

    public Square(GeometricalForm f, int size, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.color = c;
        this.width = size;
        this.height = size;
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
