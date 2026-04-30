class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
        {
            return "";
        }
        //t ka hashmap
        Map<Character,Integer>map=new HashMap<>();
        for(char i:t.toCharArray())
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //
        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int req=map.size();
        int form=0;
        int start=0;
        Map<Character,Integer>newMap=new HashMap<>();
        while(right<s.length())
        {
            char ch=s.charAt(right);
            newMap.put(ch,newMap.getOrDefault(ch,0)+1);
            if(map.containsKey(ch) && map.get(ch).equals(newMap.get(ch)))
            {
                form++;
            }

            while(left<=right && form==req)
            {
                int len=right-left+1;
                if(len<minLen)
                {
                    minLen=len;
                    start=left;
                }
                char l=s.charAt(left);
                newMap.put(l,newMap.get(l)-1);
                if(map.containsKey(l) && map.get(l)>newMap.get(l))
                {
                    form--;
                }
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE? "":s.substring(start,start+minLen);
    }
}