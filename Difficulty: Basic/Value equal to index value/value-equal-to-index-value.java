// User function Template for Java
/*
    arr[i]==i
    
arr[] = [15, 2, 45, 4 , 7]
        1   2   3   4   5
        
1 based index
for(1-len)
*/
class Solution {
    public List<Integer> valueEqualToIndex(List<Integer> nums) {
        // code here
        List<Integer>ans=new ArrayList<>();
        int len=nums.size();
        for(int i=0;i<len;i++)
        {
            int ind=i+1;
            if(nums.get(i)==ind)
            {
                ans.add(ind);
              }
        }
        return ans;
        
    }
}