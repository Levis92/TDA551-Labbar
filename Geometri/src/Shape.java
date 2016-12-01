/**
 * Created by jimcollander on 17/11/16.
 */
import java.awt.*;

/**
 * abstract class för geometric shapes
 */

public abstract class Shape implements GeometricalForm{

    /** the color of the shape */
    protected Color color;

    /** the x coordinate of top left corner */
    protected int x;

    /** the y coordinate of top left corner */
    protected int y;

    /** the area of the shape */
    protected int area;

    /** the circumference of the shape */
    protected int circumference;

    /** the width of the shape */
    protected int width;

    /** the height of the shape */
    protected int height;

    /** calculates the area of the shape */
    protected abstract void calcArea();

    /** calculates the circumference of the shape */
    protected abstract void calcCircumference();

    /** draw the shape */
    public abstract void fill(Graphics g);

    /** compare the shape to another geometrical form using area and circumference
     * @param d
     * @return
     */
    public int compareTo(GeometricalForm d) {
        if (this.area > d.getArea() ) {
            return 1;
        }
        else if (this.area < d.getArea()) {
            return -1;
        }
        else {
            if (this.circumference > d.getCircumference() ) {
                return 1;
            }
            else if (this.circumference < d.getCircumference()) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    /** returns the color of the shape */
    public Color getColor() {
        return color;
    }

    /** returns the x coordinate of the shape */
    public int getX() {
        return x;
    }

    /** returns the y coordinate of the shape */
    public int getY() {
        return y;
    }

    /** returns the area of the shape */
    public int getArea() {
        return area;
    }

    /** returns the circumference of the shape */
    public int getCircumference() {
        return circumference;
    }

    /**
     * compares the shape to another object
     * if both objects are shapes and both have identical fields, except coordinates, returns true
     * otherwise returns false
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Shape) {
            Shape shape = (Shape) o;
            if (this.area != shape.getArea()){
                return false;
            }
            if (this.circumference != shape.getCircumference()){
                return false;
            }
            if (this.color != shape.getColor()){
                return false;
            }
            if (this.width != shape.getWidth()){
                return false;
            }
            if (this.height != shape.getHeight()){
                return false;
            }
            return true;
        }
        return false;
    }

    /** overrides hashCode
     *  @return
     */
    @Override
    public int hashCode() {
        return area+circumference*37+color.hashCode()+width*370+height*3700;
    }

    /** returns height of shape */
    public int getHeight() {
        return height;
    }

    /** returns width of shape */
    public int getWidth() {
        return width;
    }

    /** moves the shape dx steps along x axis and dy steps along y axis */
    public void move(int dx, int dy) throws IllegalPositionException {
        x += dx;
        y += dy;
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
    }

    /** places the shape on new x and y coordinates
     *  @param x, y
     */
    public void place(int x, int y) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        if (checkIllegal()) {
            throw new IllegalPositionException();
        }
    }

    /** checks if either x or y coordinate is negative and thus outside the window
     *  @return
     */
    protected boolean checkIllegal() {
        if (x < 0 || y < 0) {
            return true;
        }
        return false;
    }

}
