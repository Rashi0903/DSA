class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][]dp=new int[m+1][n+1];
        for(String s:strs)
        {
            int []c=nofZeroOne(s);
            int zero=c[0];
            int one=c[1];

            for(int i=m;i>=zero;i--)
            {
                for(int j=n;j>=one;j--)
                {
                    int include=dp[i-zero][j-one]+1;
                    int exclude=dp[i][j];
                    dp[i][j]=Math.max(include,exclude);
                }
            }
        }
        return dp[m][n];
    }

    public int[]nofZeroOne(String s)
    {
        int z=0;
        int o=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='0')
            {
                z++;
            }
            else
            {
                o++;
            }
        }
        return new int[]{z,o};
    }
}