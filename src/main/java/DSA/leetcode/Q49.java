package DSA.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Q49 test = new Q49();
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        for (List<String> stringList : test.groupAnagrams(arr)) {
            System.out.println(stringList);
        }

    }

}
