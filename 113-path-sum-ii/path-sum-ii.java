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
    public List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,0,targetSum,new ArrayList<>());
        return ans;
    }
    public void dfs(TreeNode node,int sum,int target,ArrayList<Integer>path)
    {
        if(node==null)  return;
        sum+=node.val;
        path.add(node.val);
        if(node.left==null && node.right==null)
        {
            if(sum==target)
            {
                ans.add(new ArrayList<>(path));
            }
        }
        dfs(node.left,sum,target,path);
        dfs(node.right,sum,target,path);
        path.remove(path.size()-1);
    }
}