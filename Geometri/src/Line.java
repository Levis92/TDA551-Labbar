import java.awt.*;

/**
 * Created by jimcollander on 17/11/16.
 * class for lines
 */
public class Line extends Shape {
    //private int x1;
    //private int y1;
    //private int x2;
    //private int y2;
    private boolean up;

    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
        if(y1<y2){
            up=false;
        }else{
            up=true;
        }
        this.color = c;
        this.x = setX(x1,x2);
        this.y = setY(y1,y2);
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        if (checkIllegal() || x2 < 0 || y2 < 0) {
            throw new IllegalPositionException();
        }
        calcArea();
        calcCircumference();
    }

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

    private int setX(int x1, int x2) {
        if (x2 < x1) {
            return x2;
        }
        return x1;
    }

    private int setY(int y1, int y2) {
        if (y2 < y1) {
            return y2;
        }
        return y1;
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
        if(up){
            g.drawLine(x, y+height, x+width, y);
        }else{
            g.drawLine(x, y, x+width, y+height);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Line && super.equals(o)) {
            Line line= (Line) o;
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
