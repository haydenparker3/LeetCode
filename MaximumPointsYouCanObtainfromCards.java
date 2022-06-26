/*
 * 1423. Maximum Points You Can Obtain from Cards
 */

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i = 0;
        int j = cardPoints.length - k - 1;
        int mi = 0;
        int mj = cardPoints.length - k - 1;
        
        int subsum = 0;
        
        for(int a = i; a <= j; a++) {
            subsum += cardPoints[a];
        }
        
        int minsum = subsum;
        while(j < cardPoints.length-1) {
            subsum -= cardPoints[i];
            i++;
            j++;
            subsum += cardPoints[j];
            
            if(subsum < minsum) {
                minsum = subsum;
                mi = i;
                mj = j;
            }
        }
        
        int max = 0;
        
        for(int a= 0; a < mi; a++) {
            max += cardPoints[a];
        }
        
        for(int a = mj+1; a < cardPoints.length; a++) {
            max += cardPoints[a];
        }
        
        return max;
    }
}