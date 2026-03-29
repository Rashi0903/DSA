class Solution {
    public int[][] generateMatrix(int n) {
        int [][]mat = new int[n][n];

        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // top row (left → right)
            for (int i = left; i <= right; i++) {
                mat[top][i] = num++;
            }
            top++;

            // right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num++;
            }
            right--;

            // bottom row (right → left)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    mat[bottom][i] = num++;
                }
                bottom--;
            }

            // left column (bottom → top)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = num++;
                }
                left++;
            }
        }

        return mat;
    }
}