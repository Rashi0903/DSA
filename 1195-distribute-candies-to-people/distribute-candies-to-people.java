class Solution {
    public int[] distributeCandies(int candies, int num_people) {
     int arr[]=new int[num_people];
     int i=0;
     int c=1;
     while(candies!=0)
     {
        int give=Math.min(candies,c);
        arr[i]+=give;
        candies-=give;
        c++;
        i=(i+1)%num_people;
     }  
     return arr; 
    }
}