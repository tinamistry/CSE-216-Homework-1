/**
 * An unmodifiable point in the three-dimensional space. The coordinates are specified by exactly three doubles (its
 * <code>x</code>, <code>y</code>, and <code>z</code> values).
 */
public class ThreeDPoint implements Point {
    private double[] ThreeDPoint;
    public ThreeDPoint(double x, double y, double z) {
        ThreeDPoint = new double[3];
        ThreeDPoint[0] = x;
        ThreeDPoint[1] = y;
        ThreeDPoint[2] = z;

        // TODO
    }
    /**
     * @return the (x,y,z) coordinates of this point as a <code>double[]</code>.
     */
    @Override
    public double[] coordinates() {
        return ThreeDPoint;
        // TODO
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
