/*
 * 630. Course Schedule III
 * Uses greedy approach on the deadline for completion date. if courses time + used time exceeds
 * deadline, remove previous course with longest completion date.
 */

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int totalTime = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < courses.length; i++) {
            totalTime += courses[i][0];
            q.add(courses[i][0]);
            
            if(totalTime > courses[i][1]) {
                totalTime -= q.poll();
            }
        }
        
        return q.size();
    }
}