/*
 * 16. 3Sum Closest
 * Sliding on numbers right of ith element to find sum of nums[i] + nums[l] + nums[r] which is
 * closest to target.
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closest = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        int i = 0;
        while(i < nums.length) {
            int l = i+1;
            int r = nums.length-1;
            while(l < r) { // two pointer approach on numbers right of target
                int sum = nums[l] + nums[r] + nums[i];
                int diff = Math.abs(target - sum);
                
                if(diff < closest) {
                    closest = diff;
                    closestSum = sum;
                }
                
                if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
            
            i++;
        }

        return closestSum;
    }
}