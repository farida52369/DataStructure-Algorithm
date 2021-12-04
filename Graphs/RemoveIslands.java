public class RemoveIslands {

    // Places allow going to -- COORDINATES
    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};

    // The indexes are borders.
    public static boolean valid_border(int i, int j, int rows, int cols) {
        return (i == 0 || j == 0 || i == rows - 1 || j == cols - 1);
    }

    // The indexes are in the matrix.
    public static boolean valid_index(int i, int j, int rows, int cols) {
        return (i >= 0 && i < rows && j >= 0 && j < cols);
    }

    // DFS Algorithm.
    public static void dfs(int i, int j, int[][] matrix) {
        if (matrix[i][j] == 1) {
            for (int k = 0; k < 4; k++) {
                int new_x = i + dx[k];
                int new_y = j + dy[k];
                matrix[i][j] = 0;
                if (valid_index(new_x, new_y, matrix.length, matrix[0].length)) {
                    dfs(new_x, new_y, matrix);
                }
            }
        }
    }

    // SOLVE
    public static int[][] solve(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (valid_border(i, j, rows, cols) && matrix[i][j] == 1)
                    dfs(i, j, matrix);
            }
        }
        return matrix;
    }

    // Print RESULT
    public static void printRes(int[][] mat) {
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
	    // EXAMPLE -- HARD CODING
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };
        
        int[][] res = solve(matrix);

        System.out.println("Result:");
        printRes(res);

    }
}

/*
  THE RESULT NEEDED TO BE:
  0 0 0 0 0 0 
  0 0 0 0 0 0 
  0 0 0 0 0 0 
  0 0 0 0 0 0 
  0 0 0 0 0 0 
  0 0 0 0 0 0 
*/
