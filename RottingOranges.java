/*
 * 994. Rotting Oranges
 */

class Solution {
    int cols;
    int rows;
    int numFresh = 0;
    boolean finished = false;
    HashSet<Pair<Integer, Integer>> fresh = new HashSet<>();
    Queue<Pair<Integer, Integer>> turned = new LinkedList<>();
    
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    numFresh++;
                    fresh.add(new Pair<Integer, Integer>(row, col));
                }
            }
        }
        
        int steps = 0;
        
        while(numFresh != 0 && !finished) {
            finished = true;
            bfs(grid);
            
            if(!turned.isEmpty()) { // tomato turned so increment step and not finished
                steps++;
                finished = false;
            }
            
            while(!turned.isEmpty()) {
                grid[turned.peek().getKey()][turned.peek().getValue()] = 2;
                numFresh--;
                turned.remove();
            }
        }
        
        if(numFresh != 0)
            return -1;
        
        return steps;
    }
    
    public void bfs(int[][] grid) {
        Iterator<Pair<Integer, Integer>> i = fresh.iterator();
        
        while(i.hasNext()) {
            boolean rup = false;
            boolean rdown = false;
            boolean rleft = false;
            boolean rright = false;
            
            Pair<Integer, Integer> t = i.next();
            
            int r = t.getKey();
            int c = t.getValue();
            
            if(r > 0 && grid[r-1][c] == 2) {
                rup = true;
            }
            if(r < rows-1 && grid[r+1][c] == 2) {
                rdown = true;
            }
            if(c > 0 && grid[r][c-1] == 2) {
                rdown = true;
            }
            if(c < cols-1 && grid[r][c+1] == 2) {
                rdown = true;
            }
            
            if(rup || rdown || rleft || rright) { // rotten next to fresh so turns
                turned.add(t);
                i.remove(); // remove tomato from fresh
            }
        }
    }
}