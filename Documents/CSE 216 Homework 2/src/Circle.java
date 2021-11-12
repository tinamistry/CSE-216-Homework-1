import java.util.List;
import java.util.Collections;
import java.lang.Math;

public class Circle implements TwoDShape, Positionable {

    private TwoDPoint center;
    private double radius;
    private TwoDPoint position;


    public Circle(double x, double y, double r) {
        this.center = new TwoDPoint(x, y);
        this.radius = r;
    }

    /**
     * Sets the position of this circle to be centered at the first element in the specified list of points.
     *
     * @param points the specified list of points.
     * @throws IllegalArgumentException if the input does not consist of {@link TwoDPoint} instances
     */
    @Override
    public void setPosition(List<? extends Point> points) {
        // TODO
        position = (TwoDPoint) points.get(0);
        if(!(points.get(0) instanceof TwoDPoint) ) {
            throw new IllegalArgumentException("Input List does not consist of TwoDPoint instances");
        }
    }
    /**
     * @return the center of this circle as an immutable singleton list
     */
    @Override
    public List<? extends Point> getPosition() {
        List<? extends Point> pos = Collections.singletonList(center);
        return pos;
    }

    /**
     * @return the number of sides of this circle, which is always set to positive infinity
     */
    @Override
    public int numSides() {
        return (int) Double.POSITIVE_INFINITY;
    }

    /**
     * Checks whether or not a list of vertices is a valid collection of vertices for the type of two-dimensional shape.
     *
     * @param centers the list of vertices to check against, where each vertex is a <code>Point</code> type. For
     *                the Circle object, this list is expected to contain only its center.
     * @return <code>true</code> if and only if <code>centers</code> is a single point, and the radius of this circle is
     * a positive value.
     */
    @Override
    public boolean isMember(List<? extends Point> centers) {

        return centers.size() == 1 && radius > 0;
    }

    /**
     * @return the area of this circle
     */
    public double area() {
        double a = 0.0;
        a = radius * radius;
        a = a * Math.PI;
        a = Math.round(a*100);
        a = a/100;
        return a; // TODO

    }
    /**
     * @return the perimeter (i.e., the total length of the boundary) of this quadrilateral
     */
    public double perimeter() {
        double p = 0.0;
        p = radius *2.0;
        p = p * Math.PI;
        p = Math.round(p*100);
        p = p/100;
        return p; // TODO
    }
    public double lowestX(){
        return (center.coordinates())[0];
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public String toString(){
        return "Circle " + "[center: " + (center.coordinates())[0] + ", " + (center.coordinates())[1] + "; radius: " + radius + "]";
    }
}
