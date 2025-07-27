class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int n = colors.length;
        if (n < k) return 0;

        // build big array
        int[] bigarr = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            bigarr[i] = colors[i % n];
        }

        int len = 1;
        int c = 0;
        for (int r = 1; r < n + k - 1; r++) {
            if (bigarr[r] != bigarr[r - 1]) {
                len++;
            } else {
                len = 1; // reset
            }

            if (len >= k) {
                c++;
                len--; // slide
            }
        }
        return c;
    }
}
