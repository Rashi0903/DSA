class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        //1. create adjency list
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        //2. indegree array for neighbours
        int []indegree=new int[V];
        for(int i=0;i<V;i++)
        {
            indegree[i]=0;
        }
        
        //3. fill the adjency list
        for(int e[]:edges)
        {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        
        //4.add to the queue if indegree==0
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        int count=0;
        
        //5. BFS
        while(!q.isEmpty())
        {
            int node = q.poll();
            count++;
            for(int neigh:adj.get(node))
            {
                indegree[neigh]--;
                if(indegree[neigh]==0)
                {
                    q.add(neigh);
                }
            }
        }
        
        if(count!=V)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}


/*
0->1 2
1->2
2->0 3 
3-> X


Kahn’s Algorithm (BFS + Indegree)

Adjacency list bana lo (same jaise pehle).

Har vertex ka indegree calculate karo (kitne edges aa rahe hain 
us vertex pe).

Sab vertices jinka indegree = 0 hai unhe ek queue me daal do.

BFS chalao:

Ek ek karke queue se vertex nikalo, result list me add karo.

Uske neighbors ka indegree 1 kam karo.

Agar kisi ka indegree 0 ho gaya → queue me daal do.

End me check karo:

Agar result list ki size == V (all nodes visited) → 
graph me cycle nahi hai.

Agar result list ki size < V → 
kuch nodes kabhi queue me gaye hi nahi → cycle hai.
*/