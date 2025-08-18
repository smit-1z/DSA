class Solution {
    int p1 = 0;
    int p2 =0;

    public int getMin(int[] nums1, int[] nums2){
        if(p1 < nums1.length && p2<nums2.length){
            if(nums1[p1]< nums2[p2]){
                return nums1[p1++];
            }else{
                return nums2[p2++];
            }
        }else if(p1 < nums1.length){
            return nums1[p1++];
        }
        else{
            return nums2[p2++];
        }

        
    }   
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        if (size % 2 == 0) {
            for (int i = 0; i < size/2-1; i++) {
                getMin(nums1,nums2);
            }
            return (getMin(nums1,nums2) +  getMin(nums1,nums2))/2.0;
        }else{
            for (int i = 0; i < size/2; i++) {
                getMin(nums1,nums2);
            }
            return (double) getMin(nums1,nums2);
        }
    
    }
}