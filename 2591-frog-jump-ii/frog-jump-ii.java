class Solution {
    public int maxJump(int[] stones) {
        int len=stones.length;
        int maxjump=Integer.MIN_VALUE;
        for(int i=2;i<len;i++)
        {
            maxjump=Math.max(maxjump,stones[i]-stones[i-2]);
        }
        maxjump=Math.max(maxjump,stones[1]-stones[0]);
        return maxjump;
    }
}