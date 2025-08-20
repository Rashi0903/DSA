// User function template for JAVA

class Solution {
    // Function to find all combinations of elements
    // in array arr that sum to target.
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        // add your code here
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        backtrack(0,arr,target,new ArrayList<>(),ans);
        return ans;
    }
    public static void backtrack(int idx,int []arr,int target,ArrayList<Integer>curr,ArrayList<ArrayList<Integer>>ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        if(idx==arr.length)
        {
            return;
        }
        
        if(arr[idx]<=target)
        {
            curr.add(arr[idx]);
            backtrack(idx,arr,target-arr[idx],curr,ans);
            
            curr.remove(curr.size()-1);
        }
        
        backtrack(idx+1,arr,target,curr,ans);
        
    }
    
}