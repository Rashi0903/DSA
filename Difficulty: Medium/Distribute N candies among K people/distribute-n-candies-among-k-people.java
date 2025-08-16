// User function Template for Java

class Solution {
    static Long[] distributeCandies(int N, int K) {
        Long[] ans = new Long[K];   // result array
        for (int i = 0; i < K; i++) ans[i] = 0L; // initialize with 0
        
        long give = 1;  // next candies to give
        int i = 0;      // current person index

        while (N > 0) {
            if (N >= give) {
                ans[i] += give;  // give full
                N -= give;
            } else {
                ans[i] += N;     // give remaining
                N = 0;
            }
            give++;
            i = (i + 1) % K;  // cyclic move to next person
        }
        
        return ans;
    }
}

/*
round 1 mai person1 ko 1 person2 ko 2 and so on
round 2 mai person1 ko k+1 person2 ko k+2 and sooo onnn
brute force:-

class Solution {
    public int[] distributeCandies(int N, int K) {
        int[] ans = new int[K];
        int give = 1; // next candies to give
        int i = 0;    // current person index

        while (N > 0) {
            if (N >= give) {
                ans[i] += give;
                N -= give;
            } else {
                ans[i] += N;
                N = 0;
            }
            give++;
            i = (i + 1) % K; // next person cyclic
        }

        return ans;
    }
}

*/