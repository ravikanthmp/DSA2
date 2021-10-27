package DSA.leetcode.topInterview.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LongestConsequentSequence {


    class UF{
        int n;
        int[] size;
        int[] comp;

        public UF(int n){
            this.n = n;
            this.size = new int[n];
            this.comp = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < comp.length; i++) {
                comp[i] = i;
            }
        }

        private int size(int i){
            return size[i];
        }

        private int find(int i){
            while (comp[i] != i){
                comp[i] = comp[comp[i]];
                i = comp[i];
            }
            return comp[i];
        }

        public void union(int i, int j){
            int compI = find(i);
            int compJ = find(j);

            if (compI == compJ){
                return;
            }
            if (size[compI] >= size[compJ]){
                comp[compJ] = compI;
                size[compI] += size[compJ];
            }else {
                comp[compI] = compJ;
                size[compJ] += size[compI];
            }
        }

        public int maxSize(){

            OptionalInt max = IntStream
                    .range(0, comp.length)
                    .filter(i -> comp[i] == i)
                    .map(i -> size(i))
                    .max();
            return max.orElse(1);

        }
    }
    public int longestConsecutive(int[] nums) {

        UF uf = new UF(nums.length);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int num : nums) {
            if (map.containsKey(num - 1)){
                uf.union(map.get(num), map.get(num - 1));
            }

            if (map.containsKey(num + 1)){
                uf.union(map.get(num), map.get(num + 1));
            }
        }

        return uf.maxSize();
    }

    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        LongestConsequentSequence lcs = new LongestConsequentSequence();
        System.out.println(lcs.longestConsecutive(arr));
    }

}
