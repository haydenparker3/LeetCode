/*
 * 1268. Search Suggestions System
 * Another Trie data structure problem. After searching the trie with the search query you have to
 * do dfs from the node and return the first 3 words. These 3 words are the lexicographical minimum
 * of all words matching the search query
 */

class Solution {
    
    static final int SYMBOLS = 27; // 26 letters + #
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[SYMBOLS];

        boolean endOfWord;
        String word;

        TrieNode(){
            endOfWord = false;
            for (int i = 0; i < SYMBOLS; i++)
                children[i] = null;
        }
    }

    static void insert(String key) {
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
        curr.word = key;
    }
    
    static List<String> search(String key) {
        int length = key.length();
        int letter;
        TrieNode curr = root;
      
        for (int level = 0; level < length; level++) {
            if(key.charAt(level) == '#')
                letter = 26;
            else
                letter = key.charAt(level) - 'a';
            
            if (curr.children[letter] == null)
                return new ArrayList<>();
      
            curr = curr.children[letter];
        }
        
        return dfs(curr, new ArrayList<String>());
    }
    
    static List<String> dfs(TrieNode node, List<String> words) {
        if(node.endOfWord) {
            words.add(node.word);
        }
        if(words.size() == 3)
            return words;
        
        List<String> ret = words;
        for(int i = 0; i < SYMBOLS; i++) {
            if(node.children[i] != null) {
                ret = dfs(node.children[i], words);
                
                if(ret.size() == 3)
                    return ret;
            }
        }
        
        return ret;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        root = new TrieNode();
        
        for(int i = 0; i < products.length; i++) {
            insert(products[i]);
        }
        
        List<List<String>> suggested = new ArrayList<>();
        
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < searchWord.length(); i++) {
            b.append(searchWord.charAt(i));
            suggested.add(search(b.toString()));
        }
        
        return suggested;
    }
}