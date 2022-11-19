public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int aLength = args.length - 1;
        // define the cumulative sums
        // pick a random integer r uniformly
        // find the unique index i

        // test
//        System.out.println("args:");
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }

        // copy args values into a
        int[] a = new int[aLength];
        for (int i = 1; i < args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
        }

        // test
//        System.out.println("a:");
//        for (int i = 0; i < aLength; i++) {
//            System.out.println(a[i]);
//        }

        // calculate cumulative sums
        int[] csums = new int[aLength];
        for (int i = 0; i < aLength; i++) {
            if (i == 0) {
                csums[i] = a[0];
            } else {
                csums[i] = a[i] + csums[i - 1];
            }
        }

        // test
//        System.out.println("csum:");
//        for (int i = 0; i < csums.length; i++) {
//            System.out.println(csums[i]);
//        }

        // run simulation
        for (int i = 0; i < m; i++) {
            // pick a random integer r uniformly between 0 and Sn−1
            int r;
            if (csums.length == 0) {
                r = 0;
            } else {
                r = (int) (Math.random() * (csums[csums.length - 1]));
            }
            for (int j = 0; j < csums.length; j++) {
                if (j == 0) {
                    if (r >= 0 && r < csums[j]) {
                        System.out.print("1 ");
                    }
                } else {
                    if (r >= csums[j - 1] && r < csums[j]) {
                        System.out.print(j + 1 + " ");
                    }
                }
            }
        }
        System.out.println();
    }
}
