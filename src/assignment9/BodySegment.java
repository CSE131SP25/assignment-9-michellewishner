package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {
    private double x;
    private double y;

    public BodySegment(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(x, y, 0.02); // small circle
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
