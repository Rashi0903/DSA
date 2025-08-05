class Solution {
    public String FirstNonRepeating(String s) {
        // code here
        Map<Character,Integer>freq=new HashMap<>();
        Queue<Character>q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        
        for(char ch:s.toCharArray())
        {
            //put into the map and increase the freq
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            
            //add to the queue
            q.add(ch);
            
            //remove all the repeating chars
            while(!q.isEmpty() && freq.get(q.peek())>1)
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
/*

lowercase alphabets
Input: s = "aabc"
Output: "a#bb"
Explanation: For every ith character we will consider the string from 
index 0 till index i first non repeating character is as follow- 
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#' 
"aab" - first non-repeating character is 'b'
"aabc" - there are two non repeating characters 'b' and 'c',  
first non-repeating character is 'b' because 'b' comes before 'c' in the stream.

HashMap + Queue
a       a:1         [a]     a  
aa      a:2         []      #
aab     a:2 b:1     [b]     b
aabc    a:2 b:1 c:1 [b c]   b

if freq==1 queue.add    ans mai add
if freq>1 ans mai # aur queue sai remove
aur ans mai woi add krna hoga jiska freq==1 hai aur wo top of the queue hai
*/
