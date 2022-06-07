class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // merge greatest to least
        int i = m;
        int j = n;
        while(i >= 1 && j >= 1) {
            if(nums1[i-1] >= nums2[j-1]) {
                nums1[i+j-1] = nums1[i-1];
                i--;
            } else {
                nums1[i+j-1] = nums2[j-1];
                j--;
            }
        }
        
        while(i >= 1) {
            nums1[i+j-1] = nums1[i-1];
            i--;
        }
        
        while(j >= 1) {
            nums1[i+j-1] = nums2[j-1];
            j--;
        }
    }
}