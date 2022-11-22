public class ShannonEntropy {
    public static void main(String[] args) {
        // number of integers to read
        int m = Integer.parseInt(args[0]);

        // intitialize count array
        int[] count = new int[m + 1];

        // read all integers
        // add count to count array
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            count[value]++;
        }

        // test
//        for (int i = 0; i < count.length; i++) {
//            StdOut.println(i + " count " + count[i]);
//        }

        // initialize total input
        double totalCount = 0;
        for (int i = 0; i < count.length; i++) {
            totalCount += count[i];
        }

        // initialize proportion array
        double[] prop = new double[count.length];
        // calculate proportion
        for (int i = 0; i < count.length; i++) {
            prop[i] = count[i] / totalCount;
        }

        // test
//        for (int i = 0; i < prop.length; i++) {
//            StdOut.println(i + " proportion " + prop[i]);
//        }

        double h = 0;

        for (int i = 0; i < prop.length; i++) {
            if (prop[i] != 0) {
                h += -1.0 * prop[i] * (Math.log(prop[i]) / Math.log(2.0));
            }
        }
        StdOut.printf("%.4f\n", h);
    }
}
