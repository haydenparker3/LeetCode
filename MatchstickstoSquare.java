/*
 * 473. Matchsticks to Square
 */

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sumSides = 0;
        for(int i = 0; i < matchsticks.length; i++) {
            sumSides += matchsticks[i];
        }
        
        int possible = sumSides % 4;
        
        if(possible == 0) {
            Arrays.sort(matchsticks); 
            int side = sumSides / 4;
            
            return make(side, 0, 0, 0, 0, matchsticks.length-1, matchsticks);
        } else
            return false;
    }
    
    public boolean make(int side, int s1, int s2, int s3, int s4, int i, int[] sticks) {
        if(s1 > side)
            return false;
        else if(s2 > side)
            return false;
        else if(s3 > side)
            return false;
        else if(s4 > side)
            return false;
        else {
            if(i == -1) {
                if(s1 == side && s2 == side && s3 == side && s4 == side)
                    return true;
                else
                    return false;
            } else {
                boolean c1 = make(side, s1+sticks[i], s2, s3, s4, i-1, sticks);
                if(c1)
                    return true;
                
                boolean c2 = make(side, s1, s2+sticks[i], s3, s4, i-1, sticks);
                if(c2)
                    return true;
                
                boolean c3 = make(side, s1, s2, s3+sticks[i], s4, i-1, sticks);
                if(c3)
                    return true;
                
                boolean c4 = make(side, s1, s2, s3, s4+sticks[i], i-1, sticks);
                if(c4)
                    return true;
                
                return false;
            }
        }
    }
}