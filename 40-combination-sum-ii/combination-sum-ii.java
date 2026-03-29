class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(candidates);
        recursion(candidates,res,0,target,new ArrayList<>());
        return res;
    }
    public void recursion(int []candidates,List<List<Integer>>res,int idx,int target,List<Integer>temp)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=idx;i<candidates.length;i++)
        {
            if(i>idx && candidates[i]==candidates[i-1])
            {
                continue;
            }
            if(candidates[i]>target)
            {
                break;
            }
            temp.add(candidates[i]);
            recursion(candidates,res,i+1,target-candidates[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}