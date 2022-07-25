/*
 * 34. Find First and Last Position of Element in Sorted Array
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        
        int p1 = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                p1 = mid;
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
        }
        
        low = 0;
        high = nums.length-1;
        
        int p2 = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                p2 = mid;
                low = mid + 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
        }
        
        return new int[]{p1, p2};
    }
}