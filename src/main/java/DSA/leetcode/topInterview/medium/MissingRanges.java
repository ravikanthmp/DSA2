package DSA.leetcode.topInterview.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res= new ArrayList<>();

        int expected = lower;
        for (int actual : nums) {
            if (expected != actual) {
                int missingFrom = expected;
                int missingUntil = actual - 1;
                if (missingUntil == missingFrom) {
                    res.add(String.valueOf(missingFrom));
                } else {
                    res.add(String.valueOf(missingFrom) + "->" + String.valueOf(missingUntil));
                }
            }
            expected = actual + 1;
        }

        if (expected <= upper){
            int missingFrom = expected;
            int missingUntil = upper;
            if (missingUntil == missingFrom) {
                res.add(String.valueOf(missingFrom));
            } else {
                res.add(String.valueOf(missingFrom) + "->" + String.valueOf(missingUntil));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        MissingRanges test = new MissingRanges();
        System.out.println(test.findMissingRanges(arr, lower, upper));
    }

}
