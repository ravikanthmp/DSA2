package DSA.leetcode.topInterview.hard;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int M = matrix.length;;
        int N = matrix[0].length;
        int itemsAdded = 0;
        int total = M * N;


        List<Integer> list = new LinkedList<>();

        int left = 0;
        int right = N - 1;
        int top = 0;
        int bottom = M - 1;

        while (itemsAdded < total){

            for (int col = left; col <= right && (list.size() < total); col++) {
                list.add(matrix[top][col]);
            }
            top--;


            for (int row = top; row <= bottom && (list.size() < total); row++) {
                list.add(matrix[row][right]);
            }
            right--;

            for (int col = right; col >= left && (list.size() < total) ; col--) {
                list.add(matrix[bottom][col]);
            }
            bottom++;

            for (int row = bottom; row >= top & (list.size() < total); row--) {
                list.add(matrix[row][left]);
            }
            left++;
        }

        return list;
    }

}
