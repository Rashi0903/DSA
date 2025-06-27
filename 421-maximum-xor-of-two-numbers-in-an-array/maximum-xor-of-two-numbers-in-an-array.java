class Solution {
    static class Trienode
    {
        Trienode[] child=new Trienode[2];
    }
    public int findMaximumXOR(int[] nums) {
        Trienode root=new Trienode();
        for(int num:nums)
        {
            insert(root,num);
        }
        int max=0;
        for(int num:nums)
        {
            max=Math.max(max,findmax(root,num));
        }
        return max;
    }
    public void insert(Trienode root,int num)
    {
        Trienode node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>>i)&1;
            if(node.child[bit]==null)
            {
                node.child[bit]=new Trienode();
            }
            node=node.child[bit];
        }
    }
    public int findmax(Trienode root,int num)
    {
        Trienode node=root;
        int max=0;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>>i)&1;
            int flip=bit^1;
            if(node.child[flip]!=null)
            {
                max |=(1<<i);
                node=node.child[flip];
            }
            else
            {
                node=node.child[bit];
            }
        }
        return max;
    }
}