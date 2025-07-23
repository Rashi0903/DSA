class Solution {
    int dx[]={-1,0,1,0};
    int dy[]={0,-1,0,1};
    boolean visited[][];
    char grid[][];
    int m,n;
    public boolean containsCycle(char[][] grid) {

        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!visited[i][j])
                {
                    if(bfs(i,j,grid[i][j]))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(int sx,int sy,char c)
    {
        Queue<int[]>q=new LinkedList<>();

        //input of first element of that charecter
        q.offer(new int[]{sx,sy,-1,-1});
        visited[sx][sy]=true;
        while(!q.isEmpty())
        {
            int []curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            int px=curr[2];
            int py=curr[3];
            for(int k=0;k<4;k++)
            {
                int nx=x+dx[k];
                int ny=y+dy[k];
                if(nx<0 || ny<0 || nx>=m || ny>=n)
                {
                    continue;
                }
                if(grid[nx][ny]!=c)
                {
                    continue;
                }
                if(!visited[nx][ny])
                {
                    q.offer(new int[]{nx,ny,x,y});
                    visited[nx][ny]=true;
                }
                else
                {
                    if(!(nx==px && ny==py))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}