class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0]; // final answer
        int currMax = nums[0];    // max ending at current index
        int currMin = nums[0];    // min ending at current index

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax; // save before we update

            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

            maxProduct = Math.max(maxProduct, currMax);
        }

        rashika();
        rashika();

        return maxProduct;
    }

    static int rashika() {
        return 0;
    }
}


/*

[2,3,-2,4]
maxpro=2
product=2
i=1-n;

when i=3
product=2*3=6
maxpro=max(2,6)=6

i=4
product=-12
maxpro=max(6,-12)=6

cause product=-12<0 => product=1

when i=5
product=4
maxpro=max(6,4)=6

return maxpro;


[-1, -2, -3, 0, 1]
op- 6 (-2 * -3)

pro=-1;
maxpro=-1;
minpro=-1;

loop(i-n)
    

*/