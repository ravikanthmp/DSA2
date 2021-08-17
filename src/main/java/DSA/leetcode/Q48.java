package DSA.leetcode;

public class Q48 {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void transpose(int[][] matrix){
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                if (i == j){
                    continue;
                }
                exch(matrix, i, j, j, i);
            }
        }
    }

    private void reflect(int[][] matrix){
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N/2; j++) {
                exch(matrix, i, j, i, N - 1 - j);
            }
        }
    }

    private void exch(int[][] matrix, int i1, int j1, int i2, int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
