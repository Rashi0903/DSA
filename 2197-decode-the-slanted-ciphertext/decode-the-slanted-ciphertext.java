class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int col=encodedText.length()/rows;
        char mat[][]=new char[rows][col];
        int idx=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                mat[i][j]=encodedText.charAt(idx);
                idx++;
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int j=0;j<col;j++)
        {
            int k=j;
            int i=0;
            while(i<rows && k<col)
            {
                ans.append(mat[i][k]);
                i++;
                k++;
            }
        }
        String str=ans.toString();
        int end = str.length() - 1;
        while (end >= 0 && str.charAt(end) == ' ') 
        {
            end--;
        }
        return str.substring(0, end + 1);
    }
}