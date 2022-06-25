/*
 * 68. Text Justification
 */

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<StringBuilder> line = new ArrayList<>();
        List<String> paper = new ArrayList<>();
        
        int lineLength = 0;
        int i = 0;
        int j = 0;
        while(j < words.length) {
            
            lineLength += words[j].length(); //include first word length
            while(j < words.length-1 && lineLength <= maxWidth) { // can try to add another word
                j++;
                lineLength++; // include space
                lineLength += words[j].length();
            }
            
            if(lineLength > maxWidth) { // not last line
                
                lineLength -= words[j].length()+1; // remove last space and word from line that overfilled
                j--; // j index of last word in line
                
                int padding = maxWidth - lineLength; // space padding needed
                int w = j-i+1; // number of words in the line
                
                if(w == 1) { // one word in line
                    line.add(new StringBuilder(words[i])); // since only 1 words, don't include space
                    
                    int word = 0;
                    while(padding > 0) { // pad word with needed spaces
                        line.get(word).append(" ");
                        padding--;
                    }

                    StringBuilder l = new StringBuilder();
                    l.append(line.get(0).toString());
                    
                    paper.add(l.toString());
                    
                } else { // more than 1 word in line
                    for(int a = i; a < j; a++) { // add all words except last to line for padding
                        line.add(new StringBuilder(words[a] + " "));
                    }

                    int word = 0;
                    while(padding > 0) {
                        line.get(word).append(" ");
                        padding--;
                        word++;
                        if(word == line.size())
                            word = 0;
                    }

                    StringBuilder l = new StringBuilder();
                    for(int a = 0; a < line.size(); a++) {
                        l.append(line.get(a).toString());
                    }
                    l.append(words[j]); // add last word to end
                    
                     paper.add(l.toString());
                }
            } else { // last line only pad right side
                int padding = maxWidth - lineLength; // space padding needed
                int w = j-i+1; // number words in the line
                
                for(int a = i; a < j; a++) { // add all words to line
                    line.add(new StringBuilder(words[a] + " "));
                }
                line.add(new StringBuilder(words[j])); // last word doesn't have extra space
                
                // only last word gets padded
                int word = line.size()-1;
                while(padding > 0) {
                    line.get(word).append(" ");
                    padding--;
                }
                
                StringBuilder l = new StringBuilder();
                for(int a = 0; a < line.size(); a++) {
                    l.append(line.get(a).toString());
                }
                
                paper.add(l.toString());
            }
        
            lineLength = 0;
            i = j+1;
            j = j+1;
            line.clear();
        }
        
        return paper;
    }

}