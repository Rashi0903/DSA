class GfG {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // code here.
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