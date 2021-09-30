package DSA.leetcode;

public class Q153 {


    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){
            if(lo == hi){
                return nums[lo];
            }else if (hi == lo + 1){
                return Math.min(nums[lo], nums[hi]);
            }else{
                int mid = lo + (hi - lo)/2;
                if(nums[mid] < nums[mid - 1]){
                    return nums[mid];
                }else if(nums[mid + 1] < nums[mid]){
                    return nums[mid + 1];
                }

                if(nums[mid] > nums[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr ={3,4,5,1,2};
        Q153 test = new Q153();
        System.out.println(test.findMin(arr));
    }

}
