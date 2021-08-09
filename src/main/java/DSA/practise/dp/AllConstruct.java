package DSA.practise.dp;

import com.google.common.collect.Lists;

import java.util.*;

public class AllConstruct {

    private final String[] arr;
    private final String target;
    private List<List<String>> results = new ArrayList<>();
    Map<String, List<List<String>>> memo = new HashMap<>();

    public AllConstruct(String[] arr, String target) {
        this.arr = arr;
        this.target = target;
        this.results = allConstruct(0);
    }

    private List<List<String>> allConstruct(int idx){
        if (idx > target.length()) {
            return Collections.EMPTY_LIST;
        }
        List<List<String >> resultList = new ArrayList<>();

        if (idx == target.length()){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            resultList.add(list);
            return resultList;
        }

        String suffix = target.substring(idx);
        if (memo.containsKey(suffix)){
            return new ArrayList(memo.get(suffix));
        }

        for (String word : arr) {
            if (suffix.startsWith(word)){
                List<List<String>> list = allConstruct(idx + word.length());
                if (!list.isEmpty()){
                    for (List<String> subResult : list) {
                        subResult.add(0, word);
                        resultList.add(subResult);
                    }
                }
            }
        }

        memo.put(suffix, resultList);
        return new ArrayList(memo.get(suffix));
    }

    public List<List<String>> getResults(){
        return results;
    }

    public static void main(String[] args) {
//        String[] arr = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        String[] arr = {"abc", "def", "ab", "c", "de", "f"};
        String target = "abcdef";

        AllConstruct allConstruct = new AllConstruct(arr, target);
        for (List<String> result : allConstruct.getResults()) {
            System.out.println(result);
        }


    }

}
