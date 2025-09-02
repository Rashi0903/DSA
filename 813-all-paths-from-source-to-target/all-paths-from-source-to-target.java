class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       int n=graph.length;
       List<List<Integer>>ans=new ArrayList<>();
       Queue<List<Integer>>q=new LinkedList<>();
        List<Integer>start=new ArrayList<>();
        start.add(0);
        q.add(start);
        while(!q.isEmpty())
        {
            List<Integer>curr=q.poll();
            int node=curr.get(curr.size()-1);
            if(node==n-1)
            {
                ans.add(new ArrayList<>(curr));
            }

            else
            {
                for(int neigh:graph[node])
                {
                    List<Integer>newPath=new ArrayList<>(curr);
                    newPath.add(neigh);
                    q.add(newPath);
                }
            }
        } 
        return ans;
    }
}