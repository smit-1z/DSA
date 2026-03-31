class Solution {
    int p1 = 0;
    int p2 = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        if(size % 2 == 0){
            for(int i=0;i<(size-1)/2;i++){
                getNext(nums1,nums2);
            }
            return (double) ((getNext(nums1,nums2) + getNext(nums1,nums2))/2.0);
        }else{
            for(int i=0;i<(size)/2;i++){
                getNext(nums1,nums2);
            }

            return (double) getNext(nums1,nums2);
        }
    }

    public double getNext(int[] nums1, int[] nums2){
        if(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2]){
                return (double) nums1[p1++];
            }else{
                return (double) nums2[p2++];
            }
        }

         if(p1 < nums1.length){
            return nums1[p1++];
         }

         if(p2 < nums2.length){
            return nums2[p2++];
         }
         return 0.0;
         
    }
}
