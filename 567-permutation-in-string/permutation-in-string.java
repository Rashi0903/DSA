

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = s1.length();

        while (right < s2.length()) {
            char c = s2.charAt(right);

            if (freq.containsKey(c)) {
                if (freq.get(c) > 0) {
                    count--;
                }
                freq.put(c, freq.get(c) - 1);
            }

            right++;

            // ✅ yahi check hona chahiye
            if (count == 0) {
                return true;
            }

            // ✅ window slide
            if (right - left == s1.length()) {
                char leftChar = s2.charAt(left);

                if (freq.containsKey(leftChar)) {
                    if (freq.get(leftChar) >= 0) {
                        count++;
                    }
                    freq.put(leftChar, freq.get(leftChar) + 1);
                }

                left++;
            }
        }

        return false;
    }
}