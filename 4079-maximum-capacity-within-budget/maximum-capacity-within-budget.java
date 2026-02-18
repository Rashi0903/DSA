import java.util.*;

class Solution {

    public int maxCapacity(int[] costs, int[] capacity, int budget) {

        int n = costs.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = costs[i];
            arr[i][1] = capacity[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] prefixMax = new int[n];
        prefixMax[0] = arr[0][1];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i][1]);
        }

        int maxCap = 0;

        // Single machine case
        for (int i = 0; i < n; i++) {
            if (arr[i][0] < budget) {
                maxCap = Math.max(maxCap, arr[i][1]);
            }
        }

        // Two machine case
        for (int i = 1; i < n; i++) {

            int remaining = budget - arr[i][0];

            int left = 0;
            int right = i - 1;
            int idx = -1;

            // Binary search
            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (arr[mid][0] < remaining) {
                    idx = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (idx != -1) {
                maxCap = Math.max(maxCap,
                        arr[i][1] + prefixMax[idx]);
            }
        }

        return maxCap;
    }
}
