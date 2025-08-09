/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static class Pair{
        Node n;
        int h;
        Pair(Node n,int h)
        {
            this.n=n;
            this.h=h;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        
        Queue<Pair>q=new LinkedList<>();
        Map<Integer,Integer>map=new TreeMap<>();
        
        q.add(new Pair(root,0));    //add root node 
        
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            
            if(!map.containsKey(curr.h))
            {
                map.put(curr.h,curr.n.data);    
                // map k  andr dist aur node ki value
            }
            
            if(curr.n.left!=null)
            {
                q.add(new Pair(curr.n.left,curr.h-1));
                //left side
            }
            
            if(curr.n.right!=null)
            {
                q.add(new Pair(curr.n.right,curr.h+1));
            }
        }
        ans.addAll(map.values());
        return ans;
        
    }
}
/*
top view of the tree
        1
       / \
      2   3
       \
        4
         \
          5
           \
            6
[2 1 3 6]

level order traversal
BFS
queue <int[]> (node.data,dist from root)
ans into map
o/p => sorted map on the basis of dist from root (tree node automatically sort)

root ka dist=0
left k liyai -1
right k liyai +1
if dist is present in the map then don't add it into the map.

*/