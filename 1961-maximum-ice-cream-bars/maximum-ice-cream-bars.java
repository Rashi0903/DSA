class Solution {
    public int maxIceCream(int[] costs, int coins) {
        //min heap 
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        //all elements into pq
        for(int i:costs)
        {
            pq.offer(i);
        }

        //max number of ice cream
        int c=0;
        while(!pq.isEmpty())
        {
            int cheap=pq.poll();
            if(cheap<=coins)
            {
                coins-=cheap;
                c++;
            }
            else
            {
                break;
            }
        }
        return c;
    }
}