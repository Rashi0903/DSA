/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;   // ✅ safety

        Node curr = head;

        // copy of the node 
        while(curr != null)
        {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;

        // random pointer fit
        while(curr != null)
        {
            if(curr.next != null)
            {
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            }
            curr = curr.next.next;
        }

        Node og = head;
        Node copy = head.next;
        Node copyHead = copy;

        while(og != null)
        {
            og.next = og.next.next;

            if(copy.next != null)            // ✅ safety
                copy.next = copy.next.next;

            og = og.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
