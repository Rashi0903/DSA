/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int maxD=0;
    int diameter(Node root) {
        // Your code here
        height(root);
        return maxD;
    }
    
    int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        maxD=Math.max(maxD,lh+rh);
        
        return 1+Math.max(lh,rh);
    }
}
/*
left ki height=l
right ki height=r
root=l+r
max diameter up till that root
Approach:- DFS
*/