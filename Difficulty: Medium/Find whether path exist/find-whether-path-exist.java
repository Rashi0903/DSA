
class Solution {
    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        
        int sx=-1;
        int sy=-1;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    sx=i;
                    sy=j;
                }
            }
        }
        
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{sx,sy});
        
        int []dx={1,-1,0,0};
        int []dy={0,0,-1,1};
        
        boolean [][]visited=new boolean[m][n];
        
        while(!q.isEmpty())
        {
            int []curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            
            for(int i=0;i<4;i++)
            {
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny])
                {
                    if(grid[nx][ny]==2)
                    {
                        return true;
                    }
                    if(grid[nx][ny]==3)
                    {
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
}
/*
1-source
2-destination
3-blank
0-block


*/