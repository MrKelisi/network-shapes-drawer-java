package serveur;

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
}