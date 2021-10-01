package DSA.leetcode;

public class Q191 {
    public int hammingWeight(int n) {
        String s = Integer.toString(n);

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q191 test = new Q191();
        System.out.println(test.hammingWeight(00000000000000000000000000001011));
    }
}
