public class CMYKtoRGB {
    public static void main(String[] args) {
//      get args cmyk
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

//      convert to rgb
        double white = 1 - black;
        double red = 255 * white * (1 - cyan);
        double green = 255 * white * (1 - magenta);
        double blue = 255 * white * (1 - yellow);

//      round and int cast
        int redInt = (int) Math.round(red);
        int greenInt = (int) Math.round(green);
        int blueInt = (int) Math.round(blue);

        System.out.println("red   = " + redInt);
        System.out.println("green = " + greenInt);
        System.out.println("blue  = " + blueInt);
    }
}
