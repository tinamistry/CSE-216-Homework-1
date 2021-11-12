import java.util.List;
import java.util.ArrayList;

public class Triangle implements TwoDShape, Positionable {
    List<Point> position = new ArrayList<>();
    List<TwoDPoint> vertices;

    public Triangle(List<TwoDPoint> vertices) {
        this.vertices = vertices;
        setPosition(vertices);
        // TODO
    }

    /**
     * Sets the position of this triangle according to the first three elements in the specified list of points. The
     * triangle is formed on the basis of these three points taken in a clockwise manner on the two-dimensional
     * x-y plane, starting with the point with the least x-value. If the input list has more than three elements, the
     * subsequent elements are ignored.
     *
     * @param points the specified list of points.
     */
    @Override
    public void setPosition(List<? extends Point> points) {
        Point c1 = points.get(0);
        Point c2 = points.get(1);
        Point c3 = points.get(2);
        List<Point> triPoints = new ArrayList<Point>();
        triPoints.add(c1);
        triPoints.add(c2);
        triPoints.add(c3);

        //first point
        int minIndex = findMin(triPoints, 0);
        Point temp = triPoints.get(0);
        Point temp2 = triPoints.get(minIndex);
        triPoints.set(0, temp2);
        triPoints.set(minIndex, temp);

        //second point
        minIndex = findMin(triPoints, 1);
        temp = triPoints.get(1);
        temp2 = triPoints.get(minIndex);
        triPoints.set(1, temp2);
        triPoints.set(minIndex, temp);


        position.add(triPoints.get(0));
        position.add(triPoints.get(1));
        position.add(triPoints.get(2));
        // TODO
    }

    public int findMin(List<Point> points, int x) {
        Point min = points.get(x);// first unordered value in the list 0
        int minIndex = x; //0
        double[] minCoordinate = min.coordinates(); //[] = [3.9, 2.0]
        for (int i = x + 1; i <= 2; i++) {
            Point p = points.get(i); //get the next set of coordinates [2.0 3.0]
            double[] current = p.coordinates(); //array of coordinates
            if (current[0] < minCoordinate[0]) { //min[0] = 3.9 > 2.0 so minIndex = 1 since i = x = 0 + 1 = 1
                minIndex = i;
                minCoordinate = p.coordinates(); // new min
            } else if (minCoordinate[0] == current[0]) {
                if (minCoordinate[1] > current[1]) { //2.0 < 3.0 so set minIndex = 2.0
                    minIndex = i;
                    minCoordinate = p.coordinates();
                } else minIndex = minIndex;
            }
        }
        return minIndex;
    }

    public int findHighest(List<? extends Point> points, int x) {
        Point max = points.get(x);
        int maxIndex = x;
        double[] maxCoordinate = max.coordinates();
        for (int i = x + 1; i <= 2; i++) {
            Point p = points.get(i); //next set of coordinates
            double[] current = p.coordinates();
            if (current[0] > maxCoordinate[0]) {
                maxIndex = i;
                maxCoordinate = p.coordinates();
            } else if (maxCoordinate[0] == current[0]) {
                if (maxCoordinate[1] < current[1]) {
                    maxIndex = i;
                    maxCoordinate = p.coordinates();
                } else maxIndex = maxIndex;

            }

        }
        return maxIndex;
    }

    /**
     * Retrieve the position of an object as a list of points. The points are be retrieved and added to the returned
     * list in a clockwise manner on the two-dimensional x-y plane, starting with the point with the least x-value. If
     * two points have the same least x-value, then the clockwise direction starts with the point with the lower y-value.
     *
     * @return the retrieved list of points.
     */
    @Override
    public List<? extends Point> getPosition() {
        return position;
    }

    /**
     * @return the number of sides of this triangle, which is always set to three
     */
    @Override
    public int numSides() {
        return 3;
    }

    /**
     * Checks whether or not a list of vertices forms a valid triangle. The <i>trivial</i> triangle, where all three
     * corner vertices are the same point, is considered to be an invalid triangle.
     *
     * @param vertices the list of vertices to check against, where each vertex is a <code>Point</code> type.
     * @return <code>true</code> if <code>vertices</code> is a valid collection of points for a triangle, and
     * <code>false</code> otherwise. For example, three vertices are in a straight line is invalid.
     */
    @Override
    public boolean isMember(List<? extends Point> vertices) {
        if (vertices.size() != 3)
            return false;
        else if (area() == 0)
            return false;
        else
            return true;

    }

    /**
     * This method snaps each vertex of this triangle to its nearest integer-valued x-y coordinate. For example, if
     * a corner is at (0.8, -0.1), it will be snapped to (1,0). The resultant triangle will thus have all three
     * vertices in positions with integer x and y values. If the snapping procedure described above results in this
     * triangle becoming invalid (e.g., all corners collapse to a single point), then it is left unchanged. Snapping is
     * an in-place procedure, and the current instance is modified.
     */
    public void snap() {
        Point p1 = position.get(0);
        Point p2 = position.get(1);
        Point p3 = position.get(2);
        if (Math.round((p1.coordinates())[0]) == Math.round((p2.coordinates())[0]) && Math.round((p2.coordinates())[0]) == Math.round((p3.coordinates())[0])
                && Math.round((p1.coordinates())[1]) == Math.round((p2.coordinates())[1]) && Math.round((p2.coordinates())[1]) == Math.round((p3.coordinates())[1]))
            return;
        else {
            ((position.get(0)).coordinates())[0] = Math.round((position.get(0).coordinates())[0]);
            ((position.get(0)).coordinates())[1] = Math.round((position.get(0).coordinates())[1]);

            ((position.get(1)).coordinates())[0] = Math.round((position.get(1).coordinates())[0]);
            ((position.get(1)).coordinates())[1] = Math.round((position.get(1).coordinates())[1]);

            ((position.get(2)).coordinates())[0] = Math.round((position.get(2).coordinates())[0]);
            ((position.get(2)).coordinates())[1] = Math.round((position.get(2).coordinates())[1]);
        }
        // TODO
    }

    /**
     * @return the area of this triangle
     */
    public double area() {
        Point p1 = position.get(0);
        Point p2 = position.get(1);
        Point p3 = position.get(2);

        double[] p1Coord = p1.coordinates();
        double[] p2Coord = p2.coordinates();
        double[] p3Coord = p3.coordinates();

        double x1y1 = p1Coord[0] * p1Coord[1];
        double x2y3 = p2Coord[0] * p3Coord[1];
        double x3y1 = p3Coord[0] * p1Coord[1];
        double x1y3 = p1Coord[0] * p3Coord[1];
        double x2y1 = p2Coord[0] * p1Coord[1];
        double x3y2 = p2Coord[0] * p2Coord[1];
        double sum = x1y1 + x2y3 + x3y1 + x1y3 - x2y1 - x3y2;
        sum = Math.abs(sum);
        return (sum * 0.5);
    }

    /**
     * @return the perimeter (i.e., the total length of the boundary) of this triangle
     */
    public double perimeter() {
        Point p1 = position.get(0);
        Point p2 = position.get(1);
        Point p3 = position.get(2);

        return (distance(p1, p2) + distance(p2, p3) + distance(p3, p1));

    }

    public double distance(Point p1, Point p2) {
        double[] p1Coor = p1.coordinates();
        double[] p2Coor = p2.coordinates();
        double x = Math.pow((p2Coor[0] - p1Coor[0]), 2);
        double y = Math.pow((p2Coor[1] - p1Coor[1]), 2);
        double dist = Math.pow((x + y), 0.5);
        return dist;
    }

    public double lowestX() {
        return ((position.get(0)).coordinates())[0];
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String toString(){
        return "Triangle " + "[" + ((position.get(0)).coordinates())[0] + "," + ((position.get(0)).coordinates())[1] + ")" +
                ", " + "(" + ((position.get(1)).coordinates())[0] + "," + ((position.get(1)).coordinates())[1] + ")" +
                ", " + "(" + ((position.get(2)).coordinates())[0] + "," + ((position.get(2)).coordinates())[1] + ")" + "]";
    }
}

