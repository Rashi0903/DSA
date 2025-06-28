class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = nums[0];
        int summax = nums[0], summin = nums[0];
        int maxSum = nums[0], minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            total += num;

            summax = Math.max(num, summax + num);
            maxSum = Math.max(maxSum, summax);

            summin = Math.min(num, summin + num);
            minSum = Math.min(minSum, summin);
        }
        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}
