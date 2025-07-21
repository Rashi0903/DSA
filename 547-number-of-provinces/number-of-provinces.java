class Solution {
    public int findCircleNum(int[][] isConnected) {

        int len=isConnected.length;
        int []parent=new int[len];
        int []rank=new int[len];

        //every node is its own parent
        for(int i=0;i<len;i++)
        {
            parent[i]=i;
        }

        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(isConnected[i][j]==1)
                {
                    union(i,j,parent,rank);
                }
            }
        }
        Set<Integer>set=new HashSet<>();
            for(int i=0;i<len;i++)
            {
                set.add(find(i,parent));
            }
            return set.size();
    }

    public void union(int a,int b,int[]parent,int[]rank)
    {
        int pa=find(a,parent);
        int pb=find(b,parent);
        if(pa!=pb)
        {
            if(rank[pa]<rank[pb])
            {
                parent[pa]=parent[pb];
            }
            else if(rank[pb]<rank[pa])
            {
                parent[pb]=parent[pa];
            }
            else
            {
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }
    public int find(int x,int parent[])
    {
        if(parent[x]!=x)
        {
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
}