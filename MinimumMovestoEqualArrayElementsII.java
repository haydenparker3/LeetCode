/*
 * 462. Minimum Moves to Equal Array Elements II
 */

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int median;
        if(nums.length % 2 == 0) {
            median = (nums[nums.length/2] + nums[nums.length/2 - 1]) / 2;
        } else {
            median = nums[nums.length/2];
        }
        
        int moves = 0;
        for(int i = 0; i < nums.length; i++) {
            moves += Math.abs(median - nums[i]);
        }
        
        return moves;
    }
}