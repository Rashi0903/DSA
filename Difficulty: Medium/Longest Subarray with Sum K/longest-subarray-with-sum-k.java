// User function Template for Java
//hashmap+prefixSum

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        
        int prefixSum=0;
        int len=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            prefixSum+=arr[i];
            int a=prefixSum-k;
            
            if(a==0)
            {
                len=i+1;
            }
            
            if(map.containsKey(a))
            {
                int l=i-map.get(a);
                len=Math.max(len,l);
            }
            
            if(!map.containsKey(prefixSum))
            {
                map.put(prefixSum,i);
            }
        }
        return len;
    }
}
