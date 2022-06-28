/*
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 */

class Solution {
    public int minDeletions(String s) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }
        
        int maxFreq = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                if(m.containsKey(freq[i])) {
                    Integer f = m.get(freq[i]);
                    f += 1;
                    m.put(freq[i], f);
                } else {
                    m.put(freq[i], 1);
                }
                
                if(freq[i] > maxFreq)
                    maxFreq = freq[i];
            }
        }
        
        int deletions = 0;
        for(int i = maxFreq; i > 0; i--) {
            if(m.containsKey(i) && m.get(i) > 1) {
                int same = m.get(i);
                deletions += same - 1; // delete character from all same frequency characters except one
                
                if(m.containsKey(i-1)) { // add changed frequency characters to map
                    Integer f = m.get(i-1);
                    f += same - 1;
                    m.put(i-1, f);
                } else {
                    Integer f = new Integer(same - 1);
                    m.put(i-1, f);
                }
            }
        }
        
        return deletions;
    }
}