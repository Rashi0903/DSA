class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1000000007;

        // min-heap for sell orders (price ascending)
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)->a[0]-b[0]);

        // max-heap for buy orders (price descending)
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for (int[] order : orders) {
            int price = order[0];
            int numpro = order[1];
            int type = order[2];

            if (type == 0) {
                // BUY order → try to match with sell heap
                while (numpro > 0 && !min.isEmpty() && min.peek()[0] <= price) {
                    int[] top = min.poll();
                    int matched = Math.min(top[1], numpro);
                    numpro -= matched;
                    top[1] -= matched;
                    if (top[1] > 0) min.offer(top);
                }
                if (numpro > 0) max.offer(new int[]{price, numpro});
            } else {
                // SELL order → try to match with buy heap
                while (numpro > 0 && !max.isEmpty() && max.peek()[0] >= price) {
                    int[] top = max.poll();  // take from buy heap
                    int matched = Math.min(top[1], numpro);
                    numpro -= matched;
                    top[1] -= matched;
                    if (top[1] > 0) max.offer(top); //  put back in buy heap
                }
                if (numpro > 0) min.offer(new int[]{price, numpro});
            }
        }

        long total = 0;
        for (int[] i : min) total = (total + i[1]) % mod;
        for (int[] i : max) total = (total + i[1]) % mod;

        return (int) total;
    }
}
