package serveur;

import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return Abscisse du point
     */
    public double x() {
        return x;
    }

    /**
     * @return Ordonnée du point
     */
    public double y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
               Double.compare(point.y, y) == 0;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x + ", " +
                "y=" + y +
                '}';
    }
}