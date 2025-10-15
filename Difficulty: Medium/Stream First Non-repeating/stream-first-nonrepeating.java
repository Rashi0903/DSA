class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int freq[]=new int[26];
        Queue<Character>q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
            q.add(ch);
            while(!q.isEmpty() && freq[q.peek()-'a']>1)
            {
                q.poll();
            }
            if(q.isEmpty())
            {
                ans.append('#');
            }
            else
            {
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
}