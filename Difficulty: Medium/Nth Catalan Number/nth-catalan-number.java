
class Solution {
    public static int findCatalan(int n) {
        // code here
        long []c=new long[n+1];
        c[0]=1;
        c[1]=1;
        for(int i=2;i<=n;i++)
        {
            c[i]=0;
            for(int j=0;j<i;j++)
            {
                c[i]+=c[j]*c[i-j-1];
            }
        }
        return (int)c[n];
    }
}
