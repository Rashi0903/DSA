class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }

        recursion(0,board,ans,n);
        return ans;
        
    }
    public void recursion(int row,char[][]board,List<List<String>>ans,int n)
    {
        if(row==n)
        {
            ans.add(build(board));
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(isSafe(row,board,col,n))
            {
                board[row][col]='Q';
                recursion(row+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(int row,char[][]board,int col,int n)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }

        int r=row-1;
        int c=col-1;
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r--;
            c--;
        }

        r=row-1;
        c=col+1;
        while(r>=0 && c<n)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    public List<String>build(char [][]board)
    {
        List<String>res=new ArrayList<>();
        int len=board.length;
        for(int i=0;i<len;i++)
        {
            res.add(new String(board[i]));
        }
        return res;
    }
}