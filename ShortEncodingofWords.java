/*
 * 820. Short Encoding of Words
 * Another Trie problem. Key is to insert the reverse of the words. Then dfs to all leaf nodes
 * and take the length of that words plus the dividing #.
 */

class Solution {
    
    static final int SYMBOLS = 26; // 26 letters
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[SYMBOLS];
        
        int length;
        
        TrieNode(){
            length = -1;
            for (int i = 0; i < SYMBOLS; i++)
                children[i] = null;
        }
    }

    static void insert(String key) {
        int length = key.length();
        int letter;

        TrieNode curr = root;

        for (int level = 0; level < length; level++) {
            letter = key.charAt(level) - 'a';
            
            if (curr.children[letter] == null) {
                curr.children[letter] = new TrieNode();
            }

            curr = curr.children[letter];
        }
        
        curr.length = length;
    }
    
    static int dfs(TrieNode node, int length) {
        boolean leaf = true;
        
        int ret = length;
        for(int i = 0; i < SYMBOLS; i++) {
            if(node.children[i] != null) {
                leaf = false;
                ret = dfs(node.children[i], ret);
            }
        }
        
        if(leaf) 
            ret += node.length + 1; // include the dividing #
        
        return ret;
    }
    
    public int minimumLengthEncoding(String[] words) {
        
        root = new TrieNode();
        
        for(int i = 0; i < words.length; i++) {
            StringBuilder s = new StringBuilder();
            for(int j = words[i].length()-1; j >= 0; j--) {
                s.append(words[i].charAt(j));
            }
            insert(s.toString());
        }
        
        return dfs(root, 0);
    }
}