
class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        
        int dp[][]=new int [n+1][n+1];
        int maxlen=0;
        int endidx=0;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==rev.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    
                    int ogfrev=n-j;
                    if(ogfrev+dp[i][j]-1==i-1)
                    {
                        if(dp[i][j]>maxlen)
                        {
                            maxlen=dp[i][j];
                            endidx=i-1;
                        }
                    }
                }
                else
                {
                    dp[i][j]=0;
                }
            }
        }
        int startidx=endidx-maxlen+1;
            return s.substring(startidx,endidx+1);
    }
}
/*
| i\j | s | k | e | e | G |
| --- | - | - | - | - | - |
| G   | 0 | 0 | 0 | 0 | 1 |
| e   | 0 | 0 | 1 | 1 | 0 |
| e   | 0 | 0 | 1 | 2 | 0 |
| k   | 0 | 1 | 0 | 0 | 0 |
| s   | 1 | 0 | 0 | 0 | 0 |

if([i-1]==[j-1])
{
    diagonal+1;
    
    //find the mirror   
        original index from reversed=5-4=1(ie 2 in original)
                                    =n-j;
        continuous hai ya nahi? (original index from reversed+dp[i][j]-1 == i-1)
            maxlen=dp[i][j];
            endidx=i-1
            
    
}
return substring from starting position(endidx-maxlen+1) to endidx+1
*/