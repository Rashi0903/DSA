class Solution {
    public int knightDialer(int n) {
        int mod=1000000007;

        int [][]moves={{4,6},       //0 pai kaha kaha sai reach kr sktai ahi
                        {6,8},      //1
                        {9,7},      //2
                        {4,8},      //3
                        {0,3,9},    //4 
                        {},         //5
                        {0,1,7},    //6
                        {2,6},      //7
                        {1,3},      //8
                        {2,4}       //9
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
                    //moves k 2d array  mai jaak usk neighbours nikalai ga aur fir unko add krrai ga 
                    /*
                    neigh=moves[0] => {4,6}
                    digit=0
                    next[0]=next[0]+prev[4];    =>next[0]=1
                    next[0]=next[0]+prev[6];    =>1+1=2
                    */
                    next[digit]=(next[digit]+prev[neigh])%mod;
                }
            }

            //next iteration k liyai next ko update krna hai taaki values loose na ho esliyai prev mai next ka poora array daal diya
            prev=next;
        }   

        long sum=0;

        //next ka poora array hum already prev mai daal chuk hai esliyai prev[] mai iterate kiya
        for(long i:prev)
        {
            sum=(sum+i)%mod;
        }
        return (int)sum;
    }
}
//mod qki ans int mai chaheyai  input values long mai ho skti hai 