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