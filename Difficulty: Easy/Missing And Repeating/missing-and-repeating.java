import java.util.*;

class Solution {
    // Function to find the repeating and missing numbers
    ArrayList<Integer> findTwoElement(int arr[]) {
        Arrays.sort(arr); // Step 1: Sort the array
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;

        int repeating = -1;
        int missing = -1;

        // Step 2: Find repeating
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                repeating = arr[i];
                break; // only one repeating
            }
        }

        // Step 3: Find missing
        // Use a boolean array to track numbers 1 to n
        boolean[] seen = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            seen[arr[i]] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }

        // Step 4: Add to answer
        ans.add(repeating);
        ans.add(missing);

        return ans;
    }
}
