class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
        grid[0][0] = 1;
        q.offer(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int x = curr[0];
            int y = curr[1];
            if (x == n - 1 && y == n - 1) {
                return grid[x][y];
            }
            for (int k = 0; k < 8; k++) {
                int nrow = x + dx[k];
                int ncol = y + dy[k];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0) {
                    grid[nrow][ncol] = grid[x][y] + 1;
                    q.offer(new int[] { nrow, ncol });
                }
            }
        }
        return -1;
    }
}