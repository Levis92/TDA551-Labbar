import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for lines
 */
public class Line extends Shape {
    private boolean up;

    /**
     * creates a Line
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param c
     * @throws IllegalPositionException
     */
    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
        super(selectMin(x1, x2), selectMin(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2), c);
        if (y1 < y2) {
            up = false;
        } else {
            up = true;
        }
        if (checkIllegal() || x2 < 0 || y2 < 0) {
            throw new IllegalPositionException();
        }
    }

    /**
     * Creates a Line using a GeometricalForm
     * @param f1
     * @param f2
     * @param c
     */
    public Line(GeometricalForm f1, GeometricalForm f2, Color c) throws IllegalPositionException {
        this(f1.getX(), f1.getY(), f2.getX(), f2.getY(), c);
    }

    /** {@inheritDoc} */
    protected void calcArea() {
        area = 0;
    }

    /** {@inheritDoc} */
    protected void calcCircumference() {
        circumference = (int) Math.round(Math.sqrt(height * height + width * width));
    }

    private static int selectMin(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    /** {@inheritDoc} */
    public void move(int dx, int dy) throws IllegalPositionException {
        super.move(dx, dy);
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
        if (up) {
            g.drawLine(x, y+height, x+width, y);
        }
        else{
            g.drawLine(x, y, x+width, y+height);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Line && super.equals(o)) {
            Line line = (Line) o;
            if(this.up==line.up){
                return true;
            }
        }
        return false;
    }

    /** {@inheritDoc} */
    public int hashCode() {
        if (up){return (super.hashCode()+1)*17;}
        else{return super.hashCode();}
    }

}
