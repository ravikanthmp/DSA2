package DSA.leetcode;

import java.util.Arrays;

public class Q673 {

    public int findNumberOfLIS(int[] nums) {

        int[] lis = new int[nums.length];
        int[] freq = new int[nums.length];

        int maxLIS = 1;

        Arrays.fill(lis, 1);
        Arrays.fill(freq, 1);

        for (int i = 0; i < lis.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }

            if (lis[i] == 1){
                continue;
            }
            int f = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (lis[j] + 1 == lis[i])){
                    f++;
                }
            }

            freq[i] = f;

            maxLIS = Math.max(maxLIS, lis[i]);
        }

        int total = 0;
        for (int i = 0; i < freq.length; i++) {
            if (lis[i] == maxLIS){
                total+= freq[i];
            }
        }
        return total;

    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,3,5,4,7,2};
        Q673 test = new Q673();
        int numberOfLIS = test.findNumberOfLIS(arr);
        System.out.println(numberOfLIS);
    }

}
