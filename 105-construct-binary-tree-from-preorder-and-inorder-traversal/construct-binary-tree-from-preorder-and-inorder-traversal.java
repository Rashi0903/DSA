/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preidx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1);
    }
    TreeNode build(int []preorder,int[]inorder,int s,int e)
    {
        if(s>e)
        {
            return null;
        }
        int rootVal=preorder[preidx++];
        
        TreeNode root=new TreeNode(rootVal);
        int rootidx=s;
        for(int i=s;i<=e;i++)
        {
            if(inorder[i]==rootVal)
            {
                rootidx=i;
                break;
            }
        }

        root.left=build(preorder,inorder,s,rootidx-1);
        root.right=build(preorder,inorder,rootidx+1,e);
        return root;
    }
}