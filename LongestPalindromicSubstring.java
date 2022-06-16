/*
 * 5. Longest Palindromic Substring
 * Optimal solution uses dynamic programming to check if a substring is palindromic in
 * O(1) constant time
 */

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        int maxLength = 1;
        int mi = 0;
        int mj = 0;
        
        for(int j = 0; j < s.length(); j++) {
            for(int i = 0; i <= j; i++) {
                int length = j-i+1;
                if(s.charAt(i) == s.charAt(j)) {
                    if(length <= 2) {
                        dp[i][j] = true;
                        if(length > maxLength) {
                            maxLength = length;
                            mi = i;
                            mj = j;
                        }
                    } else if(dp[i+1][j-1]) { // length greater than 2 so have to check i+1 j-1 substring is valid
                        dp[i][j] = true;
                        if(length > maxLength) {
                            maxLength = length;
                            mi = i;
                            mj = j;
                        }
                    }
                }
            }
        }
        
        return s.substring(mi, mj+1);
    }
}