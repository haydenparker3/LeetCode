/*
 * 1695. Maximum Erasure Value
 * Variation of sliding window problem. I precompute the sums array to be able to quickly get
 * the sum of any subarray. I use a hasmap to keep track of duplicates.
 */

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] sums = new int[nums.length+1];
        
        sums[0] = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int max = 0;
        int i = 0;
        int j = 0;
        
        while(j < nums.length) {
            if(m.containsKey(nums[j])) {
                if(m.get(nums[j])+1 > i)
                    i = m.get(nums[j])+1;
            }
            
            m.put(nums[j], j);
            
            int subsum = sums[j+1] - sums[i];
            
            if(subsum > max) {
                max = subsum;
            }
            
            j++;
        }
        
        return max;
    }
}