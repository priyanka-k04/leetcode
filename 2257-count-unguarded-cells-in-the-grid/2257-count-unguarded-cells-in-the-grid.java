class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] grid = new int[m][n];
        // guard = 1, wall = -1, guarded cell = 2, empty = 0

        // Mark guards
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        // Mark walls
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }

        // Directions: down, up, right, left
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int count = 0;

        // For each guard, spread visibility
        for (int i = 0; i < guards.length; i++) {
            int row = guards[i][0];
            int col = guards[i][1];

            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                // Move in current direction until blocked
                while (r >= 0 && r < m && c >= 0 && c < n &&
                       grid[r][c] != 1 && grid[r][c] != -1) {

                    if (grid[r][c] == 0) {
                        count++;         // guarding this cell
                        grid[r][c] = 2;  // mark as guarded
                    }

                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        // total unguarded = total cells - guarded cells - guards - walls
        return m * n - count - guards.length - walls.length;
    }
}
