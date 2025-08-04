class Solution {
    public int peakElement(int[] arr) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // or high, both are same now
    }
}

/*
Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
arr[4] < arr[5] > arr[6].   7 < 8 > 3
1 < 2 < 4

approach    [O(n)]
for(i:1-n-2)
    if(arr[i-1]<arr[i] && arr[i]>arr[i+1])
        true
        
more optimized binary search [O(log n)]
*/