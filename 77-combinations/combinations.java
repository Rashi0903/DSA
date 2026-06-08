class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1,n,k,new ArrayList<>());
        return ans;
    }
    public void backtrack(int num,int n,int k,List<Integer>curr)
    {
        if(curr.size()==k)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=num;i<=n;i++)
        {
            curr.add(i);
            backtrack(i+1,n,k,curr);
            curr.remove(curr.size()-1);
        }
    }
}