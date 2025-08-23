/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Solution {
    Node intersectPoint(Node head1, Node head2) {
        // code here
        if(head1==null && head2==null)
        {
            return null;
        }
        
        int len1=findLen(head1);
        int len2=findLen(head2);
        
        int diff=Math.abs(len1-len2);
        
        Node l1=head1;
        Node l2=head2;
        
        if(len1>len2)
        {
            for(int i=0;i<diff;i++)
            {
                l1=l1.next;
            }
        }
        
        if(len2>len1)
        {
            for(int i=0;i<diff;i++)
            {
                l2=l2.next;
            }
        }
        
        while(l1!=null && l2!=null)
        {
            if(l1==l2)
            {
                return l1;
            }
            l1=l1.next;
            l2=l2.next;
            
        }
        return null;
    }
    
    static int findLen(Node head)
    {
        int len=0;
        while(head!=null)
        {
            len++;
            head=head.next;
        }
        return len;
    }
}
