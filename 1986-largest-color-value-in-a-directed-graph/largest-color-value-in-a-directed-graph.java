class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int []indegree=new int[n];
        for(int []e:edges)
        {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        int[][]dp=new int[n][26];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        int visit=0;
        int ans=0;
        while(!q.isEmpty())
        {
            int u=q.poll();
            visit++;
            int idx=colors.charAt(u)-'a';
            dp[u][idx]++;
            ans=Math.max(ans,dp[u][idx]);
            for(int v:adj.get(u))
            {
                for(int c=0;c<26;c++)
                {
                    dp[v][c]=Math.max(dp[v][c],dp[u][c]);
                }
                indegree[v]--;
                if(indegree[v]==0)
                {
                    q.offer(v);
                }
            }
        }
        if(visit<n)
        {
            return -1;
        }
        return ans;
    }
}