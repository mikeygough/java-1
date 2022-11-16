public class RandomWalker {
    public static void main(String[] args) {
//      initialize values
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int current_x = 0;
        int current_y = 0;
        int manhattanDistance = 0;
        System.out.println("(" + current_x + ", " + current_y + ")");
        while (manhattanDistance != r) {
//          generate random number
            int rand = 1 + (int) (Math.random() * ((4 - 1) + 1));
            if (rand == 1) {
                current_x += 1;
            } else if (rand == 2) {
                current_x -= 1;
            } else if (rand == 3) {
                current_y += 1;
            } else {
                current_y -= 1;
            }
            steps++;
            System.out.println("(" + current_x + ", " + current_y + ")");
            manhattanDistance = Math.abs(current_x) + Math.abs(current_y);
        }
        System.out.println("steps = " + steps);
    }
}
