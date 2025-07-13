// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
        // code here
        int len=arr.length;
        int temp=arr[len-1];
        for(int i=len-2;i>=0;i--)
        {
            arr[i+1]=arr[i];
        }
        arr[0]=temp;
    }
}