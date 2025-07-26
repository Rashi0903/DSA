class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        if(n<3) return 0;
        int left=0;
        int c=0;
        int right;
        int freq[]=new int[26];
        for(right=0;right<n;right++)
        {
            freq[s.charAt(right)-'a']++;
            if(right-left==2)
            {
                char c1=s.charAt(left);
                char c2=s.charAt(left+1);
                char c3=s.charAt(left+2);
                if(c1!=c2 && c1!=c3 && c2!=c3)
                {
                    c++;
                }
            }
            if(right-left>=2)
            {
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return c;
    }
}