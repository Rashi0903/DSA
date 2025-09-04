class Solution {
    // DSU helper class
    class DSU {
        int[] parent;
        int[] size;
        
        DSU(int n) 
        {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) 
            {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        void union(int a, int b) 
        {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            if (size[pa] < size[pb]) 
            {
                parent[pa] = pb;
                size[pb] += size[pa];
            } 
            else 
            {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
        }

        int find(int x) 
        {
            if (parent[x] != x) 
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        int getSize(int x) 
        {
            return size[find(x)];
        }
    }
        public int largestIsland(int[][] grid) 
        {
            int n = grid.length;
            DSU dsu = new DSU(n * n);
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
            // Step 1: Union all 1's
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    if (grid[i][j] == 1) 
                    {
                        int idx = i * n + j;
                        for (int[] d : dirs) 
                        {
                            int ni = i + d[0], nj = j + d[1];
                            if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 1) 
                            {
                                dsu.union(idx, ni * n + nj);
                            }
                        }
                    }
                }
            }
        
            // Step 2: Try flipping each 0
            int maxIsland = 0;
            boolean hasZero = false;
        
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    if (grid[i][j] == 0) 
                    {
                        hasZero = true;
                        HashSet<Integer> seen = new HashSet<>();
                        int newSize = 1; 
                    
                        for (int[] d : dirs) 
                        {
                            int ni = i + d[0], nj = j + d[1];
                            if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 1) 
                            {
                                int root = dsu.find(ni * n + nj);
                                if (!seen.contains(root)) 
                                {
                                    seen.add(root);
                                    newSize += dsu.getSize(root);
                                }
                            }
                        }
                        maxIsland = Math.max(maxIsland, newSize);
                    }
                }
            }
        
            // Step 3: If no zero found → full grid already 1's
            if (!hasZero) return n * n;
        
            // Step 4: Compare with existing islands (in case best move is not flipping)
            for (int i = 0; i < n * n; i++) 
            {
                if (dsu.find(i) == i) 
                {
                    maxIsland = Math.max(maxIsland, dsu.size[i]);
                }
            }
        
            return maxIsland;
        }
}