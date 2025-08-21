class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int []e:edges)
        {
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
        }
        
        int []indegree=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int neigh:adj.get(i))
            {
                indegree[neigh]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        ArrayList<Integer>ans=new ArrayList<>();
        int idx=0;
        
        while(!q.isEmpty())
        {
            int curr=q.poll();
            ans.add(curr);
            
            for(int neigh:adj.get(curr))
            {
                indegree[neigh]--;
                if(indegree[neigh]==0)
                {
                    q.add(neigh);
                }
            }
        }
        return ans;
    }
}
/*
*/