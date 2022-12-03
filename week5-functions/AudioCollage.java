public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        // initialize new array
        double[] amplified = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amplified[i] = a[i] * alpha;
        }
        return amplified;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        // initialize new array
        double[] reversed = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            reversed[i] = a[a.length - i - 1];
        }
        return reversed;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        // initialize new array
        double[] merged = new double[a.length + b.length];
        // add a sound
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        // add b sound
        for (int i = 0; i < b.length; i++) {
            merged[i + a.length - 1] = b[i];
        }
        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        // determine array length
        int length = Math.max(a.length, b.length);
        // initialize new array
        double[] mixed = new double[length];
        // pad
        for (int i = 0; i < length; i++) {
            if (i > a.length - 1) {
                mixed[i] = b[i] + 0;
            } else if (i > b.length - 1) {
                mixed[i] = a[i] + 0;
            } else {
                mixed[i] = a[i] + b[i];
            }
        }
        return mixed;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        // initialize new array
        double aLength = (double) a.length;
        double adjustedLength = aLength / alpha;
        int floorAdjustedLength = (int) Math.floor(adjustedLength);
        double[] adjusted = new double[floorAdjustedLength];
        int intAlpha = (int) alpha;
        for (int i = 0; i < adjusted.length; i++) {
            adjusted[i] = a[i * intAlpha];
        }
        return adjusted;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        double[] a = StdAudio.read("piano.wav");
//        StdAudio.play(a);
        double[] b = StdAudio.read("singer.wav");
        // amplify
        double[] amplified = amplify(a, 0.1);
        StdAudio.play(amplified);
        // reverse
        double[] reversed = reverse(a);
        StdAudio.play(reversed);
        // merge
        double[] merged = merge(a, b);
        StdAudio.play(merged);
        // mix
        double[] mixed = mix(a, b);
        StdAudio.play(mixed);
        // change speed
        double[] adjusted = changeSpeed(a, 2);
        StdAudio.play(adjusted);
    }
}
