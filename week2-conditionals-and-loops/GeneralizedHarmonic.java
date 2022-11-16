public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double r = Double.parseDouble(args[1]);

        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1 / Math.pow(i, r);
        }

        System.out.println(sum);
    }
}
