/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        
        //add  root data
        if(!isLeaf(root))
        {
            ans.add(root.data);
            
        }
        
        //left boundary
        leftBoundary(root,ans);
        //leaf
        leaf(root,ans);
        //right boundary
        rightBoundary(root,ans);
        return ans;
    }
    public boolean isLeaf(Node root)
    {
        if(root.left==null && root.right==null)
        {
            return true;
        }
        return false;
    }
    public void leftBoundary(Node root,List<Integer>ans)
    {
        Node curr=root.left;
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                ans.add(curr.data);
            }
            if(curr.left!=null)
            {
                curr=curr.left;
            }
            else
            {
                curr=curr.right;
            }
        }
    }
    public void leaf(Node root,List<Integer>ans)
    {
        if(root==null)
        {
            return;
        }
        if(isLeaf(root))
        {
            ans.add(root.data);
        }
        leaf(root.left,ans);
        leaf(root.right,ans);
    }
    public void rightBoundary(Node root,List<Integer>ans)
    {
        Node curr=root.right;
        Stack<Integer>st=new Stack<>();
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                st.push(curr.data);
            }
            if(curr.right!=null)
            {
                curr=curr.right;
            }
            else
            {
                curr=curr.left;
            }
        }
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
    }
}