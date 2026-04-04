class Solution {
    public int mySqrt(int x) {
        if(x < 2 ) return x;

        int start = 2;
        int end = x/2;
        long sqr;
        while(start<=end){
            int mid = start + (end - start)/2;
            sqr = (long) mid*mid;

            if(sqr == x){
                return mid;
            }
            else if(sqr > x){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}