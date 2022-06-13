/*
 * 120. Triangle
 * Goal is to find the minimum path down a triangle like so
 *   1
 *  1 2
 * 1 2 3
 * you can only go to the next element to the left or right of you
 * You use dynamic programming to store the sum as you backtrack up the triangle in O(1) space
 */

class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
        
        List<Integer> sums = triangle.get(triangle.size()-1);
        
        for(int i = triangle.size()-2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                sums.set(j, triangle.get(i).get(j) + Math.min(sums.get(j), sums.get(j+1)));
            }
        }
        
        return sums.get(0);
    }
}