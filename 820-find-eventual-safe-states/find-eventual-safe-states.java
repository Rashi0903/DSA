class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int outdegree[]=new int[n];
        List<List<Integer>>rever=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            rever.add(new ArrayList<>());
        }
        for(int u=0;u<n;u++)
        {
            for(int v:graph[u])
            {
                rever.get(v).add(u);
                outdegree[u]++;
            }

        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(outdegree[i]==0)
            {
                q.offer(i);
            }
        }

        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.poll();
            ans.add(node);
            for(int parent:rever.get(node))
            {
                outdegree[parent]--;
                if(outdegree[parent]==0)
                {
                    q.offer(parent);

                }
            }
        }
        Collections.sort(ans);
        return ans;

    }
}