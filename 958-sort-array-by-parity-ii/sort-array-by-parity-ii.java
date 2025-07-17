class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<nums.length && j>=0)
        {
            if(i%2==0 && nums[i]%2==0)
            {
                i+=2;
                continue;
            }
            if(j%2!=0 && nums[j]%2!=0)
            {
                j-=2;
                continue;
            }
            if(i<nums.length && nums[i]%2!=0 && j>=0 && nums[j]%2==0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j-=2;
                i+=2;
            }
            else
            {
                if(nums[i]%2==0)    i+=2;
                if(nums[j]%2!=0)    j-=2;
            }
        }
        return nums;
    }
}