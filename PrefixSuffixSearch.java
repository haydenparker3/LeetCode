/*
 * 745. Prefix and Suffix Search
 * Solution uses Trie datastructure
 */

class WordFilter {
    static final int SYMBOLS = 27; // 26 letters + #
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[SYMBOLS];

        boolean endOfWord;
        int index;

        TrieNode(){
            endOfWord = false;
            index = -1;
            for (int i = 0; i < SYMBOLS; i++)
                children[i] = null;
        }
    }

    static void insert(String key, int index) {
        int length = key.length();
        int letter;

        TrieNode curr = root;

        for (int level = 0; level < length; level++) {
            if(key.charAt(level) == '#')
                letter = 26;
            else
                letter = key.charAt(level) - 'a';
            if (curr.children[letter] == null) {
                curr.children[letter] = new TrieNode();
            }

            curr = curr.children[letter];
        }

        // mark last node as leaf
        curr.endOfWord = true;
        curr.index = index;
    }
    
    static int search(String key) {
        int length = key.length();
        int letter;
        TrieNode curr = root;
      
        for (int level = 0; level < length; level++) {
            if(key.charAt(level) == '#')
                letter = 26;
            else
                letter = key.charAt(level) - 'a';
            
            if (curr.children[letter] == null)
                return -1;
      
            curr = curr.children[letter];
        }
        
        return dfs(curr);
    }
    
    static int dfs(TrieNode node) {
        int maxIndex = -1;
        if(node.endOfWord)
            maxIndex = node.index;
        for(int i = 0; i < SYMBOLS; i++) {
            if(node.children[i] != null) {
                int index = dfs(node.children[i]);
                
                if(index > maxIndex)
                    maxIndex = index;
            }
        }
        
        return maxIndex;
    }
    
    public WordFilter(String[] words) {
        
        root = new TrieNode();
        
        for(int i = 0; i < words.length; i++) {
            StringBuilder suffix = new StringBuilder();
            insert(suffix.toString() + "#" + words[i], i);
            
            for(int j = 0; j < words[i].length(); j++) {
                suffix.insert(0, words[i].charAt(words[i].length()-1-j)); //adds letters back to front
                insert(suffix.toString() + "#" + words[i], i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return search(suffix + "#" + prefix);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
