class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer>ans=new ArrayList<>();
        int limit = 1 << n;
        for(int i=0;i<limit;i++)
        {
            int gray=i^(i>>1);
            ans.add(gray);
        }
        return ans;
    }
}