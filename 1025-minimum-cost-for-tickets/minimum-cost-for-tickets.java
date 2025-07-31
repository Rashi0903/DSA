class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];  // No travel today
            } else {
                int c1 = dp[Math.max(0, i - 1)] + costs[0];
                int c2 = dp[Math.max(0, i - 7)] + costs[1];
                int c3 = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(c1, Math.min(c2, c3));
            }
        }

        return dp[lastDay];
    }
}
