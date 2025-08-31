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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        int level=1;
        int maxsum=Integer.MIN_VALUE;
        int maxLevel=1;
        q.add(root);
        while(!q.isEmpty())
        {
            int currSum=0;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                currSum+=node.val;
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            if(currSum>maxsum)
            {
                maxsum=currSum;
                maxLevel=level;
            }
            level++;
        }
        return maxLevel;
    }
}