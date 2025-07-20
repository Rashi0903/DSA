class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;

        //create a color array
        int color[]=new int [n];
        for(int i=0;i<n;i++)
        {
            color[i]=0;
        }

        //going to each node 
        for(int i=0;i<n;i++)
        {
            Queue<Integer>q=new LinkedList<>();
            //already visited
            if(color[i]!=0)
            {
                continue;
            }

            //first element into the queue
            q.offer(i);
            color[i]=1;

            while(!q.isEmpty())
            {
                int curr=q.poll();
                
                //finding its adjacent nodes
                for(int neigh:graph[curr])
                {

                    //same color then not bipartite
                    if(color[neigh]==color[curr])
                    {
                        return false;
                    }

                    else if(color[neigh]==0)
                    {
                        color[neigh]=-color[curr];
                        q.offer(neigh);
                    }
                }
            }

        }
        return true;
    }
}