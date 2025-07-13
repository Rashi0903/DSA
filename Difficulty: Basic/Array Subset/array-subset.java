
class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        
        //using hashmap
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i:a)
        {
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(int i:b)
        {
            if(!freq.containsKey(i) || freq.get(i)==0)
            {
                return false;
            }
            else
            {
                freq.put(i,freq.get(i)-1);
            }
        }
        return true;
    }
}
