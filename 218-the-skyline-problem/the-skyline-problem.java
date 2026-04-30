class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]>list=new ArrayList<>();
        for(int []b:buildings)
        {
            int x=b[0];
            int y=b[1];
            int h=b[2];
            list.add(new int[]{x,-h});
            list.add(new int[]{y,h});
        }
        Collections.sort(list,(a,b)->{
            if(a[0]!=b[0])  return a[0]-b[0];
            return a[1]-b[1]; 
        });
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int prevMax=0;
        pq.add(0);
        List<List<Integer>>ans=new ArrayList<>();
        for(int []e:list)
        {
            int x=e[0];
            int h=e[1];
            if(h<0)
            {
                pq.add(-h);
            }
            else
            {
                pq.remove(h);
            }
            int currMax=pq.peek();
            if(currMax!=prevMax)
            {
                ans.add(Arrays.asList(x,currMax));
                prevMax=currMax;
            }
        }
        return ans;
    }
}