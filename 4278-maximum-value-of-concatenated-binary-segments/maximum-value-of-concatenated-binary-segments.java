class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < nums1[i]; j++) sb.append('1');
            for (int j = 0; j < nums0[i]; j++) sb.append('0');

            arr[i] = sb.toString();
        }

        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab); // descending
        });

        long res = 0;
        int MOD = 1_000_000_007;

        for (String s : arr) {
            for (char c : s.toCharArray()) {
                res = (res * 2 + (c - '0')) % MOD;
            }
        }

        return (int) res;
    }
}