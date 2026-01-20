class Solution {

    public void solveSudoku(char[][] board) 
    {
        solve(board);
    }

    public boolean solve(char[][] board) 
    {
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
                //find the blank space
                if (board[i][j] == '.') {
                    //find the possible number for that blank from 1-9
                    for (char ch = '1'; ch <= '9'; ch++) 
                    {
                        if (isValid(board, i, j, ch)) 
                        {
                            //if it is possible to put that element
                            board[i][j] = ch;
                            //find other combination after putting it in the blank
                            if (solve(board)) 
                            {
                                return true;   
                            }
                            //if not possible with that 
                            board[i][j] = '.'; // backtrack
                        }
                    }

                    return false; 
                }
            }
        }

        return true; //board complete
    }

    public boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {

            if (board[r][i] == ch) return false; // row
            if (board[i][c] == ch) return false; // column

            int boxRow = 3 * (r / 3) + i / 3;
            int boxCol = 3 * (c / 3) + i % 3;

            if (board[boxRow][boxCol] == ch) return false; // box
        }
        return true;
    }
}
