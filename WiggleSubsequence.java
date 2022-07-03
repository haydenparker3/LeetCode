/*
 * 376. Wiggle Subsequence
 */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int length = 1;
        int i = 0;
        int j = 1;
        boolean increasing = false; // default false since dont know yet
        boolean decreasing = false;
        while(j < nums.length) {
            if(nums[j] == nums[j-1]) { // same elements are skipped
                
            } else if(nums[j] < nums[j-1]) {
                if(increasing) { // local maximum
                    length++;
                    i = j-1; // j-1 was the local max
                }
                increasing = false; // tending toward a local minimum
                decreasing = true;
            } else if(nums[j] > nums[j-1]) {
                if(decreasing) { // local minimum
                    length++;
                    i = j-1; // j-1 was the local min
                }
                increasing = true; // tending toward a local  maximum
                decreasing = false;
            }
            
            j++;
        }
        
        // include last num as local maximum or minimum
        if(increasing && nums[j-1] > nums[i]) {
            length++;
        } else if(decreasing && nums[j-1] < nums[i]) {
            length++;
        }
        
        return length;
    }
}