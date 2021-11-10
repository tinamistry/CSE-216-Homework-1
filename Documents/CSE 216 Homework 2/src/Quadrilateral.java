import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Quadrilateral implements TwoDShape, Positionable {
    List<Point> position = new ArrayList<>();
    List<TwoDPoint> vertices;


    public Quadrilateral(List<TwoDPoint> vertices) {
        this.vertices = vertices;
        // TODO
    }

    /**
     * Sets the position of this quadrilateral according to the first four elements in the specified list of points. The
     * quadrilateral is formed on the basis of these four points taken in a clockwise manner on the two-dimensional
     * x-y plane, starting with the point with the least x-value. If the input list has more than four elements, the
     * subsequent elements are ignored.
     *
     * @param points the specified list of points.
     */
    @Override
    public void setPosition(List<? extends Point> points) {
        Point c1 = points.get(0);
        Point c2 = points.get(1);
        Point c3 = points.get(2);
        Point c4 = points.get(3);
        List<Point> points2 = new ArrayList<Point>();
        points2.add(c1);
        points2.add(c2);
        points2.add(c3);
        points2.add(c4);
            //first value
            int minIndex = findMin(points2, 0);
            Point temp = points2.get(0); //current point
            Point temp2 = points2.get(minIndex); //min value
            points2.set(0, temp2);
            points2.set(minIndex, temp);

            //second value
             minIndex = findMin(points2, 1);
            temp = points2.get(1); //current point
            temp2 = points2.get(minIndex); //min value
            points2.set(1, temp2);
            points2.set(minIndex, temp);

            //third value
            int highestIndex = findHighest(points2, 2);
            temp = points2.get(2);
            temp2 = points2.get(highestIndex);
            points2.set(2,temp2);
            points2.set(highestIndex,temp);

        position.add(points2.get(0));
        position.add(points2.get(1));
        position.add(points2.get(2));
        position.add(points2.get(3));

        // TODO
    }
    public int findMin(List<? extends Point> points,int x){
        Point min = points.get(x);// first unordered value in the list 0
        int minIndex = x; //0
        double [] minCoordinate = min.coordinates(); //[] = [3.9, 2.0]
        for(int i = x+1 ; i <= 3  ; i++){
            Point p = points.get(i); //get the next set of coordinates [2.0 3.0]
            double [] current = p.coordinates(); //array of coordinates
            if (current[0] < minCoordinate[0]){ //min[0] = 3.9 > 2.0 so minIndex = 1 since i = x = 0 + 1 = 1
               minIndex = i;
               minCoordinate = p.coordinates(); // new min
            }
            else
                if (minCoordinate[0] == current[0]) {
                    if (minCoordinate[1] > current[1]) { //2.0 < 3.0 so set minIndex = 2.0
                         minIndex = i;
                         minCoordinate = p.coordinates();
                }
                    else minIndex = minIndex;
            }
        }
        return minIndex;
    }

    public int findHighest(List<? extends Point> points, int x) {
        Point max = points.get(x);
        int maxIndex = x;
        double[] maxCoordinate = max.coordinates();
        for (int i = x + 1; i <= 3; i++) {
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
     * @return the number of sides of this quadrilateral, which is always set to four
     */
    @Override
    public int numSides() {
        return 4;
    }

    /**
     * Checks whether or not a list of vertices forms a valid quadrilateral. The <i>trivial</i> quadrilateral, where all
     * four corner vertices are the same point, is considered to be an invalid quadrilateral.
     *
     * @param vertices the list of vertices to check against, where each vertex is a <code>Point</code> type.
     * @return <code>true</code> if <code>vertices</code> is a valid collection of points for a quadrilateral, and
     * <code>false</code> otherwise. For example, if three of the four vertices are in a straight line is invalid.
     */
    @Override
    public boolean isMember(List<? extends Point> vertices) {
        Point p1 = position.get(0);
        Point p2 = position.get(1);
        Point p3 = position.get(2);
        Point p4 = position.get(3);
        if (vertices.size() != 4) {
            return false;
        }
        double p1x = (p1.coordinates())[0];
        double p1y = (p1.coordinates())[1];

        double p2x = (p2.coordinates())[0];
        double p2y = (p2.coordinates())[1];

        double p3x = (p3.coordinates())[0];
        double p3y = (p3.coordinates())[1];

        double p4x = (p4.coordinates())[0];
        double p4y = (p4.coordinates())[1];

        if(p1x == p2x && p2x == p3x && p3x == p4x && p1y == p2y &&p2y == p3y && p3y == p4y){
            return false;
        }
        double width1 = distance(p1, p2);
        double width2 = distance(p3,p4);

        double length1 = distance(p1,p4);
        double length2 = distance(p2,p3);

        double diagonal1 = distance(p1,p3);
        double diagonal2 = distance(p2,p4);

        if(width1 == width2 && length1 == length2 && diagonal1 == diagonal2){
            return true;
        }
        return false;
     // TODO
    }

    /**
     * This method snaps each vertex of this quadrilateral to its nearest integer-valued x-y coordinate. For example, if
     * a corner is at (0.8, -0.1), it will be snapped to (1,0). The resultant quadrilateral will thus have all four
     * vertices in positions with integer x and y values. If the snapping procedure described above results in this
     * quadrilateral becoming invalid (e.g., all four corners collapse to a single point), then it is left unchanged.
     * Snapping is an in-place procedure, and the current instance is modified.
     */
    public void snap() {
        Point p1 = position.get(0);
        Point p2 = position.get(1);
        Point p3 = position.get(2);
        Point p4 = position.get(3);
        if(Math.round((p1.coordinates())[0]) == Math.round((p2.coordinates())[0]) && Math.round((p3.coordinates())[0]) == Math.round((p2.coordinates())[0])
                && Math.round((p3.coordinates())[0]) == Math.round((p4.coordinates())[0]) && Math.round((p1.coordinates())[1]) == Math.round((p2.coordinates())[1])
                && Math.round((p2.coordinates())[1]) == Math.round((p3.coordinates())[1]) && Math.round((p3.coordinates())[1]) == Math.round((p4.coordinates())[1]))
                return;
        else
            ((position.get(0)).coordinates())[0] = Math.round((position.get(0).coordinates())[0]);
            ((position.get(0)).coordinates())[1] = Math.round((position.get(0).coordinates())[1]);

            ((position.get(1)).coordinates())[0] = Math.round((position.get(1).coordinates())[0]);
            ((position.get(1)).coordinates())[1] = Math.round((position.get(1).coordinates())[1]);

            ((position.get(2)).coordinates())[0] = Math.round((position.get(2).coordinates())[0]);
            ((position.get(2)).coordinates())[1] =  Math.round((position.get(2).coordinates())[1]);

            ((position.get(3)).coordinates())[0] =  Math.round((position.get(3).coordinates())[0]);
            ((position.get(3)).coordinates())[1] =  Math.round((position.get(3).coordinates())[1]);

    }

    /**
     * @return the area of this quadrilateral
     */
    public double area()
    {
        Point p1 = position.get(0);
        Point p2 = position.get(1);
        Point p3 = position.get(2);
        Point p4 = position.get(3);
        return(distance(p1,p2) * distance(p2,p3));
    }

    public double distance(Point p1, Point p2){
        double[] p1Coor = p1.coordinates();
        double [] p2Coor = p2.coordinates();
        double x = Math.pow((p2Coor[0] - p1Coor[0]),2);
        double y = Math.pow((p2Coor[1] - p1Coor[1]), 2);
        double dist = Math.pow((x + y), 0.5);
        return dist;
    }

    /**
     * @return the perimeter (i.e., the total length of the boundary) of this quadrilateral
     */
    public double perimeter() {
        Point p1 = position.get(0);
        Point p2 = position.get(1);
        Point p3 = position.get(2);
        Point p4 = position.get(3);
        return (distance(p1,p2) + distance(p2,p3) + distance(p3,p4) + distance(p4,p1));
    }
}
