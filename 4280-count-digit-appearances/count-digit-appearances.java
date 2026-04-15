class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0;
        char d=(char)(digit+'0');
        for(int n:nums)
        {
            String str=String.valueOf(n);
            for(char ch:str.toCharArray())
            {
                if(ch==d)
                {
                    count++;
                }
            }
        }
        return count;
    }
}