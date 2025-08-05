
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int len=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        while(j<len)
        {
            sum+=arr[j];
            while(sum>target && i<j)
            {
                sum-=arr[i];
                i++;
            }
            if(sum==target)
            {
                ans.add(i+1);
                ans.add(j+1);
                return ans;
            }
            j++;
        }
        ans.add(-1);
        return ans;
        
    }
}
/*

non-negative integers
continuous subarray
sum==target
1-based indexing for the subarray
-------------------------------------------------------------------
Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.

i=0 index j=i+1
1+2=3  sum<target j++

3+3=6<target j++

6+7=13>target
    i++
    sum-arr[i-1]
    13-1=12==target <i+1,j+1>
    
    
<1+1,3+1>
<2,4> ans

-----sliding window--------
---------------------------------------------------------------------
*/