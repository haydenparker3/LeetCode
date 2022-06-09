/*
 * 58. Length of Last Word
 * From a given string finds the length of the last word. Words are separated by spaces
 */

class Solution {
    public int lengthOfLastWord(String s) {
        int wlength = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                wlength = 0;
                while(i < s.length() && s.charAt(i) != ' ') {
                    wlength++;
                    i++;
                }
            }
        }
        
        return wlength;
    }
}