class Solution {
    class Pair
    {
        String node;
        double value;
        Pair(String node,double value)
        {
            this.node=node;
            this.value=value;
        }
    }
    public Map<String,List<Pair>>buildGraph(List<List<String>> equations, double[] values)
    {
        Map<String,List<Pair>>graph=new HashMap<>();
        for(int i=0;i<equations.size();i++)
        {
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            double val=values[i];

            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());

            graph.get(u).add(new Pair(v,val));
            graph.get(v).add(new Pair(u,1.0/val));

        }
        return graph;
    }
    public double dfs(String src,String des,Map<String,List<Pair>>graph,Set<String>visited)
    {
        if(src.equals(des))
        {
            return 1.0;
        }
        visited.add(src);
        for(Pair neigh:graph.get(src))
        {
            if(visited.contains(neigh.node))
            {
                continue;
            }
            double ans=dfs(neigh.node,des,graph,visited);
            if(ans!=-1.0)
            {
                return (neigh.value*ans);
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair>>graph=new HashMap<>();
        graph=buildGraph(equations,values);
        double []result=new double[queries.size()];
        for(int i=0;i<queries.size();i++)
        {
            String src=queries.get(i).get(0);
            String des=queries.get(i).get(1);
            if(!graph.containsKey(src) || !graph.containsKey(des))
            {
                result[i]=-1.0;
                continue;
            }
            Set<String>vis=new HashSet<>();
            result[i]=dfs(src,des,graph,vis);
        }
        return result;
        
    }
}