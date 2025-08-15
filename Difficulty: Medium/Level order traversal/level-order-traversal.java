class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.data);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(level); 
        }
        return ans;
    }
}
