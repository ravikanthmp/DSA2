package DSA.leetcode.contest.weekly261;

public class Q5890 {

    public int minimumMoves(String s) {
        int i = 0;
        int count = 0;
        while (i < s.length()){
            if (s.charAt(i) == 'X'){
                count++;
                i += 3;
            }else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "XXOX";
        Q5890 test = new Q5890();
        System.out.println(test.minimumMoves(s));
    }

}
