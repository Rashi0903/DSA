class Solution {
    public int findLUSlength(String[] strs) {

        //sort according to their length
        Arrays.sort(strs,(a,b)->b.length()-a.length());

        for(int i=0;i<strs.length;i++)
        {
            boolean common=false;
            for(int j=0;j<strs.length;j++)
            {   
                //strs at same index need not to check
                if(i==j)
                {
                    continue;
                }

                //finds if strs[i] is present in strs[j]?
                if (isSubseq(strs[i],strs[j]))
                {
                    common=true;
                    break;
                }
            }

            //if it is not present then:-
            if(!common)
            {
                return strs[i].length();
            }
        }
        return -1;
    }

    public static boolean isSubseq(String a,String b)
    {
        int i=0;
        int j=0;
        while(i<a.length() && j<b.length())
        {
            if(a.charAt(i)==b.charAt(j))
            {
                i++;
            }
            j++;
        }

        //common is present
        if(i==a.length())
        {
            return true;
        }

        //common is not present 
        else
        {
            return false;
        }
    }
}