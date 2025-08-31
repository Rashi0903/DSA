class Solution {
    public boolean isValidSudoku(char[][] board) {
       //row check
       for(int i=0;i<9;i++)
       {
        if(!validRow(i,board))
        {
            return false;
        }

        //col check
        if(!validCol(i,board))
        {
            return false;
        }
       }
       
       //sub-box check
       for(int i=0;i<9;i+=3)
       {
        for(int j=0;j<9;j+=3)
        {
            if(!validBox(i,j,board))
            {
                return false;
            }
        }
       }
       return true;
    }

    public boolean validRow(int row, char[][]board)
    {
        HashSet<Character>seen=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            char b=board[row][i];
            if(b!='.')
            {
                if(seen.contains(b))
                {
                    return false;
                }
                else 
                {
                    seen.add(b);
                }
            }
        }

        return true;
    }

    public boolean validCol(int col,char [][]board)
    {
        HashSet<Character>seen=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            char b=board[i][col];
            if(b!='.')
            {
                if(seen.contains(b))
                {
                    return false;
                }
                else 
                {
                    seen.add(b);
                }
            }
        }

        return true;
    }

    public boolean validBox(int startRow,int startCol, char[][]board)
    {
        HashSet<Character>seen=new HashSet<>();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                char b=board[startRow+i][startCol+j];
                if(b!='.')
                {
                    if(seen.contains(b))
                    {
                        return false;
                    }
                    seen.add(b);
                }
            }
        }
        return true;
    }
}