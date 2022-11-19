public class ThueMorse {
    public static void main(String[] args) {
        // get inputs
        int n = Integer.parseInt(args[0]);
        int[] a;
        if (n == 0) {
            a = new int[1];
        } else {
            a = new int[n];
        }

        // calculate ThueMorse
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                a[i] = 0;
            } else if (i % 2 == 1) {
                a[i] = 1 - a[i - 1];
            } else if (i % 2 == 0) {
                a[i] = a[i / 2];
            }
        }

        // print
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == a[i]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
