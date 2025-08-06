class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
         Deque<Integer> dq = new ArrayDeque<>();
        Queue<Integer> ansQ = new LinkedList<>();
        
        //base cases
        if(q==null || k>q.size() || k<0)
        {
            return q;
        }
        // First k elements Deque mein last se daal do
        for (int i = 0; i < k; i++) {
            dq.addLast(q.poll());  // Normal order
        }

        // Remove from last to reverse and add to new queue
        while (!dq.isEmpty()) {
            ansQ.add(dq.removeLast());
        }

        //Jo elements bache hain unhe as it is daal do
        while (!q.isEmpty()) {
            ansQ.add(q.poll());
        }

        return ansQ;
    }
}

/*
Input: q = [1, 2, 3, 4, 5], k = 3
Output: [3, 2, 1, 4, 5]
Explanation: After reversing the first 3 elements from
the given queue the resultant queue will be 
3 2 1 4 5

dequeue 
dq=[1 2 3] enter into the queue from behind 

remove from behind  [3 2 1]

*/