class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        //1. hashmap <String Integer>
        Map<String,Integer>map=new HashMap<>();
        for(String w:words)
        {
            map.put(w,map.getOrDefault(w,0)+1);
        }

        //2. Priority Queue

        //Declaring the priority on the defined conditions
        PriorityQueue<String>q=new PriorityQueue<>((a,b)->
        {
            if(map.get(a).equals(map.get(b))) //both having same freq
            {
                return b.compareTo(a);  //arrange them lexico
            }
            else
            {
                return map.get(a)-map.get(b); //on having the highest freq
            }
        });

        //put the elements into the q from the HashMap
        for(String w:map.keySet())
        {
            q.offer(w);
            if(q.size()>k)
            {
                q.poll();
            }
        }

        //making the ans list
        List<String>ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            ans.add(q.poll());
            
        }
        Collections.reverse(ans);   //ans list in lexico order

        return ans;
    }
}