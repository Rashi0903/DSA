class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        int []indegree=new int[n];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        Arrays.fill(indegree,0);
        for(int []i:prerequisites)
        {
            int course=i[0];
            int pre=i[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            count++;
            for(int neigh:adj.get(curr))
            {
                indegree[neigh]--;
                if(indegree[neigh]==0)
                {
                    q.add(neigh);
                }
            }
        }
        return (count==n);
    }
}