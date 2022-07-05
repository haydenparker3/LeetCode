/*
 * 128. Longest Consecutive Sequence
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            m.put(nums[i], 1);
        }
        
        int mlength = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            int length = 0;
            int seq = num;
            while(m.containsKey(seq)) {
                m.remove(seq);
                length++;
                seq--;
            }
            
            seq = num+1;
            while(m.containsKey(seq)) {
                m.remove(seq);
                length++;
                seq++;
            }
            
            if(length > mlength)
                mlength = length;
        }
        
        return mlength;
    }
}