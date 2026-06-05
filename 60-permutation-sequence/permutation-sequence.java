class Solution {
    int count=0;
    String answer="";
    public String getPermutation(int n, int k) {
        boolean vis[]=new boolean[n+1];
        StringBuilder temp=new StringBuilder();
        recursion(temp,n,vis,k);
        return answer;
    }
    public void recursion(StringBuilder temp,int n,boolean[]vis,int k)
    {
        if(!answer.equals(""))
        {
            return;
        }
        if(temp.length()==n)
        {
            count++;
            if(count==k)
            {
                answer=temp.toString();
            }
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(!vis[i])
            {
                vis[i]=true;
                temp.append(i);
                recursion(temp,n,vis,k);
                temp.deleteCharAt(temp.length()-1);
                vis[i]=false;
            }
        }
    }
}