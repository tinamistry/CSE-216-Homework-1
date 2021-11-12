import java.util.*;

import static java.util.Collections.unmodifiableList;

public class Ordering  {

    /**
     * A comparator for two-dimensional shapes, based on the vertex with the least x-value. That is, sorting with this
     * comparator must order all the shapes in a collection in increasing order of their least x-valued vertex.
     */
    static class XLocationShapeComparator implements Comparator<TwoDShape> {
        @Override
        public int compare(TwoDShape o1, TwoDShape o2) {
            if (o1 instanceof Circle && o2 instanceof Circle) {
                Circle c = (Circle) o1;
                Circle c2 = (Circle) o2;
                if (c.lowestX() < c2.lowestX())
                    return -1;
                else if (c.lowestX() > c2.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Circle && o2 instanceof Quadrilateral) {
                Circle c = (Circle) o1;
                Quadrilateral q = (Quadrilateral) o2;
                if (c.lowestX() < q.lowestX())
                    return -1;
                else if (c.lowestX() > q.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Circle && o2 instanceof Triangle) {
                Circle c = (Circle) o1;
                Triangle t = (Triangle) o2;
                if (c.lowestX() < t.lowestX())
                    return -1;
                else if (c.lowestX() > t.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Quadrilateral && o2 instanceof Quadrilateral) {
                Quadrilateral q = (Quadrilateral) o1;
                Quadrilateral q2 = (Quadrilateral) o2;
                if (q.lowestX() < q2.lowestX())
                    return -1;
                else if (q.lowestX() > q2.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Quadrilateral && o2 instanceof Circle) {
                Quadrilateral q = (Quadrilateral) o1;
                Circle c = (Circle) o2;
                if (q.lowestX() < c.lowestX())
                    return -1;
                else if (q.lowestX() > c.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Quadrilateral && o2 instanceof Triangle) {
                Quadrilateral q = (Quadrilateral) o1;
                Triangle t = (Triangle) o2;
                if (q.lowestX() < t.lowestX())
                    return -1;
                else if (q.lowestX() > t.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Triangle && o2 instanceof Triangle) {
                Triangle t = (Triangle) o1;
                Triangle t2 = (Triangle) o2;
                if (t.lowestX() < t2.lowestX())
                    return -1;
                else if (t.lowestX() > t2.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Triangle && o2 instanceof Quadrilateral) {
                Triangle t = (Triangle) o1;
                Quadrilateral q = (Quadrilateral) o2;
                if (t.lowestX() < q.lowestX())
                    return -1;
                else if (t.lowestX() > q.lowestX())
                    return 1;
                else
                    return 0;
            } else if (o1 instanceof Triangle && o2 instanceof Circle) {
                Triangle t = (Triangle) o1;
                Circle c = (Circle) o2;
                if (t.lowestX() < c.lowestX())
                    return -1;
                else if (t.lowestX() > c.lowestX())
                    return 1;
                else
                    return 0;
            } else
                throw new IllegalArgumentException("Inputs are not shapes");
        }
    }

    static class AreaComparator implements Comparator<TwoDShape> {
        @Override
        public int compare(TwoDShape o1, TwoDShape o2) {
            if (o1.area() < o2.area())
                return -1;
            else if (o1.area() > o2.area())
                return 1;
            else return 0;
        }
    }

    static class XLocationPointComparator implements Comparator<TwoDPoint> {

        @Override
        public int compare(TwoDPoint o1, TwoDPoint o2) {
            if ((o1.coordinates())[0] < ((o2.coordinates())[0])) {
                return -1;
            } else if ((o1.coordinates())[0] > ((o2.coordinates())[0])) {
                return 1;
            } else
                return 0;

        }
    }
    

    //TODO: There's a lot wrong with this method. correct it so that it can work properly with generics.
    static <T> void copy(Collection<T> source, Collection<? super T> destination) {
        destination.addAll(source);
    }


    /**
     * PLEASE READ ALL THE COMMENTS IN THIS CODE CAREFULLY BEFORE YOU START WRITING YOUR OWN CODE.
     */
    public static void main(String[] args) {


        //testing quadrilateral
        /*List<TwoDPoint> quadPoints = new ArrayList<>();
        quadPoints.add(new TwoDPoint(6.2,3.5));
        quadPoints.add(new TwoDPoint(6.1,10.3));
        quadPoints.add(new TwoDPoint(1.6,3.7));
        quadPoints.add(new TwoDPoint(1.9,4.9));
        quadPoints.add(new TwoDPoint(1,1));
        quadPoints.add(new TwoDPoint(0,0));
        Quadrilateral quad1 = new Quadrilateral(quadPoints);
        quad1.snap();
        System.out.println("The snapped and ordered vertices of this quadrilateral: ");
        System.out.println(quad1.toString());
        System.out.println("The area of this quadrilateral is " + quad1.area());
        System.out.println("The perimeter of this quadrilateral is " + quad1.perimeter());*/




        /* ====== Any additional code you write to create instances or call methods, must be above this line ====== */
        // TODO: The following two lines are using the raw type. Equip them with the proper parameters so that they work with the remainder of the code that follows.
        List<TwoDShape> shapes = new ArrayList();
        List<TwoDPoint> points = new ArrayList();

        /* ====== SECTION 1 ====== */
        /* uncomment the following block and fill in the "..." constructors to create actual instances. If your
         * implementations are correct, then the code should compile and yield the expected results of the various
         * shapes being ordered by their smallest x-coordinate, area, volume, surface area, etc. */
        shapes.add(new Circle(1, 1, 1));
        List<TwoDPoint> tri1 = new ArrayList<>();
        tri1.add(new TwoDPoint(2, 2));
        tri1.add(new TwoDPoint(7, 5));
        tri1.add(new TwoDPoint(2, 8));
        shapes.add(new Triangle(tri1));

        List<TwoDPoint> quad = new ArrayList<>();
        quad.add(new TwoDPoint(-5, -2));
        quad.add(new TwoDPoint(7, 5));
        quad.add(new TwoDPoint(4, -2));
        quad.add(new TwoDPoint(-1, 5));
        shapes.add(new Quadrilateral(quad));

        copy(new ArrayList<Circle>(), shapes); // note-1 //

        // sorting 2d shapes according to various criteria
        shapes.sort(new AreaComparator());
        Collections.sort(shapes); // TODO: Must sort the two-dimensional shapes in increasing of their area

        // sorting 2d points according to various criteria
        // TODO: Implement a static nested class so that uncommenting the following line works. The XLocationPointComparator must sort all the points in a collection in increasing order of their x-values.
        points.sort(new XLocationPointComparator());
        Collections.sort(points); // TODO: Must sort the points in increasing order of their distance from the origin


        /* ====== SECTION 2 ====== */
        /* if your changes to copy() are correct, uncommenting the following block will also work as expected note that
         * copy() should work for the line commented with 'note-1' above while at the same time also working with the
         * lines commented with 'note-2', 'note-3', and 'note-4' below. */

        List<Number> numbers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        Set<Triangle> triangles = new HashSet<>();
        Set<Quadrilateral> quads = new LinkedHashSet<>();

        copy(doubles, numbers); // note-2 //
        copy(quads, shapes);   // note-3 //
        copy(triangles, shapes); // note-4 //






        /* ====== SECTION 3 ====== */
        /* uncomment the following lines of code and fill in the "..." constructors to create actual instances. You may
         * test your code with more instances (the two lines are provided just as an example that different types of
         * shapes can be added). If your implementations are correct, the code should compile and print the various
         * shapes in their human-readable string forms. Note that you have to implement a certain method in the classes
         * that implement the TwoDShape interface, so that the printed values are indeed in a human-readable form. These
         * are defined as follows:
         *
         * Circle centered at (x,y) of radius r: "Circle[center: x, y; radius: r]"
         * Triangle with three vertices: "Triangle[(x1, y1), (x2, y2), (x3, y3)]"
         * Quadrilateral with four vertices: "Quadrilateral[(x1, y1), (x2, y2), (x3, y3), (x4, y4)]"
         *
         * For triangles and quadrilaterals, the vertex ordering is specified in the documentation of their respective
         * getPosition methods. Each point must be represented up to two decimal places. For the purpose of this assignment,
         * you may safely assume that no test input will be used in grading where a vertex has more than two decimal places.
         */

        List<TwoDPoint> triVert = new ArrayList<>();
        triVert.add(new TwoDPoint(0, 5));
        triVert.add(new TwoDPoint(1, 0));
        triVert.add(new TwoDPoint(3, 0));
        List<TwoDShape> lst = new ArrayList<>();
        lst.add(new Circle(1, 1, 1));
        lst.add(new Triangle(triVert));
        printAllAndReturnLeast(lst, new Printer());


        // TODO: There's a lot wrong with this method. correct it so that it can work properly with SECTION 3 of the main method written above.
        // NOTE: This method may compile after you implement just one thing, but pay attention to the warnings in your IDE.
        // Just because the method compiles doesn't mean it is fully correct.
        /**
         * This method prints each element of a list of various types of two-dimensional shapes (i.e., {@link TwoDShape}, as
         * defined in the {@link Printer<TwoDShape>#print} method. When the printing process is complete, it returns the
         * least instance, as per the natural order of the {@link TwoDShape} instances. SECTION 1 in the main method above
         * defines this natural order.
         *
         * Note that the natural ordering of shapes is not provided to you. This is something you must implement as part of
         * the assignment.
         *
         * @param aList the list of provided two-dimensional shape instances
         * @param aPrinter the specified printer instance
         * @return the least element from <code>aList</code>, as per the natural ordering of the shapes
         */

    }
    static TwoDShape printAllAndReturnLeast (List<TwoDShape> aList, AbstractPrinter aPrinter) {
       TwoDShape least = aList.get(0);
            for (Object t : aList) {
                if (least.compareTo(t) > 0)
                    least = (TwoDShape) t;
                aPrinter.print(t);
            }
            return least;

        }


    }

