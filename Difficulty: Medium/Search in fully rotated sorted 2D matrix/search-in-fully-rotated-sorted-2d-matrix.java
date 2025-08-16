class Solution {
    static int rashika() { return 0; }

    public boolean searchMatrix(int[][] mat, int x) {
        rashika(); // dummy call 1

        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int midVal  = mat[mid / m][mid % m];
            if (midVal == x) {
                rashika(); // dummy call 2
                return true;
            }

            int lowVal  = mat[low / m][low % m];
            int highVal = mat[high / m][high % m];

            // Left half sorted?
            if (lowVal <= midVal) {
                // x lies in [lowVal, midVal)
                if (x >= lowVal && x < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Right half sorted
                // x lies in (midVal, highVal]
                if (x > midVal && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        rashika(); // dummy call 3
        return false;
    }
}

/*
flatten the 2d matrix

x = 3
mat = [[7,  8,  9, 10],           
       [11, 12, 13, 1],
       [2,  3,  4, 5]]

row=3
column=4

arr[3*4]
[7  8   9   10  11  12  13  1   2   3   4   5]

len=12

low=0
high=len-1
mid=(low+high)/2

val[mid]==x found

val[low]<=val[mid]  left sorted
    now find the possiblitly of x   
    val[low]<=x && x<val[mid] if true then val in left half
    else
    value in right

right half sorted
    val[mid]<x && x<val[high] if true then val in right half
    else
    value in left 
    

value in original 2d matrix
Row = index / columns
Col = index % columns

[Kyuki flatten karte time hum row-wise likhte hain 
isliye ek row me exactly m elements hote hain (yani columns).]
*/