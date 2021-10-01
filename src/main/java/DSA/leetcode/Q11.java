package DSA.leetcode;

public class Q11 {
    public int maxArea(int[] height) {
      int right = height.length - 1;
      int left = 0;
      int maxSoFar = 0;
      while (left < right){
          int area = (right - left) * (Math.min(height[left], height[right]));
          maxSoFar = Math.max(maxSoFar, area);
          if (height[left] <= height[right]){
              left++;
          }else {
              right--;
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
