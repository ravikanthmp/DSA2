package DSA.leetcode;

public class Q75 {

    public void sortColors(int[] nums) {

        sort(nums, 0, nums.length -1);
    }

    private void sort(int[] nums, int lo, int hi){
        int i = lo;
        int pivot = 1;
        int lt = i;
        int gt = hi;
        while (i <= gt){
            int cmp = Integer.compare(nums[i], pivot);
            if (cmp == 0){
                i++;
            }else if (cmp < 0){
                exch(nums, i++, lt++);
            }else {
                exch(nums, i, gt--);
            }
        }
    }

    private void exch(int[] nums, int lo, int hi){
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

}
