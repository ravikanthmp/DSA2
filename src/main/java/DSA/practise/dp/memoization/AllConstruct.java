package DSA.practise.dp.memoization;

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
            return deepClone(memo.get(suffix));
        }

        for (String word : arr) {
            if (suffix.startsWith(word)){
                List<List<String>> list = allConstruct(idx + word.length());
                if (!list.isEmpty()){
                    for (List<String> subResult : list) {
                        if (subResult.size() == 1){
                            if ("".equals(subResult.get(0))){
                                subResult.set(0, word);
                                resultList.add(subResult);
                                continue;
                            }
                        }
                        subResult.add(0, word);
                        resultList.add(subResult);
                    }
                }
            }
        }

        memo.put(suffix, resultList);
        return deepClone(memo.get(suffix));
    }

    public List<List<String>> getResults(){
        return results;
    }

    public static void main(String[] args) {
//        String[] arr = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        String[] arr = {"abc", "ab", "c", "de", "f"};
        String target = "abcdef";

        AllConstruct allConstruct = new AllConstruct(arr, target);
        for (List<String> result : allConstruct.getResults()) {
            System.out.println(result);
        }
    }

    private List<List<String>> deepClone(List<List<String>> orig){
        List<List<String>> copy = new ArrayList<>();
        orig.forEach(list -> {
            List<String> copyList = new ArrayList<>();
            copyList.addAll(list);
            copy.add(copyList);
        });
        return copy;
    }

}
