package DSA.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Q41 {

    public int firstMissingPositive(int[] nums) {

        int N = nums.length;
        IntStream.range(0, nums.length)
                .parallel()
                .filter(i -> !inRange(nums, i))
                .forEach(i -> nums[i] = N + 1);

        Arrays.stream(nums).map(Math::abs).filter(a -> a > 0 && a <= N).filter(a -> nums[a - 1] > 0).forEach(a -> nums[a - 1] *= -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private boolean inRange(int[] nums, int i){
        return nums[i] > 0 && nums[i] <= nums.length;
    }

    public static void main(String[] args) {
        Q41 test = new Q41();
        int[] arr = {1};
        System.out.println(test.firstMissingPositive(arr));
    }

}
