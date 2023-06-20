import javafx.scene.effect.Light.Point;

class Line {
    private double slope, yintercept;
    private Point end, start;

    public Line(Point end, Point start) {
        this.end = end;
        this.start = start;
        if (end.getX() == start.getX()) {
            slope = Double.POSITIVE_INFINITY;
            yintercept = Double.POSITIVE_INFINITY;
        } else {
            slope = (end.getY() - start.getY()) / (end.getX() - start.getX());
            yintercept = start.getY() - (start.getX() * slope);
        }

    }

    public boolean isVertical() {
        return slope == Double.POSITIVE_INFINITY;
    }

    public double getYFromX(double x) {
        if (slope == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return x * slope + yintercept;

    }

    public double getSlope() {
        return slope;
    }

    public double getYintercept() {
        return yintercept;
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }

}

class Intersection {
    public static void main(String[] args) {
        Point point = getIntersection(new Point(3, 2, 0, null),
                new Point(9, 10, 0, null), new Point(-3, 4, 0, null),
                new Point(6, 6, 0, null));
        if (point!=null){
            System.out.println("X:"+point.getX()+" Y:"+point.getY());
        }else{
            System.out.println("No intersection");
        }
        
    }

    static Point getIntersection(Point start1, Point end1, Point start2, Point end2) {
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if (line1.getSlope() == line2.getSlope()) {
            if (line1.getYintercept() != line2.getYintercept())
                return null;
            if (isBetween(start1, start2, end1))
                return start2;
            else if (isBetween(start1, end2, end1))
                return end2;
            else if (isBetween(start2, start1, end2))
                return start1;
            else if (isBetween(start2, end1, end2))
                return end1;
            else
                return null;
        }
        double x;
        if (line1.isVertical() || line2.isVertical()) {
            x = line1.isVertical() ? line1.getStart().getX() : line2.getStart().getX();
        } else {
            x = (line2.getYintercept() - line1.getYintercept()) /
                    (line1.getSlope() - line2.getSlope());
        }
        double y = line1.isVertical() ? line2.getYFromX(x) : line1.getYFromX(x);
        Point intersec = new Point(x, y, 0, null);

        if (isBetween(line1.getStart(), intersec, line1.getEnd()) &&
                isBetween(line2.getStart(), intersec, line2.getEnd())) {
            return intersec;
        }
        return null;

    }

    static boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.getX(), middle.getX(), end.getX()) &&
                isBetween(start.getY(), middle.getY(), end.getY());

    }

    static boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return middle <= start && middle >= end;
        } else {
            return middle >= start && middle <= end;
        }

    }
}