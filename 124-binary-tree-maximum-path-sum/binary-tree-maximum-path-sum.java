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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
    }

    public int findSum(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }

        //handel the negative cases
        int left=Math.max(0,findSum(node.left));
        int right=Math.max(0,findSum(node.right));

        //current sum
        int currSum=node.val+left+right;

        maxSum=Math.max(maxSum,currSum);

        return node.val+Math.max(left,right);
    }
}