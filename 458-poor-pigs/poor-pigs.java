class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds=minutesToTest/minutesToDie;
        if(buckets==1 && rounds==1)
        {
            return 0;
        }
        int states=rounds+1;
        int pig=1;
        int total=states;
        while(total<buckets)
        {
            total=total*states;
            pig++;
        }
        return pig;
    }
}