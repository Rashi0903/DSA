/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevGroup=dummy;
        ListNode curr=head;
        int groupSize=1;
        while(curr!=null)
        {
            ListNode groupStart=curr;
            int count=0;
            while(curr!=null && count<groupSize)
            {
                curr=curr.next;
                count++;
            }
            ListNode nextGroup=curr;
            if(count%2==0)
            {
                ListNode prev=nextGroup;
                ListNode node=groupStart;

                for(int i=0;i<count;i++)
                {
                    ListNode temp=node.next;
                    node.next=prev;
                    prev=node;
                    node=temp;
                }
                prevGroup.next=prev;
                prevGroup=groupStart;
            }
            else
            {
                prevGroup=groupStart;
                for(int i=1;i<count;i++)
                {
                    prevGroup=prevGroup.next;
                }
            }
            groupSize++;
        }
        return dummy.next;
    }
}