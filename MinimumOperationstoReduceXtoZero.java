/*
 * 1658. Minimum Operations to Reduce X to Zero
 * Sliding window problem. trick is to know that you just have to find the max length subarray
 * where the sum is equal total of array minus X. The minimum operations would be the length of the
 * array minus the length of the longest subarray
 */

class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        
        for(int i = 0; i < nums.length; i++)
            total += nums[i];
        
        total -= x; // total of remainding nums
        if(total < 0)
            return -1;
        else if(total == 0)
            return nums.length;
        
        // find longest subarray that = total
        
        int maxLength = -1;
        
        int i = 0;
        int j = 0;
        
        long sum = 0;
        while(j < nums.length && nums.length - maxLength >= i) {
            sum += nums[j];
            
            if(sum == total) {
                if(j-i > maxLength) {
                    maxLength = j-i+1;
                    i++;
                    j++;
                    sum -= nums[i-1];
                }
                else {
                    i++;
                    j++;
                    sum -= nums[i-1];
                }
            } else if(sum < total) { // sum of sub array less than total, add a number
                j++;
            } else if(sum > total) { // sum of sub array greater than total, subtract a number
                i++;
                sum -= nums[i-1];
                sum -= nums[j]; // subtract nums[j] otherwise it would be added again by first line
            }
        }
        
        if(maxLength == -1)
            return -1;
        else
            return nums.length - maxLength;
    }
}
