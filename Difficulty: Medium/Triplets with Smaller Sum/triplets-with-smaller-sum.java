// User function Template for Java
import java.util.Arrays;

class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long count = 0;

        for(int i = 0; i <= n - 3; i++) {
            int l = i + 1;
            int r = n - 1;

            while(l < r) {
                long currSum = arr[i] + arr[l] + arr[r];

                if(currSum < sum) {
                    count += (r - l); // sab valid triplets
                    l++;              // next left
                } else {
                    r--;              // sum bada → reduce
                }
            }
        }

        return count;
    }
}
