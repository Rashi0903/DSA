class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> paci = new LinkedList<>();
        Queue<int[]> atlan = new LinkedList<>();

        // Pacific borders
        for (int i = 0; i < n; i++) 
        {
            pacific[i][0] = true;
            paci.offer(new int[]{i, 0});
        }
        for (int j = 0; j < m; j++) 
        {
            pacific[0][j] = true;
            paci.offer(new int[]{0, j});
        }

        // Atlantic borders
        for (int i = 0; i < n; i++) 
        {
            atlantic[i][m - 1] = true;  
            atlan.offer(new int[]{i, m - 1});
        }
        for (int j = 0; j < m; j++) 
        {
            atlantic[n - 1][j] = true;  
            atlan.offer(new int[]{n - 1, j});
        }

        // BFS for Pacific and Atlantic
        bfs(heights, paci, pacific);
        bfs(heights, atlan, atlantic);

        // Collect result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int n = heights.length;
        int m = heights[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) 
        {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int k = 0; k < 4; k++) 
            {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // Check bounds
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) 
                {
                    continue;
                }
                // Skip visited or lower height
                if (visited[nx][ny] || heights[nx][ny] < heights[x][y])             
                {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}