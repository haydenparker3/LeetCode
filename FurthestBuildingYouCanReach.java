/*
 * 1642. Furthest Building You Can Reach
 * Min heap problem where you greedily use ladders adding the height of the climb into the min heap.
 * If the min heap is full (used all ladders), you remove the shortest climb and replace it with bricks.
 * Return the index you've reached when you run out of bricks.
 */

class Solution {
    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> climbs = new PriorityQueue<Integer>();
        
        int ubricks = 0;
        
        for(int i = 1; i < heights.length; i++) {
            int climb = heights[i] - heights[i-1];
            
            if(climb > 0) { // climb
                if(climbs.size() < ladders) { // greedily use ladders
                    climbs.add(climb);
                } else {
                    climbs.add(climb);
                    ubricks += climbs.remove();
                    if(ubricks > bricks)
                        return i-1;
                }
            }
        }
        
        return heights.length - 1;
    }
}
