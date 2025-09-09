class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Check if all elements are already equal
        boolean allEqual = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[0]) {
                allEqual = false;
                break;
            }
        }

        if (allEqual) {
            return 0; // already equal
        }

        // Otherwise, 1 operation is always enough (choose full array)
        return 1;
    }
}
