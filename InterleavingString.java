/*
 * 97. Interleaving String
 */

class Solution {
    boolean memo[][][];
    
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        
        return weave(s1, s2, s3, 0, 0, 0);
    }
    
    public boolean weave(String s1, String s2, String s3, int a, int b, int i) {
        
        if(i == s3.length()) {
            if(a == s1.length() && b == s2.length()) {
                return true;
            } else {
                memo[a][b][i] = true;
                return false;
            }
        }
        if(a == s1.length() && b == s2.length()) {
            memo[a][b][i] = true;
            return false;
        }
        
        char l = s3.charAt(i);
        if(memo[a][b][i])
            return false;
        
        if(a == s1.length()) {
            if(s2.charAt(b) == l){
                boolean p = weave(s1, s2, s3, a, b+1, i+1);
                if(p)
                    return true;
                
                memo[a][b][i] = true;
                return false;
            } else {
                memo[a][b][i] = true;
                return false;
            }
        } else if(b == s2.length()) {
            if(s1.charAt(a) == l) {
                boolean p = weave(s1, s2, s3, a+1, b, i+1);
                if(p)
                    return true;
                
                memo[a][b][i] = true;
                return false;
            } else {
                memo[a][b][i] = true;
                return false;
            }
        } else if(s1.charAt(a) == l && s2.charAt(b) == l) {
            boolean p = weave(s1, s2, s3, a+1, b, i+1);
            if(p)
                return true;
            
            p = weave(s1, s2, s3, a, b+1, i+1);
            if(p)
                return true;
            
            memo[a][b][i] = true;
            return false;
        } else if(s1.charAt(a) == l) {
            boolean p = weave(s1, s2, s3, a+1, b, i+1);
            if(p)
                return true;
            
            memo[a][b][i] = true;
            return false;
        } else if(s2.charAt(b) == l) {
            boolean p = weave(s1, s2, s3, a, b+1, i+1);
            if(p)
                return true;
            
            memo[a][b][i] = true;
            return false;
        } else {
            memo[a][b][i] = true;
            return false;
        }
    }
}