class Solution {
    public Map<String, PriorityQueue<String>>build(
        List<List<String>>tickets
    )
    {
        Map<String, PriorityQueue<String>>graph=new HashMap<>();
        for(List<String> tic:tickets)
        {
            String from=tic.get(0);
            String to=tic.get(1);
            graph.putIfAbsent(from,new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        return graph;
    }

    public void dfs(
         Map<String, PriorityQueue<String>>graph,
         List<List<String>>tickets,
         LinkedList<String>iten,
         String curr
    )
    {   
         PriorityQueue<String> pq = graph.get(curr);

        while( pq!=null && !pq.isEmpty())
        {
            String next=pq.poll();
            dfs(graph,tickets,iten,next);
        }
        iten.addFirst(curr);
    }

    public List<String> findItinerary(List<List<String>> tickets) 
    {
        Map<String, PriorityQueue<String>>graph=build(tickets);
        LinkedList<String>iten=new LinkedList<>();
        dfs(graph,tickets,iten,"JFK");
        return iten;
    }
}