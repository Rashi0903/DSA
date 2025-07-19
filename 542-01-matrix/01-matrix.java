class pair{
    int i;
    int j;
    pair(int i,int j)
    {
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m;
        int n;
        m=mat.length;
        n=mat[0].length;
        Queue<pair>q=new LinkedList<>();
        int [][]ans=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    ans[i][j]=0;
                    q.add(new pair(i,j));
                }
                else
                {
                    ans[i][j]=-1;
                }
            }
        } 
        while(!q.isEmpty())
        {
            pair curr=q.poll();
            int i=curr.i;
            int j=curr.j;
            int row[]={-1,0,1,0};
            int col[]={0,1,0,-1};
            for(int x=0;x<4;x++)
            {
                int nrow=i+row[x];
                int ncol=j+col[x];
                if((nrow>=0 && nrow<m) && (ncol>=0 && ncol<n) && (ans[nrow][ncol]==-1))
                {
                    ans[nrow][ncol]=ans[i][j]+1;
                    q.add(new pair(nrow,ncol));
                }
            }
        }
        return ans;
    }
}