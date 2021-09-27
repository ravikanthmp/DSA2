package DSA.leetcode.virtual.sep182021;

public class DetectSquares {

    int[][] points;

    public DetectSquares() {
        points = new int[1001][1001];
    }

    public void add(int[] point) {
        points[point[0]][point[1]] += 1;
    }

    public int count(int[] point) {
        int ans = 0;
        int queryPointX = point[0];
        int queryPointY = point[1];
        //int[] allPointWithX = points[queryPointX];
        for (int y = 0; y < 1001; y++) {
            if (points[queryPointX][y] != 0) {
                if (y < queryPointY) {
                    int sqLength = queryPointY - y;
                    // left
                    if (queryPointX - sqLength >= 0) {
                        int tl = points[queryPointX - sqLength][queryPointY];
                        int bl = points[queryPointX - sqLength][y];
                        ans = ans + (points[queryPointX][y] * tl * bl);
                    }
                    if (((queryPointX + sqLength) < 1001)) {
                        // right
                        int tr = points[queryPointX + sqLength][queryPointY];
                        int br = points[queryPointX + sqLength][y];
                        ans = ans + (points[queryPointX][y] * tr * br);
                    }


                } else if (y > queryPointY){
                    int sqLength = y - queryPointY;
                    // left
                    if (queryPointX - sqLength >= 0) {
                        int bl = points[queryPointX - sqLength][queryPointY];
                        int tl = points[queryPointX - sqLength][y];
                        ans = ans + (points[queryPointX][y] * tl * bl);
                    }
                    if (queryPointX + sqLength < points.length) {
                        // right
                        int tr = points[queryPointX + sqLength][y];
                        int br = points[queryPointX + sqLength][queryPointY];
                        ans = ans + (points[queryPointX][y] * tr * br);
                    }

                }
            }
        }

        return ans;
    }


    public static void parseInput(DetectSquares detectSquares) {
        String[] ops = {
        "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count"};
        int[][] points = {{5, 10},{10, 5},{10, 10},{5, 5},{3, 0},{8, 0},{8, 5},{3, 5},{9, 0},{9, 8},{1, 8},{1, 0},{
        0, 0},{8, 0},{8, 8},{0, 8},{1, 9},{2, 9},{2, 10},{1, 10},{7, 8},{2, 3},{2, 8},{7, 3},{
        9, 10},{9, 5},{4, 5},{4, 10},{0, 9},{4, 5},{4, 9},{0, 5},{1, 10},{10, 1},{10, 10},{1, 1},{
        10, 0},{2, 0},{2, 8},{10, 8},{7, 6},{4, 6},{4, 9},{7, 9},{10, 9},{10, 0},{1, 0},{1, 9},{
        0, 9},{8, 1},{0, 1},{8, 9},{3, 9},{10, 9},{3, 2},{10, 2},{3, 8},{9, 2},{3, 2},{9, 8},{
        0, 9},{7, 9},{0, 2},{7, 2},{10, 1},{1, 10},{10, 10},{1, 1},{6, 10},{2, 6},{6, 6},{2, 10},{
        6, 0},{6, 2},{8, 2},{8, 0},{6, 5},{7, 4},{6, 4},{7, 5},{2, 10},{8, 4},{2, 4},{8, 10},{
        2, 6},{2, 5},{1, 5},{1, 6},{10, 9},{10, 0},{1, 9},{1, 0},{0, 9},{5, 9},{0, 4},{5, 4},{
        3, 6},{9, 0},{3, 0},{9, 6},{0, 2},{1, 1},{0, 1},{1, 2},{1, 7},{8, 0},{8, 7},{1, 0},{2, 7},{
        4, 5},{2, 5},{4, 7},{6, 7},{3, 7},{6, 4},{3, 4},{10, 2},{2, 10},{2, 2},{10, 10},{10, 1},{
        1, 10},{1, 1},{10, 10},{2, 10},{2, 9},{3, 9},{3, 10},{10, 1},{1, 10},{1, 1},{10, 10},{
        10, 4},{10, 3},{9, 4},{9, 3},{6, 6},{6, 10},{10, 6},{10, 10},{9, 7},{4, 7},{9, 2},{4, 2},{
        2, 3},{2, 1},{0, 3},{0, 1},{2, 8},{10, 8},{2, 0},{10, 0},{8, 4},{2, 10},{8, 10},{2, 4},{
        0, 0},{9, 9},{0, 9},{9, 0},{5, 7},{5, 8},{4, 7},{4, 8},{10, 10},{10, 1},{1, 1},{1, 10},{
        6, 8},{7, 8},{6, 9},{7, 9},{4, 6},{1, 6},{4, 3},{1, 3},{10, 1},{1, 10},{10, 10},{1, 1},{
        7, 7},{7, 10},{4, 7},{4, 10},{0, 0},{8, 0},{0, 8},{8, 8},{3, 5},{2, 4},{3, 4},{2, 5},{
        0, 6},{0, 2},{4, 2},{4, 6},{5, 2},{9, 6},{9, 2},{5, 6},{1, 1},{1, 10},{10, 10},{10, 1},{
        7, 5},{2, 0},{2, 5},{7, 0},{1, 9},{1, 2},{8, 2},{8, 9},{3, 8},{3, 3},{8, 3},{8, 8},{
        3, 10},{9, 10},{3, 4},{9, 4},{0, 2},{0, 10},{8, 10},{8, 2},{9, 4},{8, 4},{8, 5},{9, 5},{
        9, 8},{4, 3},{4, 8},{9, 3},{4, 9},{0, 5},{0, 9},{4, 5},{1, 3},{3, 5},{1, 5},{3, 3},{0, 0},{
        0, 8},{8, 0},{8, 8},{2, 8},{10, 0},{10, 8},{2, 0},{8, 1},{0, 9},{8, 9},{0, 1},{4, 9},{
        4, 6},{1, 9},{1, 6},{0, 9},{0, 8},{1, 9},{1, 8},{5, 1},{5, 6},{10, 1},{10, 6},{9, 2},{
        2, 2},{2, 9},{9, 9},{5, 5},{8, 5},{5, 8},{8, 8},{8, 0},{1, 0},{8, 7},{1, 7},{8, 2},{5, 5},{
        5, 2},{8, 5},{6, 6},{6, 8},{8, 6},{8, 8},{2, 10},{10, 2},{2, 2},{10, 10},{1, 9},{8, 2},{
        1, 2},{8, 9},{7, 4},{7, 2},{9, 4},{9, 2},{1, 9},{1, 0},{10, 0},{10, 9},{2, 10},{2, 3},{
        9, 10},{9, 3},{10, 0},{1, 0},{1, 9},{10, 9},{8, 10},{1, 10},{1, 3},{8, 3},{0, 9},{9, 9},{
        0, 0},{9, 0},{7, 9},{8, 9},{7, 8},{8, 8},{3, 1},{9, 7},{9, 1},{3, 7},{5, 9},{6, 9},{5, 8},{
        6, 8},{0, 1},{0, 10},{9, 10},{9, 1},{8, 0},{8, 2},{10, 2},{10, 0},{8, 0},{0, 8},{8, 8},{
        0, 0},{6, 7},{5, 8},{5, 7},{6, 8},{0, 9},{0, 2},{7, 9},{7, 2},{5, 0},{5, 5},{10, 0},{
        10, 5},{1, 10},{10, 10},{10, 1},{1, 1},{9, 2},{9, 10},{1, 2},{1, 10},{1, 10},{10, 1},{
        10, 10},{1, 1},{9, 9},{0, 9},{0, 0},{9, 0},{9, 6},{9, 3},{6, 3},{6, 6},{10, 4},{6, 0},{
        10, 0},{6, 4},{6, 8},{0, 2},{0, 8},{6, 2},{7, 9},{0, 9},{7, 2},{0, 2},{9, 1},{9, 10},{
        0, 10},{0, 1},{10, 0},{10, 9},{1, 9},{1, 0},{1, 6},{1, 9},{4, 9},{4, 6},{0, 8},{1, 9},{
        0, 9},{1, 8},{1, 1},{9, 1},{1, 9},{9, 9},{2, 5},{2, 9},{6, 5},{6, 9},{7, 3},{2, 3},{2, 8},{
        7, 8},{9, 4},{4, 4},{9, 9},{4, 9},{4, 4},{2, 4},{4, 2},{2, 2},{0, 3},{0, 2},{1, 3},{1, 2},{
        10, 9},{10, 2},{3, 2},{3, 9},{5, 6},{10, 6},{10, 1},{5, 1},{9, 0},{0, 9},{9, 9},{0, 0},{
        5, 6},{9, 2},{9, 6},{5, 2},{3, 3},{10, 3},{10, 10},{3, 10},{2, 4},{2, 10},{8, 4},{8, 10},{
        4, 9},{1, 9},{4, 6},{1, 6},{1, 8},{9, 0},{1, 0},{9, 8},{10, 3},{5, 8},{5, 3},{10, 8},{
        8, 2},{0, 10},{8, 10},{0, 2},{9, 0},{2, 7},{9, 7},{2, 0},{0, 4},{5, 9},{0, 9},{5, 4},{
        5, 3},{10, 3},{5, 8},{10, 8},{6, 4},{7, 4},{6, 5},{7, 5},{9, 1},{0, 1},{9, 10},{0, 10},{
        5, 10},{5, 7},{8, 7},{8, 10},{8, 0},{8, 7},{1, 7},{1, 0},{1, 1},{9, 9},{1, 9},{9, 1},{
        3, 1},{3, 5},{7, 5},{7, 1},{5, 8},{5, 3},{10, 8},{10, 3},{0, 9},{2, 7},{2, 9},{0, 7},{
        9, 3},{9, 7},{5, 3},{5, 7},{0, 0},{9, 0},{9, 9},{0, 9},{6, 4},{4, 2},{4, 4},{6, 2},{1, 9},{
        1, 5},{5, 5},{5, 9},{7, 7},{0, 7},{0, 0},{7, 0},{1, 3},{1, 9},{7, 3},{7, 9},{0, 9},{9, 9},{
        9, 0},{0, 0},{1, 8},{3, 6},{3, 8},{1, 6}};

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("add")){
                detectSquares.add(points[i]);
            }else {
                detectSquares.count(points[i]);
            }
        }
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        parseInput(detectSquares);
//        detectSquares.add(new int[]{419, 351});
//        detectSquares.add(new int[]{798, 351});
//        detectSquares.add(new int[]{798, 730});
//        System.out.println(detectSquares.count(new int[]{419, 730}));
        ;
//        System.out.println(detectSquares.count(new int[]{14, 8}));;
//        detectSquares.add(new int[]{11, 2});
//        System.out.println(detectSquares.count(new int[]{11, 10}));;
    }

}
