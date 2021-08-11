package DSA.practise.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    private final boolean res;
    private String target;
    private String[] arr;
    Map<String, Boolean> dp = new HashMap<>();

    public CanConstruct(String target, String[] arr){
        this.target = target;
        this.arr = arr;
        this.res = test(target);
    }

    private boolean test(String remaining) {

        if (remaining.isEmpty()) {
            return true;
        }
        if (dp.containsKey(remaining)){
            return dp.get(remaining);
        }
        boolean res = false;

        for (String prefix : arr) {
            if (remaining.equals(prefix)){
                res = true;
            }else if (remaining.startsWith(prefix)){
                res = test(remaining.substring(prefix.length()));
            }
            if (res) {
                return true;
            }
        }

        dp.put(remaining, false);
        return dp.get(remaining);
    }

    public boolean test() {
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"ab", "abc", "cd", "def", "abcd"};
        CanConstruct cc = new CanConstruct("abcdxef", s);
        System.out.println(cc.test());
    }
}
