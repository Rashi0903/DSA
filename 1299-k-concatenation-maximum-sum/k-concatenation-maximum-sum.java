class Solution {
    static int mod = 1000000007;

    public int kConcatenationMaxSum(int[] arr, int k) {

        long totalSum = 0;
        for (int x : arr) totalSum += x;

        int n = arr.length;
        int repeat = Math.min(k, 2);
        int[] temp = new int[n * repeat];

        int idx = 0;
        for (int i = 0; i < repeat; i++) {
            for (int j = 0; j < n; j++) {
                temp[idx++] = arr[j];
            }
        }

        long sum = kadane(temp) % mod;

        if (totalSum > 0 && k > 2) {
            sum = (sum + ((k - 2L) % mod) * (totalSum % mod)) % mod;
        }

        return (int) sum;
    }

    public long kadane(int[] arr) {
        long curr = 0, max = 0;
        for (int x : arr) {
            curr = Math.max(0, curr + x);
            max = Math.max(max, curr);
        }
        return max;
    }
}
