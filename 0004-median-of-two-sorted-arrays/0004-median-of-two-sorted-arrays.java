class Solution {
        int p = 0;
        int q = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        if (size % 2 == 0) {
            for (int i = 0; i < (size-2)/2; i++) {
                getNext(nums1,nums2);
            }
            return  (getNext(nums1,nums2) +  getNext(nums1,nums2))/2.0;
        }else{
            for(int i=0;i<(size-1)/2;i++){
               getNext(nums1,nums2);  
            }
             return getNext(nums1,nums2);
        }
    }

    public double getNext(int[] nums1, int[] nums2){
        if(p>=0 && q>=0 && p<nums1.length && q<nums2.length){
            if(nums1[p] < nums2[q]){
                return nums1[p++];
            }else{
                return nums2[q++];
            }
        }


        if(p>=0 && p<nums1.length){
             return nums1[p++];
        }else{
            return nums2[q++];
        }

    }
}
