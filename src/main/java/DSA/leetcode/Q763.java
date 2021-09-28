package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Q763 {

    private String s;
    private String[] memo;

    public List<Integer> partitionLabels(String s) {

        this.s = s;
        this.memo = new String[s.length()];
        return f(0);
    }

    private List<Integer> f(int idx){
        if (idx == s.length()){
            return new ArrayList<>();
        }else{

            if (memo[idx] == null){
                List<Integer> res = new ArrayList<>();
                for (int j = idx; j < s.length(); j++) {
                    if (canPartition(idx, j)){
                        List<Integer> temp  = new ArrayList<>();
                        temp.add(j - idx + 1);
                        temp.addAll(f(j + 1));

                        res = temp;

                        break;
                    }
                }
                memo[idx] = toStr(res);
            }


            return toList(memo[idx]);
        }
    }

    private String toStr(List<Integer> list){
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i).append(",");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private List<Integer> toList(String s){
        String[] split = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String i : split) {
            list.add(Integer.parseInt(i));
        }
        return list;
    }

    private boolean canPartition(int startIdx, int endIdx) {

        return IntStream.rangeClosed(startIdx, endIdx)
                .noneMatch(i -> s.lastIndexOf(s.charAt(i)) > endIdx);
    }

    public static void main(String[] args) {
        String s ="ababcbacadefegdehijhklij";
        Q763 test = new Q763();
        System.out.println(test.partitionLabels(s));
    }
}
