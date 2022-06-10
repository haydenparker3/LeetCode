/*
 * 3. Longest Substring Without Repeating Characters
 * Most optimal solution with O(n) runtime
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<Character, Integer>();
        
        int maxLength = 0;
        int subtract = 0;
        for(int i = 0; i < s.length(); i++) {
            
            if(chars.containsKey(s.charAt(i)) && chars.get(s.charAt(i)) > subtract) {
                subtract = chars.get(s.charAt(i));
            }
            
            chars.put(s.charAt(i), i+1);
            
            if(i+1-subtract > maxLength)
                maxLength = i+1 - subtract;
        }
        
        return maxLength;
    }
}