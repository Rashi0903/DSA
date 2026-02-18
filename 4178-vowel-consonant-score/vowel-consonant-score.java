class Solution {
    public int vowelConsonantScore(String s) {
        int v=0;
        int c=0;
        int len=s.length();
        for(int i=0;i<len;i++)
        {
            char b=s.charAt(i);
            if(Character.isLetter(b))
            {
                if(b=='a' || b=='e' || b=='i' || b=='o' || b=='u')
            {
                v++;
            }
            else
            {
                c++;
            }
            }
        }
        if (c==0)
        {
            return 0;
        }

        return v/c;
    }
}