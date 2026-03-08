class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;

        long[] pre = new long[n];
        long[] post = new long[n];

        pre[0] = 0;
        post[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        int ans = n;

        if (pre[n - 1] == 1) ans = n - 1;

        for (int i = n - 2; i >= 0; i--) {

            post[i] = post[i + 1] * nums[i + 1];

            if (post[i] == pre[i]) ans = i;

            if (post[i] > pre[i]) {
                if (ans != n) return ans;
                else return -1;
            }
        }

        return -1;
    }
}