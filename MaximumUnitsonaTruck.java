/*
 * 1710. Maximum Units on a Truck
 */

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });
        
        int boxes = 0;
        int units = 0;
        int i = 0;
        while(i < boxTypes.length) {
            boxes += boxTypes[i][0];
            if(boxes > truckSize) {
                boxes -= boxTypes[i][0];
                units += (truckSize - boxes) * boxTypes[i][1];
                return units;
            } else {
                units += boxTypes[i][0] * boxTypes[i][1];
                i++;
            }
        }
        
        return units;
    }
}