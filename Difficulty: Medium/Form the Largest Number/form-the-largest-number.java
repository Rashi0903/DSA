class Solution {
    public String findLargest(int[] arr) {
        // code here
        ArrayList<String>number=new ArrayList<>();
        for(int num:arr)
        {
            number.add(Integer.toString(num));
        }
        
        Collections.sort(number,(s1,s2)->compare(s1,s2)?-1:1);
        
        if(number.get(0).equals("0"))
        {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        for(String num:number)
        {
            res.append(num);
        }
        
        return res.toString();
        
    }
    
    public static boolean compare(String s1,String s2)
    {
        return (s1+s2).compareTo(s2+s1)>0;
    }
}