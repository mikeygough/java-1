public class Minesweeper {
    public static void main(String[] args) {
        // read the command line arguments
        // m x n grid with k mines
        int m = Integer.parseInt(args[0]);
        int bigM = m + 2;
        int n = Integer.parseInt(args[1]);
        int bigN = n + 2;
        int k = Integer.parseInt(args[2]);
        int gridLength = m * n;

        // generate board
        int[][] board = new int[m][n];

        // generate random mine m locations
        // first, create pemutation 0, 1, ..., (m * n) - 1
        int[] ranMine = new int[gridLength];
        for (int i = 0; i < gridLength; i++)
            ranMine[i] = i;
        // create random sample in ranMine[0], ranMine[1], ..., ranMine[k-1]
        for (int i = 0; i < k; i++) {
            // random integer between i and m*n-1
            int r = i + (int) (Math.random() * (gridLength - i));
            // swap elements at indices i and r
            int t = ranMine[r];
            ranMine[r] = ranMine[i];
            ranMine[i] = t;
        }

        // test random m generation
//        System.out.println("random mine location");
//        for (int i = 0; i < k; i++)
//            System.out.print(ranMine[i] + " ");
//        System.out.println();

        // place the k mines uniformly among the mn cells
        for (int i = 0; i < k; i++) {
            int rowLoc = ranMine[i] / n;
            int colLoc = ranMine[i] % n;
            board[rowLoc][colLoc] = 9;
        }

        // test
//        System.out.println("board: ");
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }

        // declare (m+2)-by-(n+2) array for mine searching
        int[][] bigBoard = new int[bigM][bigN];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                bigBoard[i][j] = board[i - 1][j - 1];
            }
        }

        // test
//        System.out.println("big board: ");
//        for (int i = 0; i < bigM; i++) {
//            for (int j = 0; j < bigN; j++) {
//                System.out.print(bigBoard[i][j]);
//            }
//            System.out.println();
//        }

        // count the number of neighboring mines
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // if not mine
                if (bigBoard[i][j] != 9) {
                    int mineCount = 0;
                    // top left
                    if (bigBoard[i - 1][j - 1] == 9) {
                        mineCount++;
                    }
                    // top
                    if (bigBoard[i - 1][j] == 9) {
                        mineCount++;
                    }
                    // top right
                    if (bigBoard[i - 1][j + 1] == 9) {
                        mineCount++;
                    }
                    // left
                    if (bigBoard[i][j - 1] == 9) {
                        mineCount++;
                    }
                    // right
                    if (bigBoard[i][j + 1] == 9) {
                        mineCount++;
                    }
                    // bottom left
                    if (bigBoard[i + 1][j - 1] == 9) {
                        mineCount++;
                    }
                    // bottom
                    if (bigBoard[i + 1][j] == 9) {
                        mineCount++;
                    }
                    // bottom right
                    if (bigBoard[i + 1][j + 1] == 9) {
                        mineCount++;
                    }
                    if (mineCount != 0) {
                        board[i - 1][j - 1] = mineCount;
                    }
                }
            }
        }

        // print the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 9) {
                    System.out.print("*  ");
                } else {
                    System.out.print(board[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
