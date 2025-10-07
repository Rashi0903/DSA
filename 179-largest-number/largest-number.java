class Solution {
    public String largestNumber(int[] nums) {
        int len=nums.length;
        String []arr=new String[len];
        for(int i=0;i<len;i++)
        {
            arr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));

        if(arr[0].equals("0"))
        {
            return "0";
        }

        StringBuilder str=new StringBuilder();
        for(String s:arr)
        {
            str.append(s);
        }

        return str.toString();
    }
}