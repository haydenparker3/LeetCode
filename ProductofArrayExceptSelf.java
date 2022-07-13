/*
 * 238. Product of Array Except Self
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productSum = 1;
        int numZeros = 0;
        int zindex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
                zindex = i;
                if(numZeros == 2) {
                    for(int j = 0; j < nums.length; j++)
                        nums[j] = 0;
                    return nums;
                }
            } else
                productSum *= nums[i];
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(numZeros == 1) {
                if(i == zindex)
                    nums[i] = productSum;
                else
                    nums[i] = 0;
            } else {
                nums[i] = productSum / nums[i];
            }
        }
        
        return nums;
    }
}