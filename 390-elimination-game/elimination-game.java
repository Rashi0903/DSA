class Solution {
    public int lastRemaining(int n) {
        int head=1;
        int gap=1;
        int len=n;
        boolean lr=true;
        if(len==1)
        {
            return n;
        }
        while(len!=1)
        {
            if(lr || len%2==1)
            {
                head+=gap;
            }
            gap*=2;
            len/=2;
            lr=!lr;
        }
        return head;
    }
}