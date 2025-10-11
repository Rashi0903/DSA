// User function Template for Java

class Solution {
    public int minOperation(int n) {
        // code here
        int steps=0;
        while(n>0)
        {
            if(n%2==0)
            {
                n/=2;
                steps++;
            }
            else
            {
                n-=1;
                steps++;
            }
        }
        return steps;
    }
}