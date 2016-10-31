import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrawPolygons extends Component{
    private ArrayList<Polygons> polygonNames;
    private ArrayList<Point>  centerPoints;
    private enum Polygons{
        TRIANGLE,
        SQUARE,
        RECTANGLE
    }//Polygons

    public DrawPolygons(Polygons[] p, Point[] center) {

    if (p.length != center.length) {
        throw new RuntimeException("Incorrect input");
    }

    polygonNames = new ArrayList<>(p.length);
    centerPoints = new ArrayList<>(center.length);

    for (int i = 0; i < p.length; i++) {
        polygonNames.add(p[i]);
        centerPoints.add(center[i]);
    }
    }//constructor

    private void drawSquare(Point currentCenter, Graphics g) {
        g.drawRect(currentCenter.x -10, currentCenter.y -10, 20, 20);
    }//drawSquare

    private void drawTriangle(Point currentCenter, Graphics g) {
        g.drawLine(currentCenter.x, currentCenter.y-10, currentCenter.x-10, currentCenter.y+10);
        g.drawLine(currentCenter.x-10, currentCenter.y+10,
                currentCenter.x+10, currentCenter.y+10);
        g.drawLine(currentCenter.x+10, currentCenter.y+10, currentCenter.x, currentCenter.y-10);
    }//drawTriangle

    private void drawRectangle(Point currentCenter, Graphics g) {
        g.drawRect(currentCenter.x -20, currentCenter.y -10, 40, 20);
    }//drawRectangle

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < polygonNames.size(); i++) {
            Polygons currentPolygon = polygonNames.get(i);
            Point currentCenter = centerPoints.get(i);

            switch (currentPolygon) {
                case SQUARE:
                    drawSquare(currentCenter, g);
                    break;
                case TRIANGLE:
                    drawTriangle(currentCenter, g);
                    break;
                case RECTANGLE:
                    drawRectangle(currentCenter, g);
                    break;
                default:
                    System.out.println("Hej!");
            }
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Polygons[] p = {Polygons.SQUARE, Polygons.TRIANGLE, Polygons.TRIANGLE, Polygons.RECTANGLE};
        Point[] points = {new Point(100,20), new Point(50,200), new Point(150,50), new Point(170,230)};
        DrawPolygons polygons = new DrawPolygons(p, points);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);




    }//main

}//DrawPolygons