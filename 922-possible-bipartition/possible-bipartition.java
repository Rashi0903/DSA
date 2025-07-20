class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        //create adjency list
        List<Integer>[]adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int d[]:dislikes)   //[1,2] 1->2 2->1 (d[0]=1 d[1]=2)
        {
            adj[d[0]].add(d[1]);    //1->2
            adj[d[1]].add(d[0]);       //2->1
        }

        //check the piring 
        int color[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {   //initially all the elements color is 0
            color[i]=0;
        }

        for(int i=0;i<=n;i++)
        {
            Queue<Integer>q=new LinkedList<>();

            //if  visited ignore it
            if(color[i]!=0) continue;
            
            //if not visited
            q.add(i);
            color[i]=1;
            while(!q.isEmpty())
            {
                int curr=q.poll();

                //nodes k neighbours mai jayai gai 
                for(int neigh:adj[curr])
                {
                    if(color[neigh]==0)
                    {
                        //not visited
                        color[neigh]=-color[curr];  //opp color
                        q.add(neigh);
                    }
                    else if(color[neigh]==color[curr])
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}