/*Complete the Function below*/
/*

 arr[] = [111, 222, 333, 444, 555]
 
 
*/
class Solution {
    public static boolean isPalinArray(int[] arr) {
        // add code here.
        int len=arr.length;
        for(int i=0;i<len;i++)
        {
            int num=arr[i];
            if(!isPalindrome(num))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int num)
    {
        int sum=0;
        int dummy=num;
        while(num!=0)
        {
            int r=num%10;
            sum=sum*10+r;
            num/=10;
        }
        if(sum==dummy)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}