public class WorldMap {
    public static void main(String[] args) {
        // read in bounding box and rescale
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // to speed up performance, defer displaying points
        StdDraw.enableDoubleBuffering();

        // plot polygons one at a time
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int vertices = StdIn.readInt();
            double[] x = new double[vertices];
            double[] y = new double[vertices];
            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            // void polygon(double[] x, double[] y)
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
