//union find
class Solution {
    int parent[];
    int rank[];

    public int find(int x)
    {
        if(parent[x]!=x)
        {
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public void union(int px,int py)
    {
        if(rank[px]<rank[py])
        {
            parent[px]=py;
        }
        else if(rank[py]<rank[px])
        {
            parent[py]=px;
        }
        else
        {
            parent[py]=px;
            rank[px]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }

        int extra=0;
        int group=n;
        for(int con[]:connections)
        {
            int x=con[0];
            int y=con[1];
            int px=find(x);
            int py=find(y);

            if(px==py)
            {
                extra++;
            }
            else
            {
                union(px,py);
                group--;
            }
        }

        int need=group-1;
        if(extra>=need)
        {
            return need;
        }
        else
        {
            return -1;
        }
    }
}