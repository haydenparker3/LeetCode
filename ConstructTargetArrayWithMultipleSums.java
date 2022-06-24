/*
 * 1354. Construct Target Array With Multiple Sums
 */

class Solution {
    public boolean isPossible(int[] target) {
        boolean constructing = true;
        
        if(target.length == 1 && target[0] != 1)
            return false;
        
        while(constructing) {
            long rsum = 0;
            int max = target[0];
            int mindex = 0;

            boolean allOne = true;
            for(int i = 0; i < target.length; i++) {
                rsum += target[i];
                if(target[i] != 1)
                    allOne = false;
                if(target[i] > max) {
                    max = target[i];
                    mindex = i;
                }
            }

            rsum -= max;
            
            if(allOne)
                return true;
            if(rsum >= target[mindex])
                return false;
            
            
            target[mindex] = target[mindex] % Math.toIntExact(rsum);
            if(target[mindex] == 0)
                target[mindex] += rsum;
        }
        
        return true;
    }
}