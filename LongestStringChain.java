/*
 * 1048. Longest String Chain
 * dfs search except you skip already visited nodes
 */

class Solution {
    boolean[] visited;
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        
        visited = new boolean[words.length];
        
        int i = words.length-1;
        int maxChain = 1;
        while(i >= 0) {
            if(!visited[i]) {
                int chain = Chain(words, words[i].length(), i, 1);

                if(chain > maxChain)
                    maxChain = chain;
            }
            
            i--;
        }
        
        return maxChain;
    }
    
    public int Chain(String[] words, int length, int i, int currChain) {
        int maxChain = currChain;
        
        int j = i-1;
        while(j >= 0 && words[j].length() >= length-1) {
            if(words[j].length() == length-1 && !visited[j]) { // skips words same length as word i
                if(predecessor(words[j], words[i])) {
                    visited[j] = true;
                    
                    int chain = Chain(words, length-1, j, currChain+1);
                    if(chain > maxChain)
                        maxChain = chain;
                }
            }
            
            j--;
        }
        
        return maxChain;
    }
    
    public boolean predecessor(String pred, String word2) {
        
        int i = 0;
        int j = 0;
        int diff = 0;
        
        while(i < pred.length() && j < word2.length()) {
            if(pred.charAt(i) != word2.charAt(j)) {
                if(diff == 1)
                    return false;
                
                j++;
                diff = 1;
            } else {
                i++;
                j++;
            }
        }
        
        return true;
    }
}