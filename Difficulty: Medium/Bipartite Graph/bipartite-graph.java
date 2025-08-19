class Solution {
    public boolean isBipartite(int v, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int []e:edges)
        {
            int u=e[0];
            int V=e[1];
            adj.get(u).add(V);
            adj.get(V).add(u);
        }
        
        int color[]=new int [v];
        Arrays.fill(color,-1);
        
        for(int i=0;i<v;i++)
        {
            if(color[i]==-1)
            {
                color[i]=0;
                Queue<Integer>q=new LinkedList<>();
                q.add(i);
                color[i]=0;
                while(!q.isEmpty())
                {
                    int curr=q.poll();
                    for(int neigh:adj.get(curr))
                    {
                        if(color[neigh]==-1)
                        {
                            color[neigh]=1-color[curr];
                            q.add(neigh);
                        }
                        
                        //odd len detect
                        else if(color[neigh]==color[curr])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
/*
“A graph is bipartite if and only if it contains no cycle of odd length.”

*/