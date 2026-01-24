/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int c=0;
    public int ans=-1;
    public int kthSmallest(Node root, int k) {
        // code here
        inorder(root,k);
        return ans;
        
    }
    public void inorder(Node node,int k)
    {
        if(node==null)
        {
            return;
            
        }
        inorder(node.left,k);
        
        c++;
        if(c==k)
        {
            ans=node.data;
            return;
        }
        
        inorder(node.right,k);
    }
}