package DSA.leetcode;

public class Q11 {
    public int maxArea(int[] height) {
        int maxSoFar = 0;
        int N = height.length;
        int i = 0;
        int j = N - 1;
        while (i < j){
            maxSoFar = Math.max(maxSoFar, Math.abs(i - j) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Q11 container = new Q11();
        int[] arr = {1, 1};
        System.out.println(container.maxArea(arr));
    }
}
