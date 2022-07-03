/*
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        // for(int i = 0; i < horizontalCuts.length; i++) {
        //     System.out.print(horizontalCuts[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0; i < verticalCuts.length; i++) {
        //     System.out.print(verticalCuts[i] + " ");
        // }
        // System.out.println();
        
        int mhcut = 0;
        
        int prevcut = 0;
        for(int cut = 0; cut < horizontalCuts.length; cut++) {
            int width = horizontalCuts[cut] - prevcut;
            if(width > mhcut)
                mhcut = width;
            
            prevcut = horizontalCuts[cut];
        }
        if(h - prevcut > mhcut)
            mhcut = h - prevcut;
        
        int mvcut = 0;
        
        prevcut = 0;
        for(int cut = 0; cut < verticalCuts.length; cut++) {
            int width = verticalCuts[cut] - prevcut;
            if(width > mvcut)
                mvcut = width;
            
            prevcut = verticalCuts[cut];
        }
        if(w - prevcut > mvcut)
            mvcut = w - prevcut;
        
        int mod = (int) Math.pow(10, 9) + 7;
        
        long ret = ((long)mhcut * (long)mvcut) % mod;
        return (int)ret;
    }
}