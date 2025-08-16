// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        
        //sort
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int n=arr.length;
        
        int i=0;
        int j=0;
        int platform=0;
        int max=0;
        
        while(i<n && j<n)
        {
            if(arr[i]<=dep[j])
            {
                platform++;
                i++;
            }
            else
            {
                platform--;
                j++;
            }
            max=Math.max(max,platform);
        }
        
        return max;
    }
}
/*
arr[]=900   940     950     1100    1500    1800
dep[]=910   1200    1120    1130    1900    2000

sort:-

arr[] = [900, 940, 950, 1100, 1500, 1800]
dep[] = [910, 1120, 1130, 1200, 1900, 2000]

arr[]<=dep[]    platform++ i++
arr[]>dep[]     platform-- j++

i   j   arr[i]          dep[j]      platform    max
0   0   900      <       910            1       1
1   0   940     >       910             0       1
1   1   940     <         1120          1       1
2   1   950     <       1120            2       2
3   1   1100    <       1120            3       3
4   1   1500    >       1120            2       3
4   2   1500    >       1130            1       3
4   3   1500    >       1200            0       3
4   4   1500    <       1900            1       3
5   4   1800    <       1900            2       3
6(end)

return max=3

*/