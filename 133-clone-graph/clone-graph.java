/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
        {
            return null;
        }

        Map<Node,Node>map=new HashMap<>();
        Node clone=new Node(node.val);
        map.put(node,clone);

        Queue<Node>q=new LinkedList<>();
        q.add(node);

        while(!q.isEmpty())
        {
            Node curr=q.poll();
            for(Node neigh:curr.neighbors)
            {
                if(!map.containsKey(neigh))
                {
                    Node newNode=new Node(neigh.val);
                    map.put(neigh,newNode);
                    q.add(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }

        return clone;
    }
}

/*
map banao
key:- og node
value:- clone node
bfs q banao and add elemnt into the queue
node ko poll kroo aur uuss elemnt k neighbour nikall k map aur queu mai 
daalo
agr already present hai toh edges add kro 
aur fir clone ko return kroo.
*/