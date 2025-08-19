class Pair {
    int row, col, time;
    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: add rotten + count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int ans = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // Step 2: BFS
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
            ans = Math.max(ans, t);
            
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && mat[nx][ny] == 1) {
                    mat[nx][ny] = 2; // rot it
                    fresh--;        // reduce fresh
                    q.add(new Pair(nx, ny, t + 1));
                }
            }
        }
        
        // Step 3: Check if fresh remain
        if (fresh > 0) return -1;
        return ans;
    }
}
