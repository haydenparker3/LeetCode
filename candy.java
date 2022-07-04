/*
 * 135. Candy
 */

class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 1)
            return 1;
        
        int[] candys = new int[ratings.length];
        for(int i = 0; i < candys.length; i++) { // everyone gets atleast 1 candy
            candys[i] = 1;
        }
        
        PriorityQueue<Pair<Integer,Integer> > pq =
                new PriorityQueue<Pair<Integer,Integer>>(Comparator.comparing(Pair::getKey));
        
        for(int i = 0; i < ratings.length; i++) {
            pq.add(new Pair(ratings[i], i));
        }
        
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> child = pq.poll();
            int rat = child.getKey();
            int index = child.getValue();
            
            if(index == 0) {
                if(rat > ratings[index+1]) {
                    candys[index] = candys[index+1] + 1;
                }
            } else if(index == ratings.length-1) {
                if(rat > ratings[index-1]) {
                    candys[index] = candys[index-1] + 1;
                }
            } else {
                if(rat > ratings[index-1] || rat > ratings[index+1]) {
                    if(rat > ratings[index-1] && rat > ratings[index+1])
                        candys[index] = Math.max(candys[index-1], candys[index+1]) + 1;
                    else if(rat > ratings[index-1])
                        candys[index] = candys[index-1] + 1;
                    else if(rat > ratings[index+1])
                        candys[index] = candys[index+1] + 1;
                }
            }
        }
        
        int n = 0;
        for(int i = 0; i < candys.length; i++) {
            n += candys[i];
        }
        
        return n;
    }
}