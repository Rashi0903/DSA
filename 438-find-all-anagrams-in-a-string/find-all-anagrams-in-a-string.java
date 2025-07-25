class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        int []freqs=new int [26];
        int []freqp=new int [26];

        //update the freq array for p
        for(int i=0;i<p.length();i++)
        {
            char b=p.charAt(i);
            freqp[b-'a']++;
        }

        int l=0;
        int r=0;
        while(r<s.length())
        {
            //extracting the charater at the r-index
            char b=s.charAt(r);
            //updating in the freq array of s
            freqs[b-'a']++;

            //window size=size of string p
            if(r-l+1==p.length())
            {
                //if the values in both the freq array are same 
                if(Arrays.equals(freqs,freqp))
                {
                    ans.add(l); // add the l-index to the ans list
                }
                //reduce the window size from left
                char le=s.charAt(l);
                freqs[le-'a']--;    //remove the value from freq array of s
                l++;    //update the left by one
            }

            //increase the r pointer
            r++;
        }
        return ans;
    }
}