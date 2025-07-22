//union-find

class Solution {
    int parent[];
    int rank[];
    public void union(int a,int b)
    {
        int px=find(a);
        int py=find(b);
        if(px==py)
        {
            return ;
        }
        if(rank[px]<rank[py])
        {
            parent[px]=py;
        }
        else if(rank[py]<rank[px])
        {
            parent[py]=px;
        }
        else
        {
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
    public boolean equationsPossible(String[] equation) 
    {
        parent=new int[26];
        rank=new int[26];
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }

        //union kro agr charAt(1) is '='
        for(String eq:equation)
        {
            if(eq.charAt(1)=='=')
            {
                /*
                    a = = b
                    0 1 2 3
                */
                int a=eq.charAt(0)-'a'; //ascii mai change krdia
                int b=eq.charAt(3)-'a';
                union(a,b);
            }
        }

        //agr charAt(1) mai ! hai toh check kro ki valid hai ya nahi
        for(String eq:equation)
        {
            if(eq.charAt(1)=='!')
            {
                int a=eq.charAt(0)-'a';
                int b=eq.charAt(3)-'a';
                if(find(a)==find(b))    
                {
                    //agr dono a and b k beech mai != hai aur dono k parents same hai toh wo expresssion is not valid
                    return false;
                }
            }
        }
        return true;
    }
}