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
}*/
class Solution {
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        Queue<Node>q=new LinkedList<>();
        
        q.add(root);    //first element
        
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node curr=q.poll();
                if(i==0)
                {
                    ans.add(curr.data);
                }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }
        return ans;
        
    }
}
/*

left view :- tree ko level by level traverse krnai mai jo bhi node pahalai
            visible hai

level traversal 
BFS approach use 
root k child q mai daalo 
loop use kro from 0 to q.size()
i=0 walai ko ans list mai add kro qki wo uus level ki pahali node hai
aur fir q mai aur jitnai bhi elements hai remaning queue k andr unk 
child daalo.
last mai ans list ko return krdo.

*/