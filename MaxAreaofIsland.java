/*
 * 695. Max Area of Island
 */

class Solution {
    int[][] grid;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int maxArea = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(this.grid[i][j] == 1)
                    maxArea = Math.max(maxArea, area(i, j, 0));
            }
        }
        
        return maxArea;
    }
    
    public int area(int i, int j, int a) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return a;
        
        grid[i][j] = 0;
        
        a = a+1;
        a = area(i-1, j, a);
        a = area(i+1, j, a);
        a = area(i, j-1, a);
        a = area(i, j+1, a);

        return a;
    }
}