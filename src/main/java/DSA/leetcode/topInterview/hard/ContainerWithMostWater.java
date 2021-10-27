package DSA.leetcode.topInterview.hard;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxSoFar = 0;
        while (i < j){
            if (height[i] < height[j]){
                maxSoFar = Math.max(maxSoFar, (j - i) * height[i]);
                i++;
            }else {
                maxSoFar = Math.max(maxSoFar, (j - i) * height[j]);
                j--;
            }
        }
        return maxSoFar;
    }

}
