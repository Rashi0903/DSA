class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        //adjency list
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []edg:edges)
        {
            int u=edg[0];
            int v=edg[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        //bfs
        boolean []visited=new boolean[V];
        Arrays.fill(visited,false);
        for(int i=0;i<V;i++)
        {
            //ip the first element
            if(!visited[i])
            {
                Queue<int []>q=new LinkedList<>();
                q.add(new int[]{i,-1});
                visited[i]=true;
                
                while(!q.isEmpty())
                {
                    int []curr=q.poll();
                    int node=curr[0];
                    int parent=curr[1];
                    
                    for(int neigh:adj.get(node))
                    {
                        if(!visited[neigh])
                        {
                            visited[neigh]=true;
                            q.add(new int[]{neigh,node});
                        }
                        else if(neigh!=parent)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

/*
    edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
    0->1 2
    1->0 2
    2->0 1 3
    3->2
    
    queue=(0,-1)
    visited[]=[t    f   f   f]
    
    step1:- 0->1 2
    visited[]=[t    t   t   f]
    
    1->0 2
    0 is the child for 1; 0 had been the parent + visited
    2 is the child for 1; 2 had been visited + not a parent 
    cycle detected 
    true.
    
 ------------------------------------------------------------------
 
    edges[][] = [[0, 1], [1, 2], [2, 3]]
    0->1
    1->0 2
    2->1 3
    3->2
    
    queue=(0,-1)
    visited[]=[t    f   f   f]
    
    0->1
    visited[]=[t    t   f   f]
    
    1->0 2
    0 is the child of 1 
    ones been a parent + visited
    2 is the child of 1
    not visited
    visited[]=[t    t   t   f]
    
    2->1 3
    1 already visited + parent
    3 not visited
    visited[]=[t    t   t   t]
    
    3->2
    2 already visited + parent
    no cycle detected 
    false
    

*/
