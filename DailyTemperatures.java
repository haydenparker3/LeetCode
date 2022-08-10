/*
 * 739. Daily Temperatures
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        
        int length = temperatures.length;
        int[] answer = new int[length];
        
        for(int i = 0; i < length; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                answer[index] = i - index;
            }
            
            s.push(i);
        }
        
        return answer;
    }
}