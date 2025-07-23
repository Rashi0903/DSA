class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int score=0;
        if(a>0)
        {
            pq.add(a);
        }
        if(b>0)
        {
            pq.add(b);
        }
        if(c>0)
        {
            pq.add(c);
        }
        while(pq.size()>=2)
        {
            int x=pq.poll();
            int y=pq.poll();
            x--;
            y--;
            score++;
            if(x>0) pq.add(x);
            if(y>0) pq.add(y);
        }
        return score;
    }
}