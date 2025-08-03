// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:arr)
        {
            pq.add(num);
            while(pq.size()>k)
            {
                pq.poll();
            }
        }
        int ans=pq.peek();
        return ans;
    }
}
