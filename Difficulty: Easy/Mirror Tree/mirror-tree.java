/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    void mirror(Node node) {
        // code here
        if(node==null)
        {
            return;
        }
        
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
        
        mirror(node.left);
        mirror(node.right);
        
        
    }
}
/*
in place krna hai toh left and right ko swap krdo bss 
*/