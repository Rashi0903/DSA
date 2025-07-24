class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        int len=classes.length;

        //Priority queue based on the max gain
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            double gainA=gain(a[0],a[1]);
            double gainB=gain(b[0],b[1]);
            return Double.compare(gainB,gainA);
        });

        //put all the elements into the pq
        for(int []i:classes)
        {
            pq.add(new int[]{i[0],i[1]});
        }

        //where can we put extra students
        while(extraStudents>0)
        {
            int max[]=pq.poll(); //pop:-high priority element
            max[0]++;       //++ to the pass
            max[1]++;       //++ to the total
            pq.add(max);       //push the changed number
            extraStudents--;    //reduce the student count
        }

        //new total?
        double total=0;
        for(int c[]:pq)
        {
            double c3=(double)c[0]/c[1];    // pass/total=c3
            total+=c3;        //ans=ans+c3
        }

        //final avg
        return total/len;
    }

    /*
    Gain Formula:-
    gain=((pass+1)/(total+1)) - (pass/total))
    */

    public double gain(int pass, int total) {
    return ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
}


}