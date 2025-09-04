class Solution {
    public int swimInWater(int[][] grid) {
      int n=grid.length;
      boolean [][]visited=new boolean[n][n];
      PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
      int ans=0;
      int dx[]={-1,1,0,0};
      int dy[]={0,0,-1,1};
      pq.add(new int[]{grid[0][0],0,0});
      while(!pq.isEmpty())
      {
        int []curr=pq.poll();
        int elevation=curr[0];
        int x=curr[1];
        int y=curr[2];
        ans=Math.max(ans,elevation);
        if(x==n-1 && y==n-1)
        {
            return ans;
        }
        if(visited[x][y])
        {
            continue;
        }
        visited[x][y]=true;
        for(int k=0;k<4;k++)
        {
            int nx=x+dx[k];
            int ny=y+dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny])
            {
                pq.add(new int[]{grid[nx][ny],nx,ny});
                
            }
        }
      }
      return -1;
    }
}