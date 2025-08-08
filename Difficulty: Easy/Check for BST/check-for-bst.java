/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        return BST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean BST(Node root,int min,int max)
    {
        Node node=root;
        if(node==null)
        {
            return true;
        }
        if(node.data<=min || node.data>=max)
        {
            return false;
        }
        return BST(node.left,min,node.data) && BST(node.right,node.data,max);
        
    }
}
/*
[2 1 3  n n n 5]
2 root child 1 3 
3 root child 5

jo proper binary search tree hota hai usmai left wala chota aur right wala bada 
as compared to root
toh root k left aur right ko check krna hai.
*/