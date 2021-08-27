package DSA.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Q128 {


    class UF{
        int[] parent;
        int[] size;

        public UF(int N) {
            this.parent = new int[N];
            this.size = new int[N];

            IntStream.range(0, N).forEach(i -> parent[i] = i);
            Arrays.fill(size, 1);
        }

        public void union(int i, int j){
            int iComponent = find(i);
            int jComponent = find(j);
            if (iComponent != jComponent){
                int sizeI = size(iComponent);
                int sizeJ = size(jComponent);

                if (sizeI >= sizeJ){
                    parent[jComponent] = iComponent;
                    size[iComponent] += sizeJ;
                }else {
                    parent[iComponent] = jComponent;
                    size[jComponent] += sizeI;
                }
            }
        }

        public int find(int i){
            while (parent[i] != i){
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public int size(int i){
            return size[i];
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        UF uf = new UF(nums.length);
        Map<Integer, Integer> componentMap = new HashMap<>();
        IntStream.range(0, nums.length).forEach(i -> componentMap.put(nums[i], i));
        int maxLength = 0;
        for (int num : nums){
            int comp1 = componentMap.get(num);
            if (componentMap.containsKey(num + 1)){
                int comp2 = componentMap.get(num + 1);
                uf.union(comp1, comp2);
                maxLength = Math.max(uf.size(uf.find(comp2)), maxLength);
                componentMap.put(num, uf.find(comp1));
                componentMap.put(num + 1, uf.find(comp2));
            }
            if (componentMap.containsKey(num - 1)){
                int comp2 = componentMap.get(num - 1);
                uf.union(comp1, comp2);
                maxLength = Math.max(uf.size(uf.find(comp2)), maxLength);
                componentMap.put(num, uf.find(comp1));
                componentMap.put(num - 1, uf.find(comp2));
            }
            maxLength = Math.max(uf.size(uf.find(comp1)), maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        Q128 test = new Q128();
        System.out.println(test.longestConsecutive(arr));
    }

}
