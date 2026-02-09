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
    int postId;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postId=postorder.length-1;
        return build(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode build(int []inorder,int []postorder,int s,int e)
    {
        if(s>e) return null;
        int rootval=postorder[postId];
        postId--;
        TreeNode root=new TreeNode(rootval);
        int rootidx=s;
        for(int i=s;i<=e;i++)
        {
            if(inorder[i]==rootval)
            {
                rootidx=i;
                break;
            }
        }
        root.right=build(inorder,postorder,rootidx+1,e);
        root.left=build(inorder,postorder,s,rootidx-1);
        return root;
    }
}