package DSA.leetcode.topInterview.medium;

public class Vector2D {

    private int[][] vec;

    int m, n;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        this.m = 0;
        while (m < vec.length && vec[m].length == 0){
            m++;
        }
        this.n = 0;
    }

    public int next() {
        int ans = vec[m][n];
        System.out.println(ans);
        if (n == vec[m].length - 1){
            m++;
            while (m < vec.length && vec[m].length == 0){
                m++;
            }
            n = 0;
        }else {
            n++;
        }
        return ans;
    }

    public boolean hasNext() {
        if (m < vec.length - 1){
            return true;
        }else if (m == vec.length -1 ){
            return n < vec[vec.length - 1].length;
        }else {
            return false;
        }
    }
}

