class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>>graph=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int []t:times)
        {
            graph.get(t[0]).add(new int[]{t[1],t[2]});
        }

        int dist[]=new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        //source 
        dist[k]=0;

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int []{0,k});

        while(!pq.isEmpty())
        {
            int []curr=pq.poll();
            int time=curr[0];
            int node=curr[1];
            if(time>dist[node])
            {
                continue;
            }
            for(int []neigh:graph.get(node))
            {
                int v=neigh[0];
                int cost=neigh[1];
                if(time+cost<dist[v])
                {
                    dist[v]=time+cost;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }

        int ans=0;
        for(int i=1;i<=n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            ans=Math.max(ans,dist[i]);
        }

        return ans;
    }
}