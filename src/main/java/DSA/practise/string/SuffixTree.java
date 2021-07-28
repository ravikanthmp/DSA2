package DSA.practise.string;


import java.util.Arrays;
import java.util.Objects;

public class SuffixTree {

    private final String[] suffixes;

    public SuffixTree(String s) {
        this.suffixes = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            suffixes[i] = s.substring(i);
        }

        Arrays.sort(suffixes);
    }

    private int commonPrefixLength(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2)) {
            return 0;
        } else {
            int res = 0;
            int minLength = Math.min(s1.length(), s2.length());
            for (int i = 0; i < minLength; i++) {
                if (s1.charAt(i) == s2.charAt(1)) {
                    res++;
                } else {
                    break;
                }
            }
            return res;
        }

    }

    @Override
    public String toString() {
        return "SuffixTree{" +
                "suffixes=" + Arrays.toString(suffixes) +
                '}';
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        SuffixTree suffixTree = new SuffixTree(s);
        System.out.println(suffixTree);
    }
}
