class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n=arr.length;
        
        int max=arr[0];
        int min=arr[0];
        int result=arr[0];
        
        for(int i=1;i<n;i++)
        {
            if(arr[i]<0)
            {
                //swap krdo min and max ko
                int temp=min;
                min=max;
                max=temp;
            }
            min=Math.min(arr[i],min*arr[i]);
            max=Math.max(arr[i],max*arr[i]);
            
            result=Math.max(max,result);
        }
        
        return result;
    }
}
/*
--->modified kadane's algo
+/-=-
-/+=-
-/-=+
+/+=+

i=0: maxEnd=2, minEnd=2, result=2
i=1: maxEnd=6, minEnd=3, result=6
i=2: swap → maxEnd=3, minEnd=6
      maxEnd = max(-2, -6) = -2
      minEnd = min(-2, -12) = -12
      result=6
i=3: maxEnd = max(4, -8) = 4
      minEnd = min(4, -48) = -48
      result=6
i=4: swap → maxEnd=-48, minEnd=4
      maxEnd = max(-3, 144) = 144
      minEnd = min(-3, -12) = -12
      result=144


loop through array
if number <0 
    swap min and max ko qki in future maybe -/- ko bada positve product daidai.
    

    ek hoga result jo ki main ans ko store krrai gaaaaaa
    
*/





