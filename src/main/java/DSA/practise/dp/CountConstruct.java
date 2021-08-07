package DSA.practise.dp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CountConstruct {

    private final String target;
    private final String[] arr;
    private int count = 0;
    private Map<String, Integer> memo = new HashMap<>();

    public CountConstruct(String target, String[] arr) {
        this.target = target;
        this.arr = arr;
        this.count = test(0, new ArrayList<String>());
    }

    private int test(int suffixIdx, ArrayList<String> soFar) {
        if (suffixIdx == target.length()) {
            return 1;
        }

        if (suffixIdx > target.length()) {
            return 0;
        }

        String suffix = target.substring(suffixIdx);

        if (memo.containsKey(suffix)) {
            return memo.get(suffix);
        }

        int res = 0;

        for (String word : arr) {
            soFar.add(word);
            if (suffix.startsWith(word)) {
                res += test(suffixIdx + word.length(), soFar);
            }
            soFar.remove(soFar.size() - 1);
        }

        memo.put(suffix, res);
        return memo.get(suffix);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        String target = "abcdef";
        String[] arr = {"ab", "abc", "cd", "def", "ef", "abcd"};
        CountConstruct cc = new CountConstruct(target, arr);
        System.out.println(cc.count());
    }
}
