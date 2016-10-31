import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrawPolygons extends Component{
    private ArrayList<Polygons> polygonNames;
    private ArrayList<Point>  centerPoints;
    private enum Polygons{TRIANGLE, SQUARE, RECTANGLE};

    public DrawPolygons(Polygons[] p, Point[] center) {

    if (p.length != center.length) {
        throw RuntimeException("Incorrect input");
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
    }

    private void drawTriangle(Point currentCenter, Graphics g) {
        g.drawLine(currentCenter.x, currentCenter.y-10, currentCenter.x-10, currentCenter.y+10);
        g.drawLine(currentCenter.x-10, currentCenter.y+10,
                currentCenter.x+10, currentCenter.y+10);
        g.drawLine(currentCenter.x+10, currentCenter.y+10, currentCenter.x, currentCenter.y-10);
    }

    private void drawRectangle(Point currentCenter, Graphics g) {
        g.drawRect(currentCenter.x -20, currentCenter.y -10, 40, 20);
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < polygonNames.size(); i++) {
            String currentPolygon = polygonNames.get(i);
            Point currentCenter = centerPoints.get(i);

            switch (currentPolygon) {
                case Polygons.SQUARE:
                    drawSquare(currentCenter, g);
                    break;
                case Polygons.TRIANGLE:
                    drawTriangle(currentCenter, g);
                    break;
                case Polygons.RECTANGLE:
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
        Point[] points = {new Point(100,300), new Point(50,200), new Point(150,250), new Point(100,230)};
        DrawPolygons polygons = new DrawPolygons(p, points);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);




    }//main

}//DrawPolygons