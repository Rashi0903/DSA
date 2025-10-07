class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int mid = (n + 1) / 2; // middle split
        int j = mid - 1;       // pointer for smaller half
        int k = n - 1;         // pointer for larger half

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[j--]; // smaller elements
            } else {
                nums[i] = sorted[k--]; // larger elements
            }
        }
    }
}