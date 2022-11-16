public class RightTriangle {
    public static void main(String[] args) {
//      dont assume a, b and c will be passed in the correct order
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

//      generate a, b and c
        int trueC = Math.max(Math.max(a, b), c);
        int trueA = Math.min(Math.min(a, b), c);
        int trueB = a + b + c - trueA - trueC;

//      check for non-negative integers
        boolean positiveA = trueA > 0;
        boolean positiveB = trueB > 0;
        boolean positiveC = trueC > 0;
        boolean sum = (trueA * trueA + trueB * trueB == trueC * trueC);

        boolean isTriangle = positiveA && positiveB && positiveC & sum;
        System.out.println(isTriangle);
//        if (trueA < 0 || trueB < 0 || trueC < 0) {
//            System.out.println("false");
//        } else if (trueA * trueA + trueB * trueB != trueC * trueC) {
//            System.out.println("false");
//        } else {
//            System.out.println("true");
//        }

    }
}
