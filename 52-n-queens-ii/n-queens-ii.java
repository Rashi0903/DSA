class Solution {
    
    int count = 0;

    public int totalNQueens(int n) {
        
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                board[i][j] = '.';
            }
        }

        solve(board, n, 0);

        return count;
    }

    public void solve(char[][] board, int n, int row)
    {
        if(row == n)
        {
            count++;
            return;
        }

        for(int col = 0; col < n; col++)
        {
            if(isSafe(board, row, col, n))
            {
                board[row][col] = 'Q';

                solve(board, n, row + 1);

                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, int n)
    {
        // Column Check
        for(int i = 0; i < row; i++)
        {
            if(board[i][col] == 'Q')
            {
                return false;
            }
        }

        // Left Upper Diagonal
        int r = row - 1;
        int c = col - 1;

        while(r >= 0 && c >= 0)
        {
            if(board[r][c] == 'Q')
            {
                return false;
            }

            r--;
            c--;
        }

        // Right Upper Diagonal
        r = row - 1;
        c = col + 1;

        while(r >= 0 && c < n)
        {
            if(board[r][c] == 'Q')
            {
                return false;
            }

            r--;
            c++;
        }

        return true;
    }
}