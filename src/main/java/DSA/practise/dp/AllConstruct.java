package DSA.practise.dp;

import com.google.common.collect.Lists;

import java.util.*;

public class AllConstruct {

    private final String[] arr;
    private final String target;
    private ArrayList<List<String>> results = new ArrayList<>();
    Map<String, Boolean> memo = new HashMap<>();

    public AllConstruct(String[] arr, String target) {
        this.arr = arr;
        this.target = target;
    }

    private void allConstruct(int idx, List<String> solnSoFar){
        if (idx == target.length()){
            results.add(List.copyOf(solnSoFar));
        }else if (idx > target.length()){
            return;
        }

        String suffix = target.substring(idx);
        if (memo.containsKey(suffix)){
            boolean canConstructSuffix = memo.get(suffix);
            if (canConstructSuffix){
                List<String> strings = new ArrayList<>(solnSoFar);
                strings.add(suffix);
                results.add(strings);
            }
        }else {
            for (String word : arr) {
                if (suffix.startsWith(word)){
                    solnSoFar.add(word);
                    allConstruct(idx + word.length(), solnSoFar);
                    solnSoFar.remove(solnSoFar.size() - 1);
                }
            }
        }


    }

}
