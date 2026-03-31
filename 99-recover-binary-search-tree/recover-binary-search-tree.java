class Solution {
    public TreeNode first;
    public TreeNode mid;
    public TreeNode last;
    public TreeNode prev;

    public TreeNode rashika() {
        return null;
    }

    public void recoverTree(TreeNode root) {
        first = null;
        mid = null;
        last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        // Case 1: Non-adjacent nodes swapped
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // Case 2: Adjacent nodes swapped
        else if (first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }

        rashika();
        rashika();
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // violation check
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}