package DSA.practise.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstructV2FollowingTemplate {
    private boolean res;
    private String target;
    private String[] arr;
    Map<String, Boolean> dp = new HashMap<>();

    public CanConstructV2FollowingTemplate(String target, String[] arr){
        this.target = target;
        this.arr = arr;
        this.res = test(0);
    }

    private boolean test(int idx) {

        if (this.res){
            // short circuit...
            return true;
        }

        if (idx == target.length()){
            return true;
        }
        if (idx > target.length()){
            return false;
        }
        String remaining = target.substring(idx);
        if (dp.containsKey(remaining)){
            return dp.get(remaining);
        }
        boolean res = false;

        for (String prefix : arr) {
            if (remaining.startsWith(prefix)){
                res = test(idx + prefix.length());
            }
            if (res) {
                this.res = true;
            }
        }

        dp.put(remaining, res);
        return dp.get(remaining);
    }

    public boolean test() {
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"ab", "abc", "cd", "def", "abcd"};
        CanConstructV2FollowingTemplate cc = new CanConstructV2FollowingTemplate("abcdef", s);
        System.out.println(cc.test());
    }
}
