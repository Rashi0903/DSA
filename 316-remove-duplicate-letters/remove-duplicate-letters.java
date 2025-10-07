class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[]=new int[26];
        boolean found[]=new boolean[26];
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
        }

        for(char ch:s.toCharArray())
        {
            freq[ch-'a']--;

            if(found[ch-'a'])
            {
                continue;
            }

            while(!st.isEmpty() && st.peek()>ch && freq[st.peek()-'a']>0)
            {
                char r=st.pop();
                found[r-'a']=false;
            }

            st.push(ch);
            found[ch-'a']=true;
        }

        StringBuilder sb=new StringBuilder();
        for(char ch:st)
        {
            sb.append(ch);
        }

        return sb.toString();
    }
}