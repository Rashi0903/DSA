class Solution {
    public int minOperations(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (i % 2 == 0) { 
                while (!isPrime(num)) {
                    num++;
                    count++;
                }
            } 
            else { 
                while (isPrime(num)) {
                    num++;
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
    
}