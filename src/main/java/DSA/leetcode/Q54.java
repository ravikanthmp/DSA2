package DSA.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        int M = matrix.length;
        int N = matrix[0].length;
        int matrixSize = M * N;

        List<Integer> list = new LinkedList<>();
        while (list.size() != matrixSize){

            for (int i = left; i <= right && (list.size() != matrixSize); i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom && (list.size() != matrixSize); i++) {
                list.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i >= left && (list.size() != matrixSize); i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top && (list.size() != matrixSize); i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Q54 test = new Q54();
        System.out.println(test.spiralOrder(arr));
    }
}
