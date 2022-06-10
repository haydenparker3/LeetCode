/*
 * 67. Add Binary
 * Adds two binary number in String format and returns the new number as a string
 */

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        
        boolean carry = false;
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0 && j >= 0) {
            char m = a.charAt(i);
            char n = b.charAt(j);
            
            if(m == '0' && n == '0') { // 0 0
                if(carry) { // 0 0 1
                    str.insert(0, "1");
                    carry = false;
                }
                else
                    str.insert(0, "0");
            } else if(m == '0' || n == '0') { // 1 0 or 0 1
                if(carry) // 1 0 1 or 0 1 1
                    str.insert(0, "0");
                else
                    str.insert(0, "1");
            } else { // 1 1
                if(carry) // 1 1 1
                    str.insert(0, "1");
                else {
                    str.insert(0, "0");
                    carry = true;
                }
            }
            
            i--;
            j--;
        }
        
        while(i >= 0) {
            char m = a.charAt(i);
            
            if(m == '0') {
                if(carry) {
                    str.insert(0, "1");
                    carry = false;
                } else
                    str.insert(0, "0");
            } else {
                if(carry) {
                    str.insert(0, "0");
                } else
                    str.insert(0, "1");
            }
            
            i--;
        }
        
        while(j >= 0) {
            char n = b.charAt(j);
            
            if(n == '0') {
                if(carry) {
                    str.insert(0, "1");
                    carry = false;
                }
                else
                    str.insert(0, "0");
            } else {
                if(carry) {
                    str.insert(0, "0");
                } else
                    str.insert(0, "1");
            }
            
            j--;
        }
        
        if(carry)
            str.insert(0, "1");
        
        return str.toString();
    }
}