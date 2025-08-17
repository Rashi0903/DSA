class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        
        int v=adj.size();
        
        Queue<Integer>q=new LinkedList<>();
        
        boolean visited[]=new boolean [v];
        
        q.add(0);
        visited[0]=true;
        
        while(!q.isEmpty())
        {
            int node=q.poll();
            ans.add(node);
            
            for(int neigh:adj.get(node))
            {
                if(visited[neigh]!=true)
                {
                    q.add(neigh);
                    visited[neigh]=true;
                }
            }
        }
        return ans;
    }
}