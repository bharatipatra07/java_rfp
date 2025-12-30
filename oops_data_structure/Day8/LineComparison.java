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

    Point p1;
    Point p2;

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
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Line other = (Line) obj;

        return Double.compare(this.getLength(), other.getLength()) == 0;
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

        if (line1.equals(line2)) {
            System.out.println("Both lines are equal");
        } else {
            System.out.println("Both lines are not equal");
        }
    }
}


