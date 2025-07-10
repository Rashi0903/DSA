class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Queue<int[]>q=new LinkedList<>();

        //input of 0 into the queue
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        //convert the row and column
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            int row=curr[0];
            int col=curr[1];

            //change row
            for(int j=0;j<n;j++)
            {
                matrix[row][j]=0;
            }

            //change column
            for(int i=0;i<m;i++)
            {
                matrix[i][col]=0;
            }
        }
    }
}