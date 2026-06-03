class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        boolean []check=new boolean[nums.length];
        ArrayList<Integer>temp=new ArrayList<>();
        permutation(nums,check,temp,ans);
        return ans;
    }
    public void permutation(int []nums,boolean []check,List<Integer>temp,List<List<Integer>>ans)
    {
        if(temp.size()==nums.length)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(check[i])
            {
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !check[i-1])
            {
                continue;
            }
            check[i]=true;
            temp.add(nums[i]);
            permutation(nums,check,temp,ans);
            temp.remove(temp.size()-1);
            check[i]=false;
        }

    }
}