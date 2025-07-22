//union find

class Solution {
    int parent[];
    int rank[];
    
    public void union(int a,int b)
    {
        int px=find(a);
        int py=find(b);

        //a and b have same parents
        if(px==py)
        {
            return;
        }
        
        //differnt parents then work on rank
        if(rank[px]<rank[py])   
        //case1:- if rank of py is more then px is the child
        {
            parent[px]=py;
        }
        else if(rank[py]<rank[px])  
        //case2:- if rank of px is more then py is the child
        {
            parent[py]=px;
        }
        else
        {
            //case3:- same rank then make px the parent
            parent[py]=px;
            rank[px]++;
        }
    }

    public int find(int x)
    {
        if(parent[x]!=x)
        {
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public int removeStones(int[][] stones) 
    {
        parent=new int[20005];
        rank=new int[20005];
        int n=stones.length;

        //making all the nodes as their own parent with rank 1
        for(int i=0;i<20005;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }

        Set<Integer>seen=new HashSet<>();
        for(int []s:stones)
        {
            int r=s[0];
            int c=s[1]+10001;
            union(r,c); //union of row and col with their parents
            seen.add(r);
            seen.add(c);
        }

        //finding the root node 
        int components=0;
        for(int i:seen)
        {
            if(find(i)==i)
            {
                //whenever its a root node increase the component by 1
                components++;
            }
        }

        int ans=n-components;
        return ans;
    }
}