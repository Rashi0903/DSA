class Solution {
    public void sortInWave(int arr[]) {
        // code here
        int len=arr.length;
        for(int i=0;i<len-1;i=i+2)
        {
            int temp=arr[i+1];
            arr[i+1]=arr[i];
            arr[i]=temp;
        }
        
    }
}
/*
 arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5]
 agay wala bada hoga as compare to pechai wala 
 
Input: arr[] = [1, 2, 3, 4, 5]
Output: [2, 1, 4, 3, 5]
Explanation: Array elements after sorting it in the waveform are 2, 1, 4, 3, 5.

2>1<4>3<5

given  sorted array 

[1] aur [2] ko exchange krdo
[4] aur [3] ko exchange krdo
[5] last hai toh leave it

loop (i=0;i<len;i=i+2)
    interchange krdo [i] and [i+1] in the original array using temp variable
*/
