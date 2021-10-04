package DSA.leetcode;

public class Q213 {


    public int rob(int[] nums, int lo ,int hi) {
        int size = hi - lo + 1;
        int[] tab = new int[nums.length];
        if (size == 1){
            return nums[hi];
        }else if (size == 2){
            return Math.max(nums[lo], nums[hi]);
        }else {
            tab[hi] = nums[hi];
            tab[hi - 1] = Math.max(nums[hi - 1], nums[hi]);
            for (int i = hi - 2; i >= lo; i--) {
                tab[i] = Math.max(tab[i  + 1], nums[i] + tab[i  + 2]);
            }
            return tab[lo];
        }
    }



    public int rob(int[] nums) {
        return Math.max(
                rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1)
        );

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        Q213 test = new Q213();
        System.out.println(test.rob(arr));
    }
}
