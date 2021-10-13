package DSA.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> val = listMap.getOrDefault(key, new ArrayList<>());
            val.add(str);
            listMap.put(key , val);
        }
        return new ArrayList<>(listMap.values());
    }

    public static void main(String[] args) {
        Q49 test = new Q49();
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        for (List<String> stringList : test.groupAnagrams(arr)) {
            System.out.println(stringList);
        }

    }

}
