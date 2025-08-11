/* A binary tree node class
class Node
{
    int data;
    Node left,right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    public boolean isBalanced(Node root) {
        // code here
        if(dfs(root)!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int dfs(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        
        //left height
        int left=dfs(root.left);
        if(left==-1)
        {
            return -1;
        }
        
        //right side
        int right=dfs(root.right);
        if(right==-1)
        {
            return -1;        
            
        }
        
        //sum > 1
        if(Math.abs(left-right)>1)
        {
            return -1;
        }
        
        return Math.max(left,right)+1;  
        //curr height between two nodes jo ki usk upr walai node ki height calculate krnai k kaam ayai gi
    }
}
/*
 DFS use krrai gai esmai
 pahalai left ki height nikalo fir right ki aur fir height ka diff kro 
 agr diff >1 aya toh unbalanced hai 
*/