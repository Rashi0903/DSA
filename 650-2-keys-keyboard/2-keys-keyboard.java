class Solution {
    public int minSteps(int n) {
        if(n==2)
        {
            return 2;
        }
        int d=2;
        int res=0;
        while(n>2)
        {
            while(n%d==0)
            {
                res+=d;
                n/=d;
            }
            d++;
        }
        return res;
    }
}