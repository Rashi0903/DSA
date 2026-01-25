class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int v=adj.size();
        boolean visit[]=new boolean[v];
        find(adj,ans,0,visit);
        return ans;
    }
    public void find(ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans,int node,boolean []visit)
    {
        visit[node]=true;
        ans.add(node);
        for(int neigh:adj.get(node))
        {
            if(!visit[neigh])
            {
                find(adj,ans,neigh,visit);
            }
        }
    }
}