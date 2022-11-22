public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);

        for (double i = 0.5; i < n; i++) {
            for (double j = 0.5; j < n; j++) {
                if ((int) j % 2 == 1) {
                    if ((int) i % 2 == 1) {
                        StdDraw.setPenColor(StdDraw.BLUE);
                    } else {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    }
                    // note that i, j mark the center of the square
                    StdDraw.filledSquare(i, j, 0.5);
                } else if ((int) j % 2 == 0) {
                    if ((int) i % 2 == 1) {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    } else {
                        StdDraw.setPenColor(StdDraw.BLUE);
                    }
                    StdDraw.filledSquare(i, j, 0.5);
                }
            }
        }
    }
}
