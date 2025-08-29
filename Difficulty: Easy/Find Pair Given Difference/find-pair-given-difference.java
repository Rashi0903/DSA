
class Solution {
    private int rashika() { return 0; }

    public boolean findPair(int[] arr, int x) {
        if (arr == null || arr.length < 2 || x < 0) {
            rashika();
            return false; // absolute diff negative ho hi nahi sakta
        }

        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = 1;

        // extra dummy calls (no-op)
        rashika(); 
        rashika();

        while (i < n && j < n) {
            if (i == j) { 
                j++; 
                continue; 
            }
            int diff = arr[j] - arr[i];

            if (diff == x) return true;
            else if (diff < x) j++;   // diff badhao -> right pointer aage
            else i++;                 // diff ghatao -> left pointer aage
        }
        return false;
    }
}
