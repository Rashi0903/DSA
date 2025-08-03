class Solution {
    public int knightDialer(int n) {
        int mod=1000000007;

        int [][]moves={{4,6},
                        {6,8},
                        {9,7},
                        {4,8},
                        {0,3,9},
                        {},
                        {0,1,7},
                        {2,6},
                        {1,3},
                        {2,4}
                            };

        long prev[]=new long[10];

        //base case for n=1
        Arrays.fill(prev,1); 

        //for n>=2
        for(int i=1;i<n;i++)
        {
            long []next=new long[10];
            for(int digit=0;digit<=9;digit++)
            {
                for(int neigh:moves[digit])
                {
                    next[digit]=(next[digit]+prev[neigh])%mod;
                }
            }
            prev=next;
        }   

        long sum=0;
        for(long i:prev)
        {
            sum=(sum+i)%mod;
        }
        return (int)sum;
    }
}