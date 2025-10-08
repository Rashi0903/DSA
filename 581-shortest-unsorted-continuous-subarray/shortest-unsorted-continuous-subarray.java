class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int start = -1, end = -1;

        // Step 1: find first dip from left
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }

        // already sorted
        if (start == -1) return 0;

        // Step 2: find first dip from right
        for (int j = n - 1; j > 0; j--) {
            if (nums[j] < nums[j - 1]) {
                end = j;
                break;
            }
        }

        // Step 3: find min and max in the unsorted region
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }

        // Step 4: expand start leftwards if needed
        for (int i = 0; i < start; i++) {
            if (nums[i] > minVal) {
                start = i;
                break;
            }
        }

        // Step 5: expand end rightwards if needed
        for (int i = n - 1; i > end; i--) {
            if (nums[i] < maxVal) {
                end = i;
                break;
            }
        }

        return end - start + 1;
    }
}
