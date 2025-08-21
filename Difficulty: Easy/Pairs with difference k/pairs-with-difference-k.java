// User function Template for Java
class Solution {
    int countPairs(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer>map=new HashMap<>();
        
        //frequency
        for(int num:arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        int count=0;
        
        for(int num:map.keySet())
        {
            int sum=num+k;
            if(map.containsKey(sum))
            {
                int multi=map.get(num)*map.get(sum);
                count+=multi;
            }
        }
        return count;
    }
}