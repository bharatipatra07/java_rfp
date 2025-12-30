// Point.java
class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

 class Line {
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double length() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Line[" + start + " to " + end + "] Length=" + length();
    }
}


public class LineComparison {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 6);
        Line line = new Line(p1, p2);
        System.out.println(line);
    }
}

