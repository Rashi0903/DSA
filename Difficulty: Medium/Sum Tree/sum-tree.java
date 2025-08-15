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
}
*/
class Solution {
    boolean isSumTree(Node root) {
        // Your code here
        if(root==null ||(root.left==null && root.right==null))
        {
            return true;
        }
        int left=sum(root.left);
        int right=sum(root.right);
        
        return(left+right==root.data)&&isSumTree(root.left) && isSumTree(root.right);
    }
     int sum(Node root)
     {
         if(root==null)
         {
             return 0;
         }
         return sum(root.left)+sum(root.right)+root.data;
     }
}