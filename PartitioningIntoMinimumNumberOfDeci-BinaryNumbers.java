/*
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 */

class Solution {
    public int minPartitions(String n) {
        int maxd = 0;
        
        for(int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            
            if(digit > maxd)
                maxd = digit;
            if(maxd == 9)
                return 9;
        }
        
        return maxd;
    }
}
