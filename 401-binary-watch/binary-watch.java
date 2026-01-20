class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String>ans=new ArrayList<>();
        int []h={1,2,4,8};
        int []m={1,2,4,8,16,32};
        find(0,turnedOn,h,m,0,0,ans);
        return ans;
    }
    public static void find(int idx,int on,int[]h,int[]m,int hr,int min,List<String>ans)
    {
        if(hr>11 || min>59)
        {
            return;
        }
        if(idx==10)
        {
            if(on==0)
            {
                ans.add(hr+":"+(min<10?"0"+min:min));
            }
            return;
        }
        //Option 1:on that led light
        if(on>0)
        {
            if(idx<4)
            {
                //selecting for hours
                find(idx+1,on-1,h,m,hr+h[idx],min,ans);
            }
            else
            {
                //selecting for min
                find(idx+1,on-1,h,m,hr,min+m[idx-4],ans);
            }
        }

        //Option2:ignore it
        find(idx+1,on,h,m,hr,min,ans);
    }
}