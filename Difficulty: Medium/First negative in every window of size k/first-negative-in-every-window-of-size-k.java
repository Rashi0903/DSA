class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int n=arr.length;
        ArrayList<Integer>ans=new ArrayList<>();
         Deque<Integer>dq=new LinkedList<>();
        int i=0;
        int j=0;
        while(j<n)
        {
            //element < 0 add to the dq from behind
            if(arr[j]<0)
            {
                dq.addLast(arr[j]);
            }
            
            //check the window the size
            if((j-i+1)==k)
            {
                //no negative found in the curr window
                if(dq.isEmpty())
                {
                    ans.add(0);
                }
                else
                {
                    ans.add(dq.peekFirst());
                }
                
                if(!dq.isEmpty() && dq.peekFirst()==arr[i])
                {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
            
            //window size not found 
            else if((j-i+1)<k)
            {
                j++;
            }
        }
        return  ans;
    }
}
/*
first negative find krna hai in every window of size k
dequeue+sliding window
deque mai add from last
aur agay walai element ko nikal lo and add to the ans list
*/