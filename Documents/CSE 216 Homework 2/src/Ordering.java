import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordering {

    /**
     * A comparator for two-dimensional shapes, based on the vertex with the least x-value. That is, sorting with this
     * comparator must order all the shapes in a collection in increasing order of their least x-valued vertex.
     */
    /*static class XLocationShapeComparator implements Comparator<TwoDShape> {

        @Override
        public int compare(TwoDShape o1, TwoDShape o2) {
            return 0; // TODO
        }
    }

    // TODO: There's a lot wrong with this method. correct it so that it can work properly with generics.
    static <T> void copy(List<TwoDShape> source, List<TwoDShape> destination) {
        destination.addAll(source);
    }


    /**
     * PLEASE READ ALL THE COMMENTS IN THIS CODE CAREFULLY BEFORE YOU START WRITING YOUR OWN CODE.
     */
    public static void main(String[] args) {
        List<TwoDPoint> vert = new ArrayList<TwoDPoint>();
        vert.add(new TwoDPoint(4, -2));
        vert.add(new TwoDPoint(-5, -2));
        vert.add(new TwoDPoint(7, 5));
        vert.add(new TwoDPoint(-1, 5));
        Quadrilateral q = new Quadrilateral(vert); //array list of all the points
        q.setPosition(vert); //set position
        List<? extends Point> newPos =  q.getPosition(); //returns the position
        //get first point
        q.snap();
        System.out.println("Ordered and Snapped quadrilateral vertices");
        TwoDPoint p1 = (TwoDPoint) newPos.get(0);
        double [] c1 = p1.coordinates();
        System.out.println("["+ c1[0] + "," + c1[1]+ "]");
        System.out.println();
        //get second point
        TwoDPoint p2 = (TwoDPoint) newPos.get(1);
        double [] c2 = p2.coordinates();
        System.out.println("[" + c2[0] + ", " + c2[1]+ "]");
        System.out.println();
        //get third point
        TwoDPoint p3 = (TwoDPoint) newPos.get(2);
        double [] c3 = p3.coordinates();
        System.out.println("[" + c3[0] + " " + c3[1] + "]");
        System.out.println();
        //get fourth point
        TwoDPoint p4 = (TwoDPoint) newPos.get(3);
        double [] c4 = p4.coordinates();
        System.out.println("[" + c4[0] + " " + c4[1]+ "]");
        System.out.println();

       List<TwoDPoint> tri = new ArrayList<>();
       tri.add(new TwoDPoint(2,8));
       tri.add(new TwoDPoint(7,5));
       tri.add(new TwoDPoint(2,2));
        Triangle triangle = new Triangle(tri);
        triangle.setPosition(tri);
        List<? extends Point> clockwiseTri = triangle.getPosition();

        //first point
        p1 = (TwoDPoint) clockwiseTri.get(0);
        c1 = p1.coordinates();
        System.out.println("[" + c1[0] + "," + c1[1] + "]");
        System.out.println();
        //second point
        p2 = (TwoDPoint) clockwiseTri.get(1);
        c2 = p2.coordinates();
        System.out.println("[" + c2[0] + "," + c2[1] + "]");
        System.out.println();
        //third point
        p3 = (TwoDPoint) clockwiseTri.get(2);
        c3 = p3.coordinates();
        System.out.println("[" + c3[0] + "," + c3[1] + "]");
        System.out.println();












    }
}

    /* ====== Any additional code you write to create instances or call methods, must be above this line ====== */
    // TODO: The following two lines are using the raw type. Equip them with the proper parameters so that they work with the remainder of the code that follows.
    //List shapes = new ArrayList();
    //List points = new ArrayList();

        /* ====== SECTION 1 ====== */
        /* uncomment the following block and fill in the "..." constructors to create actual instances. If your
         * implementations are correct, then the code should compile and yield the expected results of the various
         * shapes being ordered by their smallest x-coordinate, area, volume, surface area, etc. */

        /*
        shapes.add(new Circle(...));
        shapes.add(new Triangle(...));
        shapes.add(new Quadrilateral(...));

        copy(new ArrayList<Circle>(), shapes); // note-1 //

        // sorting 2d shapes according to various criteria
        shapes.sort(new XLocationShapeComparator());
        Collections.sort(shapes); // TODO: Must sort the two-dimensional shapes in increasing of their area

        // sorting 2d points according to various criteria
        // TODO: Implement a static nested class so that uncommenting the following line works. The XLocationPointComparator must sort all the points in a collection in increasing order of their x-values.
        // points.sort(new XLocationPointComparator());
        Collections.sort(points); // TODO: Must sort the points in increasing order of their distance from the origin
         */

        /* ====== SECTION 2 ====== */
        /* if your changes to copy() are correct, uncommenting the following block will also work as expected note that
         * copy() should work for the line commented with 'note-1' above while at the same time also working with the
         * lines commented with 'note-2', 'note-3', and 'note-4' below. */

        /*
        List<Number>       numbers   = new ArrayList<>();
        List<Double>       doubles   = new ArrayList<>();
        Set<Triangle>      triangles = new HashSet<>();
        Set<Quadrilateral> quads     = new LinkedHashSet<>();

        copy(doubles, numbers); // note-2 //
        copy(quads, shapes);   // note-3 //
        copy(triangles, shapes); // note-4 //
         */

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

        /*List<TwoDShape> lst = new ArrayList<>();
        lst.add(new Circle(...));
        lst.add(new Triangle(...));
        printAllAndReturnLeast(lst, new Printer());
         */
  //  }

   /* // TODO: There's a lot wrong with this method. correct it so that it can work properly with SECTION 3 of the main method written above.
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
    /*static Object printAllAndReturnLeast(List aList, AbstractPrinter aPrinter) {
        Object least = aList.get(0);
        for (Object t : aList) {
            if (least.compareTo(t) > 0)
                least = t;
            aPrinter.print(t);
        }
        return least;
    }
}*/
