class Pair
{
    int node;
    int weight;
    Pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int []e:edges)
        {
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        boolean visited[]=new boolean[V];
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(0,0));
        int weigh=0;
        
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            
            if(visited[curr.node])
            {
                continue;
            }
            
            visited[curr.node]=true;
            weigh+=curr.weight;
            
            for(Pair neigh: adj.get(curr.node))
            {
                if(!visited[neigh.node])
                {
                    pq.add(new Pair(neigh.node,neigh.weight));
                }
            }
        }
        return weigh;
    }
}
/*
V = 3, E = 3, Edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]

*/