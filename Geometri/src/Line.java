import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for lines
 */
public class Line extends Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
        this.x1 = x1;
        this.y1 = y1;
        this.color = c;
        this.x2 = x2;
        this.y2 = y2;
        this.x = setX();
        this.y = setY();
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        if (checkIllegal() || x2 < 0 || y2 < 0) {
            throw new IllegalPositionException();
        }
        calcArea();
        calcCircumference();
    }

    public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
        this.x1 = f1.getX();
        this.y1 = f1.getY();
        this.color = c;
        this.x2 = f2.getX();
        this.y2 = f2.getY();
        this.x = setX();
        this.y = setY();
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        calcArea();
        calcCircumference();
    }

    /** {@inheritDoc} */
    protected void calcArea() {
        area = 0;
    }

    /** {@inheritDoc} */
    protected void calcCircumference() {
        circumference = (int) Math.round(Math.sqrt(height * height + width * width));
    }

    private int setX() {
        if (x2 < x1) {
            return x2;
        }
        return x1;
    }

    private int setY() {
        if (y2 < y1) {
            return y2;
        }
        return y1;
    }

    /** {@inheritDoc} */
    public void move(int dx, int dy) throws IllegalPositionException {
        super.move(dx, dy);
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    /** {@inheritDoc} */
    public void place(int x, int y) throws IllegalPositionException {
        int dx = x - this.x;
        int dy = y - this.y;
        move(dx, dy);
    }

    /** draws the line */
    public void fill(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Line && super.equals(o)) {
            return true;
        }
        return false;
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return super.hashCode();
    }

}
