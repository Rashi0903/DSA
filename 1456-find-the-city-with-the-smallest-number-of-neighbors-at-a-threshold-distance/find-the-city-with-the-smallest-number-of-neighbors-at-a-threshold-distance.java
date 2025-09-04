class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int resultCity = -1;
        int minReachable = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = dijkstra(i, graph, n, distanceThreshold);

            if (count <= minReachable) {
                minReachable = count;
                resultCity = i; // in case of tie, larger index automatically chosen
            }
        }

        
        return resultCity;
    }

    private int dijkstra(int src, List<List<int[]>> graph, int n, int threshold) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if (d > dist[node]) continue;

            for (int[] nei : graph.get(node)) {
                int next = nei[0], w = nei[1];
                if (d + w < dist[next]) {
                    dist[next] = d + w;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        // count reachable cities within threshold (excluding itself)
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) count++;
        }
        return count;  
    }
}