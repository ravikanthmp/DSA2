package DSA.practise.progPatterns.recursion;

public class Search2DMatrix {
    private int[][] matrix;
    private int target;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;

        return search2DMatrix(0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean search2DMatrix(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowEnd < rowStart || colEnd < colStart) {
            return false;
        }

        int rowCenter = rowStart + (rowEnd - rowStart) / 2;
        int colCenter = colStart + (colEnd - colStart) / 2;

        // base case
        if (matrix[rowCenter][colCenter] == target) {
            return true;
        }

        // center row
        for (int i = colStart; i <= colEnd; i++) {
            if (matrix[rowCenter][i] == target) {
                return true;
            }
        }

        // center col
        for (int i = rowStart; i <= rowEnd; i++) {
            if (matrix[i][colCenter] == target) {
                return true;
            }
        }

        if ((rowEnd - rowStart < 4) || (colEnd - colStart) < 4) {
            return searchLinear(rowStart, colStart, rowEnd, colEnd);
        } else if (target > matrix[rowCenter][colCenter]) {

            return search2DMatrix(rowStart, colCenter + 1, rowCenter - 1, colEnd) ||
                    search2DMatrix(rowCenter + 1, colStart, rowEnd, colCenter -1 ) ||
                    search2DMatrix(rowCenter + 1, colCenter + 1, rowEnd, colEnd);

        } else {

            return search2DMatrix(rowStart, colStart, rowCenter - 1, colCenter -1 ) ||
                    search2DMatrix(rowStart, colCenter + 1, rowCenter - 1, colEnd) ||
                    search2DMatrix(rowCenter + 1, colStart, rowEnd, colCenter -1 );

        }


    }

    private boolean searchLinear(int rowStart, int colStart, int rowEnd, int colEnd) {
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(matrix, 5));
    }
}
