class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        ArrayList<Integer>ans=new ArrayList<>();
        if(n==1)
        {
            ans.add(0);
            return ans;
        }
        List<List<Integer>>adj=new ArrayList<>();
        int []degree=new int[n];

        //create an arraylist
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        //complete the arraylist
        for(int []e:edges)
        {
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        //add to the queue
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(degree[i]==1)
            {
                q.add(i);
            }
        }

        //remove the leaves
        int left=n;
        while(left>2)
        {
            int size=q.size();
            left-=size;
            for(int i=0;i<size;i++)
            {
                int curr=q.poll();
                for(int neigh:adj.get(curr))
                {
                    degree[neigh]--;
                    if(degree[neigh]==1)
                    {
                        q.add(neigh);
                    }
                }
            }
        }

       
        while(!q.isEmpty())
        {
            ans.add(q.poll());
        }
        return ans;
    }
}