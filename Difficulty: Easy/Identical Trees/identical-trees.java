/*
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/

class Solution {
    boolean isIdentical(Node root1, Node root2) {
        // code here
        //1.dono null hai true return kro
        if(root1==null && root2==null)
        {
            return true;
        }
        //2.any one became null
        if(root1==null || root2==null)
        {
            return false;
        }
        
        //3. check for the values of the root and then traverse left and right in both the tree simultaneously
        if(root1.data==root2.data && isIdentical(root1.left,root2.left)
        && isIdentical(root1.right,root2.right))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}