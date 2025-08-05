class Solution {
    static class Pair
    {
        int x,y,dist;
        Pair(int x,int y,int dist)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n) {
        // Code here
        
        //all the possible position
        int[]dx={-2, -1, 1, 2, -2, -1, 1, 2};
        int []dy={1, 2, 2, 1, -1, -2, -2, -1};
        
        boolean[][]visited=new boolean [n+1][n+1];
        Queue<Pair>q=new LinkedList<>();
        
        //knight curr positon in the queue
        q.add(new Pair(KnightPos[0],KnightPos[1],0));
        visited[KnightPos[0]][KnightPos[1]]=true;
        
        //start traversing
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            
            //Target Found?
            if(curr.x==TargetPos[0] && curr.y==TargetPos[1])
            {
                return curr.dist;
            }
            
            //not found then add all the 8 post in the queue
            for(int i=0;i<8;i++)
            {
                int nx=curr.x+dx[i];
                int ny=curr.y+dy[i];
                
                if(nx>=1 && ny<=n && ny>=1 && nx<=n )
                {
                    if(!visited[nx][ny])
                    {
                        q.add(new Pair(nx,ny,curr.dist+1));
                        visited[nx][ny]=true;
                    }
                }
            }
        }
        return -1;
        
    }
}

/*
algo :- bfs 
queue:- {i,j,distance}
knight moves in 8 direction

dx = {-2, -1, 1, 2, -2, -1, 1, 2};
dy = {1, 2, 2, 1, -1, -2, -2, -1};

visited[][] to check that we won't traverse the same cell again
if({i,j}==Targe4tpos[])
{
    rturn distance;
}
*/
