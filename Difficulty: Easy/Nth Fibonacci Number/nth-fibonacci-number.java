// User function Template for Java

class Solution {
    public int nthFibonacci(int n) {
        // code here
        return fibo(0,0,1,n);
    }
    public int fibo(int c,int prev,int curr,int n)
    {
        if(c==n)
        {
            return prev;
        }
        return fibo(c+1,curr,curr+prev,n);
    }
}
/*
n=5
0   1   1   2   3   5
o/p 5


*/