import java.util.ArrayList;
import java.util.List;


/**
 * An unmodifiable point in the standard two-dimensional Euclidean space. The coordinates of such a point is given by
 * exactly two doubles specifying its <code>x</code> and <code>y</code> values.
 */
public class TwoDPoint implements Point {
    private double[] twoPoints;

    public TwoDPoint(double x, double y) {
        twoPoints = new double[2];
        twoPoints[0] = x;
        twoPoints[1] = y;

        // TODO
    }

    /**
     * @return the coordinates of this point as a <code>double[]</code>.
     */
    @Override
    public double[] coordinates() {
        return twoPoints;
        // TODO
    }
    /**
     * Returns a list of <code>TwoDPoint</code>s based on the specified array of doubles. A valid argument must always
     * be an even number of doubles so that every pair can be used to form a single <code>TwoDPoint</code> to be added
     * to the returned list of points.
     *
     * @param coordinates the specified array of doubles.
     * @return a list of two-dimensional point objects.
     * @throws IllegalArgumentException if the input array has an odd number of doubles.
     */
    public static List<TwoDPoint> ofDoubles(double... coordinates) throws IllegalArgumentException{
        if (coordinates.length % 2 != 0 )
            throw new IllegalArgumentException("Uneven length of elements in the list");
        List<TwoDPoint> points = new ArrayList<>();
        for(int i = 0; i< coordinates.length-1; i++){
            points.add(new TwoDPoint(coordinates[i], coordinates[i+1]));
        }
        return points;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public String toString(){
        return "(" + this.twoPoints[0]  + "," + this.twoPoints[1] + ")";
    }
}
