class Solution {

    static int count = 0; // global counter

    static int inversionCount(int arr[]) {
        count = 0; // reset before running
        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr, l, r);
        return count;
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    static void merge(int arr[], int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // count inversions
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        // Copy back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }
    }
}

/*
Brute force:

[2, 4, 1, 3, 5]
when i=0
 j=1 4 (4>2) no possible
 j=2 1 (1<2) true count ++ 
 then check for others also like j=3 then 4
 when i=1
 j=2 (1<4) count++
 j=3 (3<4) count++
continue this till i=4
then return count
O(n^2)
efficient:-

merge sort
(n log n)
    
        Dry Run Table: arr = [2, 4, 1, 3, 5]

1	[0,1]	[2]	[4]	[2, 4]	0	0
2	[0,2]	[2, 4]	[1]	[1, 2, 4]	(2,1), (4,1) = 2	2
3	[3,4]	[3]	[5]	[3, 5]	0	2
4	[0,4]	[1, 2, 4]	[3, 5]	[1, 2, 3, 4, 5]	(4,3) = 1	3


*/
