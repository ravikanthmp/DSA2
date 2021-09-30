package DSA.leetcode;

public class Q152 {

    public int maxProduct(int[] nums){
        int[][] tab = new int[2][nums.length];
        tab[0][nums.length - 1] = nums[nums.length -1];
        tab[1][nums.length - 1] = nums[nums.length -1];


        int maxSoFar = tab[0][nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0){
                tab[0][i] = 0;
                tab[1][i] = 0;
            }else if (nums[i] > 0){

                if (tab[0][i + 1] <= 0){
                    tab[0][i] = nums[i];
                }else {
                    tab[0][i] = nums[i] * tab[0][i + 1];
                }

                if (tab[1][i + 1] == 0){
                    tab[1][i] = nums[i];
                }else {
                    tab[1][i] = nums[i] * tab[1][i  + 1];
                }

            }else {
                tab[0][i] = (tab[1][i + 1] != 0) ? nums[i] * tab[1][i + 1] : nums[i];
                tab[1][i] = (tab[0][i + 1] != 0) ? nums[i] * tab[0][i + 1] : nums[i];
            }
            maxSoFar = Math.max(tab[0][i], maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        Q152 test = new Q152();
        System.out.println(test.maxProduct(arr));
    }
}
