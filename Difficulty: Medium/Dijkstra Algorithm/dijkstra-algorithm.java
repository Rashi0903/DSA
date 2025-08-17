class Pair
{
    int node, weight;
    Pair(int n,int w)
    {
        node=n;
        weight=w;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        //make the adj list
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        //add edges for each vertices
        for(int e[]:edges)
        {
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        //distance array = final array
        int []dist=new int[V];
        
        //initially distance is infinity 
        for(int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(src,0));
        
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            int u=curr.node;
            int d=curr.weight;
            if(d>dist[u])
            {
                continue;
            }
            
            for(Pair neigh:adj.get(u))
            {
                int v=neigh.node;
                int wt=neigh.weight;
                
                if(dist[u]+wt<dist[v])
                {
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
    }
}