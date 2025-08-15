/*
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
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) 
        {
            return ans;
        }

        Deque<Node> q = new LinkedList<>();
        q.add(root);
        boolean level = true; // even level (right to left)

        while (!q.isEmpty()) 
        {
            int size = q.size();

            for (int i = 0; i < size; i++) 
            {
                if (level) 
                {
                    // Poll from right
                    Node curr = q.pollLast();
                    ans.add(curr.data);

                    // For next level: add children to left (right first, then left)
                    if (curr.right != null) q.addFirst(curr.right);
                    if (curr.left != null) q.addFirst(curr.left);

                } 
                else 
                {
                    // Poll from left
                    Node curr = q.pollFirst();
                    ans.add(curr.data);

                    // For next level: add children to right (left first, then right)
                    if (curr.left != null) q.addLast(curr.left);
                    if (curr.right != null) q.addLast(curr.right);
                }
            }
            level = !level; // flip direction
        }
        return ans;
    }
}

/*
            1                           level 0
         /     \
        2       3                       level 1(l-r)
      /  \     /  \
     4    5   6    7                    level 2(r-l)
    / \  /     \     \
   8  9 10     11    12                 level 3(l-r)


[1, 2, 3, 7, 6, 5, 4, 8, 9, 10, 11, 12]

[2,3]
[4,5,6,7] => 7 6 5 4
[8 9 10 11 12]


dequeue 
odd level
    left to right 
    add:- addlast()
    remove:- q.pollFirst()
even level
    right to left
    add:- addFirst()
    remove:- q.pollLast()











*/