import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        int n = costs.length;

        PriorityQueue<int[]> lpq = new PriorityQueue<>(
            (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]
        );

        PriorityQueue<int[]> rpq = new PriorityQueue<>(
            (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]
        );

        int left = 0;
        int right = n - 1;

        // FIX ✅ overlap avoid
        for(int i = 0; i < candidates && left <= right; i++){
            lpq.offer(new int[]{costs[left], left});
            left++;
        }

        for(int i = 0; i < candidates && left <= right; i++){
            rpq.offer(new int[]{costs[right], right});
            right--;
        }

        long total = 0;

        while(k > 0){

            if(rpq.isEmpty() || 
               (!lpq.isEmpty() && lpq.peek()[0] <= rpq.peek()[0])){

                int[] curr = lpq.poll();
                total += curr[0];

                if(left <= right){
                    lpq.offer(new int[]{costs[left], left});
                    left++;
                }

            }else{

                int[] curr = rpq.poll();
                total += curr[0];

                if(left <= right){
                    rpq.offer(new int[]{costs[right], right});
                    right--;
                }
            }

            k--;
        }

        return total;
    }
}