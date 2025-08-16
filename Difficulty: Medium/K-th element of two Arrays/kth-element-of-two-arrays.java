class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n=a.length;
        int m=b.length;
        int i=0;
        int j=0;
        int c=0;
        
        while(i<n && j<m)
        {
            int val;
            if(a[i]<b[j])
            {
                val=a[i];
                i++;
            }
            else
            {
                val=b[j];
                j++;
            }
            c++;
            if(c==k)
            {
                return val;
            }
        }
        
        while(i<n)
        {
            c++;
            if(c==k)
            {
                return a[i];
            }
            i++;
        }
        
        while(j<m)
        {
            c++;
            if(k==c)
            {
                return b[j];
            }
            j++;
        }
        
        return -1;
    }
}
/*
a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
[1  2   3   4   6   7   8   9   10]

op=6    (1-based index)
while(i<n && j<n)
    if(a[i]<b[j])
        val=a[i]
        i++
    else
        val=b[j]
        j++
    c++
    if(c==k)    return val;

if in case elemnts bachai ho in a[] or b[] toh unko alag sai process 
kro

TC:- O(k)
SC:- O(1)
*/