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

class Line implements Comparable<Line> {

    private Point p1;
    private Point p2;

    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    double getLength() {
        return Math.sqrt(
                Math.pow(p2.x - p1.x, 2) +
                        Math.pow(p2.y - p1.y, 2)
        );
    }

    @Override
    public int compareTo(Line other) {
        return Double.compare(this.getLength(), other.getLength());
    }
}


public class LineComparison {

    public static void main(String[] args) {

        Line line1 = new Line(
                new Point(1, 2),
                new Point(4, 6)
        );

        Line line2 = new Line(
                new Point(2, 3),
                new Point(5, 7)
        );

        int result = line1.compareTo(line2);

        if (result == 0) {
            System.out.println("Both lines are equal");
        } else if (result > 0) {
            System.out.println("Line 1 is greater than Line 2");
        } else {
            System.out.println("Line 1 is less than Line 2");
        }
    }
}
